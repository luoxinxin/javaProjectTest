package com.lxx.spb2hotdev.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProducerController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/sendMessage/{message}")
    public void sendMessage(@PathVariable("message") String message) {
        kafkaTemplate.send("test", message);
//        kafkaTemplate.send("test", message, )
    }
}
