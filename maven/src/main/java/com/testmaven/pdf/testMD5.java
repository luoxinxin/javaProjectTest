package com.testmaven.pdf;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class testMD5 {
    public void test() throws InterruptedException {
        String a = "1232121";
        byte[] bytes = a.getBytes();
        System.out.println(a);
        System.out.println(Thread.holdsLock(this));
        Thread.sleep(10000);
        System.out.println(Thread.holdsLock(this));
    }
   /* public static void main(String[] args) throws InterruptedException {
       // System.out.println(Thread.holdsLock(testMD5));
       testMD5 testMD5 = new testMD5();
       testMD5.test();
        System.out.println(Thread.holdsLock(testMD5));

    }*/



    public static void main(String[] args) {
        String lock1 = new String("lock1");
        String lock2 = new String("lock2");
        new Thread(()->{
            synchronized (lock1){
                System.out.println(Thread.currentThread().getName()+lock1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName()+lock2);
                    System.out.println("a");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName()+lock2);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1){
                        System.out.println(Thread.currentThread().getName()+lock1);
                        System.out.println("b");
                    }
                }
            }
        }).start();

        LinkedBlockingQueue a;
        ArrayBlockingQueue b;
        System.out.println("wancheng");
    }

}


