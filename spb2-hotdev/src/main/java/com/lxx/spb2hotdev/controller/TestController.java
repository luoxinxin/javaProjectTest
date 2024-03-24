package com.lxx.spb2hotdev.controller;


import com.lxx.spb2hotdev.annotation.PreventDuplicateSubmit;
import com.lxx.spb2hotdev.bean.Cat;
import com.lxx.spb2hotdev.bean.Dog;
import com.lxx.spb2hotdev.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class TestController {

    public void hello10(){
        System.out.printf("sss");
    }

    private void hello11(){
        System.out.printf("sss");
    }
    protected void hello12(){
        System.out.printf("sss");
    }

     void hello13(){
         System.out.printf("sss");
    }

    @Autowired
    private HelloService helloService;

    @PreventDuplicateSubmit()
    @PostMapping("/test")
    public String hello(@Valid @RequestBody Cat cat){
        return "1";
    }

    @RequestMapping("/test1")
    public Dog hello1(){
        Dog dog = new Dog();
        dog.setName("huahua");
        dog.setAge(12);
        return dog;
    }

    @RequestMapping("/test2")
    @Transactional
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

    @RequestMapping("/thread")
    public String thread(){
        // 创建并启动两个线程
        Thread thread1 = new Thread(new MultiThreadExample.Task("Thread 1"));
        Thread thread2 = new Thread(new MultiThreadExample.Task("Thread 2"));
        thread1.start();
        thread2.start();
        return "hello12343243";
    }

    @RequestMapping("/requestTest")
    public String requestTest(HttpServletRequest request){
        Object obj = new Object();
        String clientTimeHeaderValue = request.getHeader("X-Client-Time");
        return clientTimeHeaderValue;
    }

//    public String requestHolder(){
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        HttpServletRequest httpServletRequest = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
//
//
//
//        return requestAttributes
//    }







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
