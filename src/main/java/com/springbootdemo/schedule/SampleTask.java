package com.springbootdemo.schedule;

import com.springbootdemo.model.ScheduleTaskMonitor;
import com.springbootdemo.mq.producer.SampleProducer;
import com.springbootdemo.service.ScheduleTaskMonitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/**
 * Created by tanjianhui on 2017/2/10.
 */
@Service("sampleTask")
public class SampleTask {
    private static final Logger logger = LoggerFactory.getLogger(SampleTask.class);

    @Autowired
    private SampleProducer sampleProducer;

    @Autowired
    private ScheduleTaskMonitorService scheduleTaskMonitorService;

    public void execute(){

        logger.info("Executing...");

        // 新增监控记录
        ScheduleTaskMonitor scheduleTaskMonitor = new ScheduleTaskMonitor();
        scheduleTaskMonitor.setScheduleTaskId(1);
        scheduleTaskMonitor.setStatus("1");
        scheduleTaskMonitor.setCreateBy("Scheduler");
        scheduleTaskMonitor.setCreateTime(new Date());
        scheduleTaskMonitor.setJobAnticipateEndTime(new Date(System.currentTimeMillis() + 60000)); // 1 min
        scheduleTaskMonitor.setJobMaxAnticipateEndTime(new Date(System.currentTimeMillis() + 300000)); // 5 min
        scheduleTaskMonitor.setRemark("任务开始\n");
        scheduleTaskMonitor.setJobStartTime(scheduleTaskMonitor.getCreateTime());
        try {
            scheduleTaskMonitorService.addRequestNew(scheduleTaskMonitor);
        }catch (Exception e){
            logger.error("Fail to add 'ScheduleTaskMonitor' record.", e);
            return ;
        }

        // 发送消息
        try {
            logger.info("sending ...");
            sampleProducer.send(scheduleTaskMonitor);
            logger.info("Sent ...");
        }catch (Exception e){
            logger.error("Sending excepton...", e);

            scheduleTaskMonitor.setStatus("9");

            try(StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter)) {
                e.printStackTrace(printWriter);
                scheduleTaskMonitor.setRemark("发布消息异常。\n" + stringWriter.toString());
            }catch(IOException ioe){
                scheduleTaskMonitor.setRemark("发布消息异常。详情请查看日志文件。");
            }

            scheduleTaskMonitorService.updateRequestNew(scheduleTaskMonitor);

            logger.info("Failing...");
            return ;
        }

        // 更新监控记录状态
        scheduleTaskMonitor.setStatus("2");
        scheduleTaskMonitorService.updateRequestNew(scheduleTaskMonitor);

        logger.info("Executed...");
    }
}
