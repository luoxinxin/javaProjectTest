package com.luoxinxin.test;

import java.util.concurrent.CopyOnWriteArrayList;

public class CowDemo {

    public static void main(String[] args) {
        // 创建一个CopyOnWriteArrayList
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // 向列表中添加元素
        list.add("a");
        list.add("b");
        list.add("c");

        // 创建一个线程，在列表中添加一个元素
        Thread t = new Thread(() -> {
            list.add("d");
        });
        t.start();

        // 在主线程中读取列表中的元素
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("hello word");
    }
}


