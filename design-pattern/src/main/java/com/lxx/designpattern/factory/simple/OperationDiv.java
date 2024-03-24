package com.lxx.designpattern.factory.simple;

/**
 * 计算器抽象类
 */
public  class OperationDiv extends Operation{
    public double numberA;
    public double numberB;
    public double getResult(){
        return numberA/numberB;
    }
}
