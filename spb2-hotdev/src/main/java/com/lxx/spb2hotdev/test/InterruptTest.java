package com.lxx.spb2hotdev.test;

public class InterruptTest extends Thread {
        @Override
        public void run() {
            while (!Thread.interrupted()) {
                // 线程执行的代码
                System.out.println("Thread is running...");
            }
            System.out.println("Thread is interrupted, exiting...");
        }

        public static void main(String[] args) throws InterruptedException {
            InterruptTest myThread = new InterruptTest();
            myThread.start();

//                Thread.sleep(5000);


            // 在某个时刻中断线程
            myThread.interrupt();
        }


}
