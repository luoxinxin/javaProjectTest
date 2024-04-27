package com.lxx.spb2hotdev.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

public class RedisClusterDemo {

    public static void main(String[] args) {
        // Redis集群节点列表
        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7010));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7011));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7012));

//        // 配置连接池
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(100);
        poolConfig.setMaxIdle(50);
        poolConfig.setMinIdle(10);

        // 创建JedisCluster实例
//        JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
        JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes, poolConfig);


//        // 存储数据
//        String key = "myKey";
//        String value = "myValue";
//        jedisCluster.set(key, value);

//        // 从集群中获取数据
//        String retrievedValue = jedisCluster.get(key);
//        System.out.println("Retrieved value: " + retrievedValue);

        // 循环存储数据
        for (int i = 0; i < 10000; i++) {
            String key = "key" + i;
            String value = "value" + i;
            jedisCluster.set(key, value);
        }

        // 关闭连接
        jedisCluster.close();
    }

}
