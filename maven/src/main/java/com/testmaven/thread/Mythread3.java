package com.testmaven.thread;

import java.util.concurrent.Callable;

public class Mythread3 implements Callable {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i=1;i<30; i++){
            System.out.println(i + "Mythread3");
            Thread.sleep(100);
            sum = sum + i;
        }
        return sum;
    }
}
