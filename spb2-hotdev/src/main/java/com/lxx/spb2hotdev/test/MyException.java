package com.lxx.spb2hotdev.test;

public class MyException {
    public static void main(String[] args) {
        try {
            if (1 != 2) {
                test();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void test() {
        if (1 != 2) {
            throw new RuntimeException("123");
        }
    }
}
