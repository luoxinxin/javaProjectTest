package com.luoxinxin.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        LocalDate now = LocalDate.now();
        LocalDate yesterday = LocalDate.of(2022,3,8);
        int year = LocalDate.now().getYear();
        Month month = LocalDate.now().getMonth();

        LocalTime time = LocalTime.now();

        LocalDateTime dateTime = LocalDateTime.now();
     /*   System.out.println(now);
        System.out.println(time);
        System.out.println(dateTime);*/

        this.rabbitTemplate.convertAndSend("q_hello",now.toString());

    }
}
