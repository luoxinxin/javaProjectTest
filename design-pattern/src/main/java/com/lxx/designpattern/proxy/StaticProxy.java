package com.lxx.designpattern.proxy;


/**
 * 静态代理
 * 静态代理的用途 控制真实对象的访问权限 通过代理对象
 * 增强真实对象的功能
 */
public class StaticProxy {
    public static void main(String[] args) {
        //目标对象
        HelloSerivice target = new HelloServiceImpl();
        //代理对象
        HelloServiceProxy proxy = new HelloServiceProxy(target);
        proxy.say();
    }
}


/**
 * 接口
 */
interface HelloSerivice {
    public void say();
}

/**
 * 目标类
 */
class HelloServiceImpl implements HelloSerivice{
    @Override
    public void say() {
        System.out.println("hello world");
    }
}

/**
 * 代理类
 */
class HelloServiceProxy implements HelloSerivice{
    private HelloSerivice target;
    public HelloServiceProxy(HelloSerivice target) {
        this.target = target;
    }
    @Override
    public void say() {
        System.out.println("记录日志");
        target.say();
        System.out.println("清理数据");
    }
}