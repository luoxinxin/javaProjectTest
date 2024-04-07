package com.luoxinxin.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // 创建一个 CyclicBarrier，当3个线程都调用了await方法后，触发屏障操作
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All workers have reached the barrier, continue execution.");
        });

        // 创建并启动3个工作线程
        for (int i = 0; i < 3; i++) {
            Thread worker = new Thread(new Worker(barrier));
            worker.start();
        }
    }

    static class Worker implements Runnable {
        private final CyclicBarrier barrier;

        public Worker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                // 模拟工作线程执行任务
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println(Thread.currentThread().getName() + " has finished its work and waiting at the barrier.");
                // 等待所有工作线程都到达屏障点
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " continues execution after barrier.");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

