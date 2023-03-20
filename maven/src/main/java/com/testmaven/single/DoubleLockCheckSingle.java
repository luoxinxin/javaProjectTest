package com.testmaven.single;

public class DoubleLockCheckSingle {
    private volatile static DoubleLockCheckSingle single = null;
    private DoubleLockCheckSingle(){

    }
    public static DoubleLockCheckSingle getInstance(){
        if(single == null){
            synchronized(DoubleLockCheckSingle.class){
                single = new DoubleLockCheckSingle();
            }
        }
        return single;
    }
}
