package com.lxx.spb2hotdev.service;

import com.lxx.spb2hotdev.bean.Cat;
import com.lxx.spb2hotdev.bean.Dog;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public Dog hello(Cat cat){
        return new Dog();
    }
}
