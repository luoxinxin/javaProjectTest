package com.luoxinxin.lock;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个 CountDownLatch，计数器初始化为3
        CountDownLatch latch = new CountDownLatch(3);

        // 创建并启动3个工作线程
        for (int i = 0; i < 3; i++) {
            Thread worker = new Thread(new Worker(latch));
            worker.start();
        }

        // 主线程等待所有工作线程完成
        latch.await();

        System.out.println("All workers have finished, main thread continues.");
    }

    static class Worker implements Runnable {
        private final CountDownLatch latch;

        public Worker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                // 模拟工作线程执行任务
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println(Thread.currentThread().getName() + " has finished its work.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 每个工作线程完成任务后将计数器减1
                latch.countDown();
            }
        }
    }
}

