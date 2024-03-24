package com.lxx.spb2hotdev.test;

public class InterruptTest2  {

    public static void main(String[] args) {
        Thread myThread = new Thread(() -> {
            try {
                // 模拟一个可能抛出InterruptedException的操作
                System.out.println("Thread is running.");
                System.out.println(java.lang.Thread.currentThread().isInterrupted()+"1");
                java.lang.Thread.sleep(1000);
                System.out.println("Thread is sleeping 1000.");
            } catch (InterruptedException e) {
                // 在捕获InterruptedException后，重新设置中断状态
                System.out.println(java.lang.Thread.currentThread().isInterrupted());
                java.lang.Thread.currentThread().interrupt();
            }
            if (java.lang.Thread.currentThread().isInterrupted()) {
                System.out.println("清理工作");
            }
        });

        myThread.start();

        // 主线程休眠一段时间
        try {
            java.lang.Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 中断myThread线程
        myThread.interrupt();
        if (myThread.isInterrupted()) {
            System.out.println("myThread is interrupted1.");
        }
        try {
            java.lang.Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (myThread.isInterrupted()) {
            System.out.println("myThread is interrupted2.");
        }
    }
}
