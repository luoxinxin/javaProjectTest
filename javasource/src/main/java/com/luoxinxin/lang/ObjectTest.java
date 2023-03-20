package com.luoxinxin.lang;

public class ObjectTest {

    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(object.hashCode());
        System.out.println(object.hashCode());
        Integer integer = new Integer(1);
        System.out.println(integer.getClass());
        System.out.println(object);
        object = integer;
        System.out.println(object.getClass());
        Integer[] integers = new Integer[3];
        System.out.println(integers.clone().getClass());
        System.out.println(integers.getClass());
    }
}
