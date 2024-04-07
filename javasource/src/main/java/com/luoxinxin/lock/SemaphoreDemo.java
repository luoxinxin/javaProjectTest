package com.luoxinxin.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        // 创建一个Semaphore，初始化许可证数量为3
        Semaphore semaphore = new Semaphore(3);

        // 创建并启动5个工作线程
        for (int i = 0; i < 5; i++) {
            Thread worker = new Thread(new Worker(semaphore));
            worker.start();
        }
    }

    static class Worker implements Runnable {
        private final Semaphore semaphore;

        public Worker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                // 获取许可证，如果没有可用的许可证则会阻塞直到有可用许可证
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " has acquired a permit.");
                // 模拟工作线程执行任务
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println(Thread.currentThread().getName() + " has finished its work.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 释放许可证
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " has released the permit.");
            }
        }
    }
}

