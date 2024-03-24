package com.lxx.spb2hotdev.test;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal a = BigDecimal.ZERO;
        test1(a);
        System.out.println(a);

        StringBuilder sb = new StringBuilder();
        test2(sb);
        System.out.println(sb.toString());
    }
    public static void test1(BigDecimal i) {
        i.add(BigDecimal.TEN);
        i = new BigDecimal(i.add(BigDecimal.TEN).toString());
    }

    public static void test2(StringBuilder sb) {
        sb.append("123");
    }
}
