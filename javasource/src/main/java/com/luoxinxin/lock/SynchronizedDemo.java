package com.luoxinxin.lock;

import java.util.concurrent.CompletableFuture;

public class SynchronizedDemo {
    private static int count = 0;

    public static synchronized void increment() {
        count++;
        while (count == 100) {
            throw new RuntimeException("count = 100");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count is " + count);
    }
    CompletableFuture completableFuture = new CompletableFuture();
}

