package com.lxx.spb2hotdev.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ac {
    public static void main(String[] args) {
        BeanFactory bf;
        ApplicationContext ac;
        ClassPathXmlApplicationContext acx = new ClassPathXmlApplicationContext("classpath:spring.xml");
    }
}
