package com.lxx.spb2hotdev.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lxx.spb2hotdev.bean.Cat;
import com.lxx.spb2hotdev.bean.Dog;

import java.io.IOException;

public class ConvertObjectToJson {
    public static void main(String[] args) {
        // 创建一个Person对象
        Dog dog = new Dog();
//        dog.setName("");
//        dog.setAge(0);
//        Cat cat = new Cat();
//        cat.setName("");
//        cat.setAge(0);
//        dog.setCat(cat);
        // 初始化Jackson的ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        try {
            // 将Person对象转为JSON字符串
            String json = objectMapper.writeValueAsString(dog);
            System.out.println("dog: " + json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
