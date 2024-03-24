package com.lxx.designpattern.factory.simple;

/**
 * 计算器抽象类
 */
public abstract class Operation {
    public double numberA;
    public double numberB;
    public abstract double getResult();
}
