package com.lxx.spb2hotdev.controller;

public class MultiThreadExample {

    public static void main(String[] args) {
        // 创建并启动两个线程
        Thread thread1 = new Thread(new Task("Thread 1"));
        Thread thread2 = new Thread(new Task("Thread 2"));

        thread1.start();
        thread2.start();
    }

    static class Task implements Runnable {
        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                // 模拟耗时操作
                doSomething();
            }
        }

        private void doSomething() {
            // 在这里执行一些耗时的操作
            System.out.println(name + " is doing something...");
            try {
                Thread.sleep(1000); // 模拟耗时操作
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

