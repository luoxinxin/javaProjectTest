package com.luoxinxin.thread;

import java.util.concurrent.*;

public class ThreadPool {

    ExecutorService executorService = Executors.newFixedThreadPool(10);
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return null;
        }
    }, new ThreadPoolExecutor.AbortPolicy());

    public static void close(ExecutorService executorService) {
        // 停止接收新任务
        executorService.shutdown();

        try {
            // 等待已提交的任务执行完成，或者等待指定时间
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                // 超时后强制关闭线程池
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            // 处理线程中断异常
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

}
