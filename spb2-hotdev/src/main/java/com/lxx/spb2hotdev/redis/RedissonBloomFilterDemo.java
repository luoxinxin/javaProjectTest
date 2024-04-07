package com.lxx.spb2hotdev.redis;

import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class RedissonBloomFilterDemo {

    private static final String REDIS_HOST = "localhost";
    private static final int REDIS_PORT = 6379;

    public static void main(String[] args) {
        // 创建 Redisson 客户端连接
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + REDIS_HOST + ":" + REDIS_PORT);
        RedissonClient redisson = Redisson.create(config);

        // 创建布隆过滤器
        RBloomFilter<String> bloomFilter = redisson.getBloomFilter("bloomFilter");

        // 初始化布隆过滤器
        // 预计插入元素数量为 100000，期望误差率为 0.01
        bloomFilter.tryInit(100000, 0.01);

        // 将数据插入布隆过滤器
        bloomFilter.add("data1");
        bloomFilter.add("data2");
        bloomFilter.add("data3");

        // 检查数据是否存在于布隆过滤器中
        System.out.println(bloomFilter.contains("data1")); // 输出 true
        System.out.println(bloomFilter.contains("data4")); // 输出 false

        // 关闭 Redisson 客户端连接
        redisson.shutdown();
    }
}

