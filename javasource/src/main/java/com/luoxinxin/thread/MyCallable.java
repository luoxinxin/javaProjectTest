package com.luoxinxin.thread;

import java.util.concurrent.Callable;

/**
 * 实现Callable 线程任务 30次循环输出 100毫秒
 */
public class MyCallable implements Callable {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i=1;i<30; i++){
            System.out.println(i + "MyCallable");
            Thread.sleep(100);
            sum = sum + i;
        }
        return sum;
    }
}
