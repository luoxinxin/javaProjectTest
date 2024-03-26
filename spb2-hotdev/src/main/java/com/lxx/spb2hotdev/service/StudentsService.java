package com.lxx.spb2hotdev.service;

import com.lxx.spb2hotdev.domain.Students;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.concurrent.ExecutionException;

/**
* @author xinsilinwang
* @description 针对表【Students】的数据库操作Service
* @createDate 2023-12-04 13:42:01
*/
public interface StudentsService extends IService<Students> {

    //接口内的方法不存在依赖关系，可以并发调用，降低接口的响应时间
    void createOrder() throws ExecutionException, InterruptedException;

}
