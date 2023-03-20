package com.testmaven.thread;

public class Mythread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i< 30; i++){
            System.out.println(i+"Mythread1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
