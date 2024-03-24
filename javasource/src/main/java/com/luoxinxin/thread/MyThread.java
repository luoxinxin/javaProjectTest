package com.luoxinxin.thread;

/**
 * 继承Thread 线程任务 30次循环输出 100毫秒
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i< 30; i++){
            System.out.println(i+"MyThread");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
