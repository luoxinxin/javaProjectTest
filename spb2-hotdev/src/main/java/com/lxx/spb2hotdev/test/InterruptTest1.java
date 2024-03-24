package com.lxx.spb2hotdev.test;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class InterruptTest1 extends Thread {

    @Override
    public void run () {
        if (!Thread.currentThread().isInterrupted()) {
            try {
                //1：这里处理正常的线程业务逻辑
                System.out.println("线程正常运行");
                sleep(10);
                wait();
            } catch (InterruptedException e) {
                System.out.println("线程中断了1");
                Thread.currentThread().interrupt(); //重新设置中断标识
                System.out.println("线程中断了3");
            }
        }

        if (Thread.currentThread().isInterrupted()) {
            //2：处理线程结束前必要的一些资源释放和清理工作，比如释放锁、//存储数据到持久化层、发出异常通知等，用于实现线程的安全退出

            System.out.println("线程中断了2");
//            try {
//                sleep(10);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //3：定义一个可安全退出的线程
        InterruptTest1 thread = new InterruptTest1();
        thread.start();
        sleep(1);
//        sleep(10);
        //4：安全退出线程
        thread.interrupt();
    }

}
