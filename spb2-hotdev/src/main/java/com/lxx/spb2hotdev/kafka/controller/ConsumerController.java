package com.lxx.spb2hotdev.kafka.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class ConsumerController {

    @KafkaListener(topics = {"test"}, containerGroup = "default-group")
    public void comsumerTopic1(String msg) {
        System.out.println(msg+1234444);
    }


    @KafkaListener(topics = {"test"}, containerGroup = "group1")
    public void comsumerTopic2(String msg) {
        System.out.println(msg+1234444);
    }
}
