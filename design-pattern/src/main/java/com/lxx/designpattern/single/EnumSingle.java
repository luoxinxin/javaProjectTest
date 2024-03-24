package com.lxx.designpattern.single;

/**
 * 枚举单例模式
 */
public enum EnumSingle {
    INSTANCE;
    public void doSomething(){
        System.out.println("i have a single");
    }
}
