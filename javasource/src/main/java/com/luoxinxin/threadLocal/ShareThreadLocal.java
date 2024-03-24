package com.luoxinxin.threadLocal;

import java.util.ArrayList;
import java.util.List;

public class ShareThreadLocal {

    private final static ThreadLocal<List<String>> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            List<String> list = threadLocal.get();
            if (list == null) {
                list = new ArrayList<>();
//                threadLocal.set(list);
            }
            list.add(Thread.currentThread().getName());
            threadLocal.set(list);
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        List<String> resultList = threadLocal.get();
        System.out.println("Result: " + resultList);
    }


}
