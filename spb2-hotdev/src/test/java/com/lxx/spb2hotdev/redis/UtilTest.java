package com.lxx.spb2hotdev.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilTest {

    @Autowired
    RedissonTest redissonTest;

    @Test
    void BeanClassUtil1() {
        redissonTest.doSomething();
    }

}
