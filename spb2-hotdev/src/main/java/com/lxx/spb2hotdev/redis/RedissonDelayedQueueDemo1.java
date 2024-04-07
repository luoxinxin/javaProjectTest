package com.lxx.spb2hotdev.redis;

import org.redisson.Redisson;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class RedissonDelayedQueueDemo1 {

    public static void main(String[] args) throws InterruptedException {
        // 创建 Redisson 客户端连接
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);


        addElement(redisson);

        // 获取延时队列
        getElement(redisson);
//        getElement(redisson);
//        getElement(redisson);

    }


    /**
     从延时队列中获取元素
     */
    private static void getElement(RedissonClient redisson) throws InterruptedException {
        RBlockingQueue<String> blockingQueue = redisson.getBlockingQueue("delayedQueue");
        RDelayedQueue<String> delayedQueue = redisson.getDelayedQueue(blockingQueue);
        String take = blockingQueue.take();
        System.out.println(take);
    }

    private static void addElement(RedissonClient redisson) {
        // 获取延时队列
        RBlockingQueue<String> blockingQueue = redisson.getBlockingQueue("delayedQueue");
        RDelayedQueue<String> delayedQueue = redisson.getDelayedQueue(blockingQueue);

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "添加任务到延时队列里面");
        delayedQueue.offer("Hello, World!", 3, TimeUnit.SECONDS);
//        delayedQueue.offer("Hello, World!", 6, TimeUnit.SECONDS);
//        delayedQueue.offer("Hello, World!", 9, TimeUnit.SECONDS);
    }

    public static RedissonClient getRedissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}


