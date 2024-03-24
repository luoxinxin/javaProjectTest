package com.luoxinxin.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestMyThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Thread thread = new MyThread();
//        thread.start();
//
//        Thread thread2 = new Thread(new MyRunnable());
//        thread2.start();

        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread thread3 = new Thread(futureTask);
        thread3.start();
        Integer myCallableResult = futureTask.get();
        System.out.println(myCallableResult);
    }
}
