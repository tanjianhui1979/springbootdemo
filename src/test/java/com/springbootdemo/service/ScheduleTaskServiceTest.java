package com.springbootdemo.service;

import com.springbootdemo.model.ScheduleTask;
import com.springbootdemo.model.ScheduleTaskExample;
import com.springbootdemo.service.ScheduleTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(locations = {"classpath*:spring/*.xml"})
public class ScheduleTaskServiceTest extends AbstractTestNGSpringContextTests {
    private static final Logger logger = LoggerFactory.getLogger(ScheduleTaskService.class);

    @Autowired
    private ScheduleTaskService scheduleTaskService;

    @Test
    public void countByExampleTest(){
        ScheduleTaskExample scheduleTaskExample = new ScheduleTaskExample();
        logger.info(">>>>>>>>>>>>>>>>>>>>>{}>>>>>>>>>>>>>>>>>>>>>>>>>>",
                this.scheduleTaskService.countByExample(scheduleTaskExample));
    }

    @Test
    public void updateStatusBatchTest(){
        List<ScheduleTask> scheduleTaskList = new ArrayList<>();

        ScheduleTask scheduleTask = new ScheduleTask();
        scheduleTask.setId(4);
        scheduleTask.setStatus("1");
        scheduleTaskList.add(scheduleTask);

        logger.info("scheduleTaskService.updateStatusBatch return : {}",
                scheduleTaskService.updateStatusBatch(scheduleTaskList));
    }
}
