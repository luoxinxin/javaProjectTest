package com.luoxinxin.component;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "q_hello")
public class HelloReceiver {
    @RabbitHandler
    public void process(String now){
        System.out.println("消费者"+now);
    }
}
