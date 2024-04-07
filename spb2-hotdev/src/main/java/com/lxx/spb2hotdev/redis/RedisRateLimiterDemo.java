package com.lxx.spb2hotdev.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.exceptions.JedisException;

import java.util.UUID;

public class RedisRateLimiterDemo {

    private static final String REDIS_HOST = "localhost";
    private static final int REDIS_PORT = 6379;

    private static final String KEY = "rate_limiter";
    private static final int MAX_REQUESTS = 10;
    private static final int INTERVAL = 60; // 60秒

    public static boolean allowRequest(String userId) {
        Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT);
        try {
            // 开启事务
            Transaction tx = jedis.multi();
            // 获取当前时间戳
            long currentTime = System.currentTimeMillis() / 1000;
            // 删除过期的令牌
            tx.zremrangeByScore(KEY, 0, currentTime - INTERVAL);
            // 获取当前令牌数量
            tx.zcard(KEY);
            // 添加令牌
            UUID uuid = UUID.randomUUID();
            tx.zadd(KEY, currentTime, String.valueOf(currentTime)+uuid);
            // 设置过期时间
            tx.expire(KEY, INTERVAL + 1);
            // 执行事务
            tx.exec();
            // 获取当前令牌数量
            long currentTokens = jedis.zcard(KEY);
            // 判断是否允许请求
            return currentTokens <= MAX_REQUESTS;
        } catch (JedisException e) {
            // 处理异常
            e.printStackTrace();
            return false;
        } finally {
            jedis.close();
        }
    }

    public static void main(String[] args) {
        // 模拟用户请求
        for (int i = 0; i < 15; i++) {
            String userId = "user" + i;
            boolean allow = allowRequest(userId);
            System.out.println("User " + userId + " request allowed: " + allow);
        }
    }
}

