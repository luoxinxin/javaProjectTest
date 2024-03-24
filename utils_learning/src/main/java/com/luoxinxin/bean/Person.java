package com.luoxinxin.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private static final long serialVersionUID = 8850644351946135067L;
    private String name;
    private Integer age;
    private Hand hand;
}
