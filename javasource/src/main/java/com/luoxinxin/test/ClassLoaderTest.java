package com.luoxinxin.test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Driver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ClassLoaderTest {
    int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        classLoaderTest.compute();
//        String;
//        Enum;
//        Number;
//        Long;
//        Double;
//        BigInteger;
//        BigDecimal;
//        AtomicInteger;
//        AtomicStampedReference;
//        Thread;
//        ClassLoader;
    }
}
