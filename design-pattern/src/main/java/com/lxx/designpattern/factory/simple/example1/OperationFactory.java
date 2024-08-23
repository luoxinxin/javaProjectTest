package com.lxx.designpattern.factory.simple.example1;

public class OperationFactory {
    public Operation createOperation(char operator){
        Operation operation;
        switch (operator){
            case '+':
                operation = new OperationAdd(); 
                break;
            case '-':
                operation = new OperationSub(); 
                break;
            case '*':
                operation = new OperationMul(); 
                break;
            case '/':
                operation = new OperationDiv(); 
                break;
            default:
                throw new IllegalArgumentException("非法操作符");
        }
        return operation;
    }
}
