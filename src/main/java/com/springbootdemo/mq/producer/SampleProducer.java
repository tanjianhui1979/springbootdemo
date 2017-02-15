package com.springbootdemo.mq.producer;

import com.rabbitmq.client.AMQP;
import com.springbootdemo.model.ScheduleTaskMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tanjianhui on 2017/2/8.
 */
@Component("sampleProducer")
public class SampleProducer {
    private static final Logger logger = LoggerFactory.getLogger(SampleProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(){
        rabbitTemplate.convertAndSend("Hello, world!");
    }

    public void send(ScheduleTaskMonitor record){
        rabbitTemplate.convertAndSend(record);
    }
}
