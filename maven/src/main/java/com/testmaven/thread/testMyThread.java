package com.testmaven.thread;

import java.util.concurrent.FutureTask;

public class testMyThread {
    public static void main(String[] args) {
        Thread thread1 = new Mythread1();
        thread1.start();

        Thread thread2 = new Thread(new Mythread2());
        thread2.start();

        Mythread3 mythread3 = new Mythread3();
        FutureTask<Integer> futureTask = new FutureTask<>(mythread3);
        Thread thread3 = new Thread(futureTask);
        thread3.start();
    }
}
