package com.springbootdemo.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by tanjianhui on 2017/2/8.
 */
@Component("sampleConsumer")
public class SampleConsumer {
    private static final Logger logger = LoggerFactory.getLogger(SampleConsumer.class);

    public void listen(String str) {
        logger.info(str);
    }
}
