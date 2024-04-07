package com.lxx.spb2hotdev.redis;

import org.redisson.Redisson;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class RedissonDelayedQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        // 创建 Redisson 客户端连接
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);

        // 获取延时队列
        RBlockingQueue<String> delayedQueue = redisson.getBlockingQueue("delayedQueue");

        // 启动一个线程来模拟消息的发送过程
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                delayedQueue.offer("message1", 10, TimeUnit.SECONDS);
                TimeUnit.SECONDS.sleep(5);
                delayedQueue.offer("message2", 30, TimeUnit.SECONDS);
                TimeUnit.SECONDS.sleep(5);
                delayedQueue.offer("message3", 60, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // 从延时队列中获取元素
        while (true) {
            String message = delayedQueue.take(); // 阻塞等待队列中有元素
            System.out.println("Received message: " + message);
        }
    }
}


