package com.luoxinxin.test;

import java.util.concurrent.Callable;
import java.util.concurrent.Semaphore;

public class testDouble {
    public static void main(String[] args) {

        System.out.println( 1f == 0.999999999999f );
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(System.identityHashCode(arr));
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);
        System.out.println(System.identityHashCode(arr));
    }

    public static void change(int[] array) {
        // 将数组的第一个元素变为0
        array = new int[]{2,3};
        String a;
        Semaphore b;
        ThreadLocal c;
        Callable d;
        Object e;
        array[0] = 2;
    }

}
