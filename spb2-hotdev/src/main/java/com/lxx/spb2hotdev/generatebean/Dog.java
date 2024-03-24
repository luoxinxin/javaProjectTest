package com.lxx.spb2hotdev.generatebean;

import com.lxx.spb2hotdev.annotation.MyAnnotation;
import lombok.Data;

@Data
public class Dog {
    @MyAnnotation("名字")
    private String name;
    @MyAnnotation("年龄")
    private Integer age;
}
