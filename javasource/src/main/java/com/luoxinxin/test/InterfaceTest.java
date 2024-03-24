package com.luoxinxin.test;

public interface InterfaceTest {
    int a = 1;
    static void test() {
        System.out.println("test");
    }
    default void test1(){
        System.out.println();
    }
}
