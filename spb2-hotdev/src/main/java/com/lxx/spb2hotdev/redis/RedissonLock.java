package com.lxx.spb2hotdev.redis;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*redisson分布式锁*/
@Component
@Slf4j
public class RedissonLock {

    @Autowired
    private RedissonClient redissonClient;

    public void doSomething() {
        // 获取分布式锁
        RLock lock = redissonClient.getLock("myLock");
        try {
            lock.lock();
            log.info("加锁成功");
            // 在这里执行需要加锁的操作
        } finally {
            log.info("解锁成功");
            lock.unlock();
        }
    }



}
