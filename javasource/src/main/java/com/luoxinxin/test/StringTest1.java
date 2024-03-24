package com.luoxinxin.test;

public class StringTest1 {
    public static void main(String[] args) {
        subStringTest1();
    }

    private static void subStringTest1() {
        String a = "1,22,3,4,567890";
        String substring = a.substring(a.indexOf("22"));
        System.out.println(substring);
        String[] split = substring.split(",");
        System.out.println(split.length);
        System.out.println(split);
    }

    /**
     * string常量池
     */
    private static void stringTest1() {
        String s1 = "test string";
        String s2 = "test string";
        if(s1 == s2){
            System.out.println("same");
        }else{
            System.out.println("different");
        }
    }
}
