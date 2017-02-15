package com.springbootdemo.mq.consumer;

import com.springbootdemo.dao.ScheduleTaskMonitorMapper;
import com.springbootdemo.model.ScheduleTaskMonitor;
import com.springbootdemo.model.ScheduleTaskMonitorExample;
import com.springbootdemo.service.ScheduleTaskMonitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by tanjianhui on 2017/2/8.
 */
@Component("sampleConsumer")
public class SampleConsumer {
    private static final Logger logger = LoggerFactory.getLogger(SampleConsumer.class);

    @Autowired
    private ScheduleTaskMonitorService scheduleTaskMonitorService;

    public void listen(String str) {
        logger.info(str);
    }

    public void listen(ScheduleTaskMonitor record){
        record.setStatus("3");
        record.setRemark("作业处理中");
        scheduleTaskMonitorService.updateRequestNew(record);

        try {
            logger.info("Receive ... [scheduleTaskId: {}], [extText: {}]", record.getScheduleTaskId());
        }catch (Exception e){
            logger.error("作业处理异常...", e);

            record.setStatus("9");
            try(StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter)) {
                e.printStackTrace(printWriter);
                record.setRemark("作业处理异常。\n" + stringWriter.toString());
            }catch(IOException ioe){
                record.setRemark("作业处理异常。详情请查看日志文件。");
            }
        }

        record.setStatus("4");
        record.setRemark("作业处理完成");
        scheduleTaskMonitorService.updateRequestNew(record);
    }
}
