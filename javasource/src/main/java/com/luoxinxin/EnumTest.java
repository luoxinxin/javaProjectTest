package com.luoxinxin;

enum EnumTest1 {

    FIRST;

    private EnumTest1(){
        System.out.println("hello");
    }
}

public class EnumTest {

    public static void main(String[] args) {
        System.out.println(EnumTest1.FIRST);
    }
}
