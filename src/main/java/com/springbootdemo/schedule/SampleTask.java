package com.springbootdemo.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by tanjianhui on 2017/2/10.
 */
@Service("sampleTask")
public class SampleTask {
    private static final Logger logger = LoggerFactory.getLogger(SampleTask.class);
    public void execute(){
        logger.info("Hello, world!");
    }
}
