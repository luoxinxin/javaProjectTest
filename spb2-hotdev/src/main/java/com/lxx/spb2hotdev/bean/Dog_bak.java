package com.lxx.spb2hotdev.bean;

import lombok.Data;

@Data
public class Dog_bak {
    @MyAnnotation("名字")
    private String name;
    @MyAnnotation("年龄")
    private Integer age;
}
