package com.lxx.designpattern.factory.simple.example1;

public class Calculator {
    public static void main(String[] args) {
        OperationFactory factory = new OperationFactory();

        char operator = '/';

        Operation operation = factory.createOperation(operator);
        operation.numberA = 10;
        operation.numberB = 2;
        operation.getResult();
    }
}
