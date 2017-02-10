package com.springbootdemo.sdk.schedule;

import com.springbootdemo.model.ScheduleTask;
import com.springbootdemo.service.ScheduleTaskService;
import org.quartz.*;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("jobDetailManager")
public class JobDetailManager implements ApplicationContextAware {

	private static final Logger logger = LoggerFactory.getLogger(JobDetailManager.class);

	/** Job Detail 后缀 */
	private static final String JOB_DETAIL_SUFFIX = "JobDetail";
	/** Trigger的后缀 */
	private static final String TRIGGER_SUFFIX = "Trigger";

	@Autowired
	private ScheduleTaskService scheduleTaskService;

	@Autowired
	private Scheduler quartzScheduler;

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public void manageJobDetail() {
		
		logger.info("Job manager starting scan the jobs DB.");
		
		//查询未调度的任务
		List<ScheduleTask> notSchedulingTaskList = this.scheduleTaskService.getNotSchedulingTaskList();
		
		//调度完成的任务列表，需要批量更新状态为已调度
		List<ScheduleTask> schedulingTaskList = new ArrayList<>();
		
		//循环将执行任务调度
		for(ScheduleTask scheduleTask : notSchedulingTaskList){

			//按照任务类型执行对应的调度
			switch (OperationType.getOperationType(scheduleTask.getOperation())) {
				case ADD: {
					try{
						this.scheduleJob(scheduleTask);
					}catch(Exception e){
						logger.error("Can not add a job.", e);
						continue;
					}
					scheduleTask.setStatus(ScheduleStatus.YES.getKey());
					schedulingTaskList.add(scheduleTask);
					break;
				}
				case PAUSE: {
					logger.info("Pause..................");
					try{
						this.stopJob(scheduleTask);
					}catch(Exception e){
						logger.error("Can not pause a job.", e);
						continue;
					}
					schedulingTaskList.add(scheduleTask);
					scheduleTask.setStatus(ScheduleStatus.YES.getKey());
					break;
				}
				case RESUME: {
					logger.info("Resume..................");
					try{
						this.scheduleJob(scheduleTask);
					}catch(Exception e){
						logger.error("Can not resume a job.", e);
						continue;
					}
					schedulingTaskList.add(scheduleTask);
					scheduleTask.setStatus(ScheduleStatus.YES.getKey());
					break;
				}
				case Other: {
					break;
				}
				default:
			}
		}
		//更新已经调度的任务
		if(schedulingTaskList != null && !schedulingTaskList.isEmpty())
			this.scheduleTaskService.updateStatusBatch(schedulingTaskList);
		
		logger.info("Job manager ending scan the jobs DB.");
		
	}

	public void scheduleJob(ScheduleTask scheduleTask) throws Exception {
		//获取Job Detail
		JobDetailImpl jobDetail = (JobDetailImpl) applicationContext.getBean(scheduleTask.getJobName() + JOB_DETAIL_SUFFIX);
		//Cron表达式，用来生成CronTrigger
		String cronExpression = scheduleTask.getCronExpression();
		// Job 参数
		String arguments = scheduleTask.getArgument();
		if (arguments != null) {
			jobDetail.getJobDataMap().put("arguments", arguments);
		}

		this.quartzScheduler.addJob(jobDetail, true);

		CronTriggerImpl cronTrigger = new CronTriggerImpl();
		cronTrigger.setName(scheduleTask.getJobName() + TRIGGER_SUFFIX);
		cronTrigger.setGroup(Scheduler.DEFAULT_GROUP);
		cronTrigger.setJobName(jobDetail.getName());
		cronTrigger.setJobGroup(Scheduler.DEFAULT_GROUP);
		cronTrigger.setCronExpression(cronExpression);

		if (null == this.quartzScheduler.getTrigger(cronTrigger.getKey())) {
			this.quartzScheduler.scheduleJob(cronTrigger);
		} else {
			this.quartzScheduler.rescheduleJob(cronTrigger.getKey(), cronTrigger);
		}
	}

	public void stopJob(ScheduleTask scheduleTask) throws SchedulerException {
		//获取Job Detail
		JobDetailImpl jobDetail = (JobDetailImpl) applicationContext.getBean(scheduleTask.getJobName() + JOB_DETAIL_SUFFIX);

		this.quartzScheduler.pauseJob(jobDetail.getKey());
	}
	
}
