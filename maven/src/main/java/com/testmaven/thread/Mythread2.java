package com.testmaven.thread;

public class Mythread2 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i<30; i++){
            System.out.println(i + "Mythread2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
