package com.testmaven.string;

public class StringTest {
    public static void main(String[] args) {
        String a = "i have apple";
        String b = new String("i have apple");
        String c = new String("i have apple");
        String d = new String("i have apple").intern();
        String e = new String("i have apple").intern();
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a == d);
        System.out.println(d == e);
        System.out.println(b == d);
        System.out.println(c == e);
        System.out.println(c);
    }
}
