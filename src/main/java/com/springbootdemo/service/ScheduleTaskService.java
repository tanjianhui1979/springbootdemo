package com.springbootdemo.service;

import com.springbootdemo.dao.ScheduleTaskMapper;
import com.springbootdemo.model.ScheduleTask;
import com.springbootdemo.model.ScheduleTaskExample;
import com.springbootdemo.sdk.schedule.ScheduleStatus;
import com.springbootdemo.sdk.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by tanjianhui on 2017/2/9.
 */
@Service("scheduleTaskService")
public class ScheduleTaskService extends BaseService<Integer,ScheduleTask,ScheduleTaskExample, ScheduleTaskMapper> {

    @Autowired
    private ScheduleTaskMapper scheduleTaskMapper;

    @Override
    protected ScheduleTaskMapper getMapper() {
        return scheduleTaskMapper;
    }

    public List<ScheduleTask> getNotSchedulingTaskList(){
        ScheduleTaskExample scheduleTaskExample = new ScheduleTaskExample();
        scheduleTaskExample.createCriteria().andStatusEqualTo(ScheduleStatus.NO.getKey());
        return this.scheduleTaskMapper.selectByExample(scheduleTaskExample);
    }

    public int updateStatusBatch(List<ScheduleTask> scheduleTaskList){
        Date now = new Date();
        for(ScheduleTask scheduleTask : scheduleTaskList){
            scheduleTask.setLastUpdateBy("schedule");
            scheduleTask.setLastUpdateTime(now);
        }
        return this.scheduleTaskMapper.updateStatusBatch(scheduleTaskList);
    }
}
