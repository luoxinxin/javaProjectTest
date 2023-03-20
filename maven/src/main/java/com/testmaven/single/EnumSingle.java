package com.testmaven.single;

public enum EnumSingle {
    INSTANCE;
    public void doSomething(){
        System.out.println("i have a single");
    }
}
