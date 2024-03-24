package com.lxx.spb2hotdev;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lxx.spb2hotdev")
public class Spb2HotdevApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spb2HotdevApplication.class, args);
    }

}
