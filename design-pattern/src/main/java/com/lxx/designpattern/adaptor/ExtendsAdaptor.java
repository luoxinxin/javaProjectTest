package com.lxx.designpattern.adaptor;


/**
 * 通过继承的方式实现适配器模式
 */
public class ExtendsAdaptor {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.originalMethod();
        adapter.extendedMethod();
    }
}

// 原始类
class OriginalClass {
    public void originalMethod() {
        System.out.println("Original method");
    }
}

// 定义新的接口，包含扩展的方法
interface ExtendedInterface {
    void extendedMethod();
}

// 适配器类，继承原始类并实现新接口
class Adapter extends OriginalClass implements ExtendedInterface {
    @Override
    public void extendedMethod() {
        System.out.println("Extended method");
    }
}
