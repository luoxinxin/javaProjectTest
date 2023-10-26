package com.lxx.spb2hotdev.controller;


import com.lxx.spb2hotdev.bean.Cat;
import com.lxx.spb2hotdev.bean.Dog;
import com.lxx.spb2hotdev.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class TestController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/test")
    public String hello(){
        return "hello12343243";
    }

    @RequestMapping("/test1")
    public Dog hello1(){
        Dog dog = new Dog();
        dog.setName("huahua");
        dog.setAge(12);
        return dog;
    }

    @RequestMapping("/test2")
    public Map<String, Object> hello2(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "hello");
        map.put("age", 12);
        return map;
    }

    @RequestMapping("/test3")
    public ResponseEntity hello3(){
        return new ResponseEntity<>(new String("123"), new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping("/hello")
    public String helloService(){
        Class<Dog> serviceClass = Dog.class;
        Field[] fields = serviceClass.getDeclaredFields();
        for (Field field : fields) {
            String name = field.getName();
            System.out.println(name);
            String fieldComment = getFieldComment(field);
            System.out.println(fieldComment);
        }


        helloService.hello(new Cat());
        return "hello12343243";
    }

    public static String getFieldComment(Field field) {
        // 获取字段的块注释
        String fieldSource = field.toString();
        String fieldComment = null;

        // 使用正则表达式提取块注释
        Pattern pattern = Pattern.compile("/\\*\\*(.*?)\\*/", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(fieldSource);

        if (matcher.find()) {
            fieldComment = matcher.group(1).trim();
        }

        return fieldComment;
    }


}
