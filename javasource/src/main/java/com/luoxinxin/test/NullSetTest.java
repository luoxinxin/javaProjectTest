package com.luoxinxin.test;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class NullSetTest {

    public static void main(String[] args) {
        HashSet<Object> objects = new HashSet<>();
        objects.add(null);
        objects.add(null);
        System.out.println("objects.size() = " + objects.size());
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(null, null);
        hashMap.put(null, new Date());

        System.out.println("hashMap.size() = " + hashMap.size());
        System.out.println("hashMap.get(null) = " + hashMap.get(null));
        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));
        ReentrantLock reentrantLock = new ReentrantLock();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, null, null);
        CountDownLatch countDownLatch = new CountDownLatch(1);
    }
}
