package com.springbootdemo.schedule;

import com.springbootdemo.sdk.schedule.JobDetailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tanjianhui on 2017/2/7.
 */
@Component("scheduleManagerTask")
public class ScheduleManagerTask {
    @Autowired
    private JobDetailManager jobDetailManager;

    public void execute() {
        jobDetailManager.manageJobDetail();
    }
}
