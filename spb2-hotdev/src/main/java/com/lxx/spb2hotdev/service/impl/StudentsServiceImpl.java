package com.lxx.spb2hotdev.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lxx.spb2hotdev.domain.Students;
import com.lxx.spb2hotdev.service.StudentsService;
import com.lxx.spb2hotdev.mapper.StudentsMapper;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @author xinsilinwang
* @description 针对表【Students】的数据库操作Service实现
* @createDate 2023-12-04 13:42:01
*/
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students>
    implements StudentsService{

    //接口内的方法不存在依赖关系，可以并发调用，降低接口的响应时间
    @Override
    public void createOrder() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        //没有依赖的模块1
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> "1", executor);
        //没有依赖的模块1
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> "2", executor);
        //没有依赖的模块1
        CompletableFuture<String> completableFuture3 = CompletableFuture.supplyAsync(() -> "3", executor);

        CompletableFuture.allOf(completableFuture1, completableFuture2, completableFuture3);
        completableFuture1.get();
        completableFuture2.get();
        completableFuture3.get();
    }
}




