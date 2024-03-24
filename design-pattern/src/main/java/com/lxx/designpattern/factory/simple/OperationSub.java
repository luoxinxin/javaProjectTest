package com.lxx.designpattern.factory.simple;

/**
 * 计算器抽象类
 */
public  class OperationSub extends Operation{
    public double numberA;
    public double numberB;
    public double getResult(){
        if (numberB == 0) {
            throw new RuntimeException("divided by 0");
        }
        return numberA-numberB;
    }
}
