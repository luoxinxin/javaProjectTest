package com.lxx.designpattern.factory.simple.example1;

/**
 * 计算器抽象类
 */
public  class OperationAdd extends Operation{
    public double numberA;
    public double numberB;
    public double getResult(){
        return numberA+numberB;
    }
}