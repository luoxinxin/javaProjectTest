package com.macro.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class EurekaClientController {
    @Value("${spring.application.name}")
    private String serviceId;
    @Value("${server.port}")
    private String servicePort;

    @GetMapping("/info")
    public Object info() {
        return "Info from service:" + serviceId + " port:" + servicePort+"!";
    }
}
