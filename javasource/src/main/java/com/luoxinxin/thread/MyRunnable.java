package com.luoxinxin.thread;

/**
 * 实现Runnable 线程任务 30次循环输出 100毫秒
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i<30; i++){
            System.out.println(i + "MyRunnable");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
