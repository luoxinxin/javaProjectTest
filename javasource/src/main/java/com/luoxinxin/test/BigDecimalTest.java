package com.luoxinxin.test;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void testDouble(double num){
        System.out.println(num);
        System.out.println(num);
        BigDecimal bigDecimal1 = new BigDecimal(num);
        BigDecimal bigDecimal2 = new BigDecimal(num + "");

        System.out.println(bigDecimal1);
        System.out.println(bigDecimal2);
    }

    public static void main(String[] args) {
        testDouble(1.000000000000001);
    }
}
