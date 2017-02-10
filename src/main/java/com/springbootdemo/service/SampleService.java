package com.springbootdemo.service;

import com.springbootdemo.mq.consumer.SampleConsumer;
import com.springbootdemo.mq.producer.SampleProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tanjianhui on 2017/2/7.
 */
@Service("sampleService")
public class SampleService {
    private static final Logger logger = LoggerFactory.getLogger(SampleService.class);

    @Autowired
    private SampleProducer sampleProducer;

    public void doIt(){
        logger.info("sending ...");
        sampleProducer.send();
        logger.info("Sent ...");
    }
}
