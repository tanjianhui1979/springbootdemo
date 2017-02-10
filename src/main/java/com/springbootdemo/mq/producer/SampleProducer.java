package com.springbootdemo.mq.producer;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tanjianhui on 2017/2/8.
 */
@Component("sampleProducer")
public class SampleProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue rabbitQueue;

    public void send(){
        rabbitTemplate.convertAndSend("Hello, world!");
    }
}
