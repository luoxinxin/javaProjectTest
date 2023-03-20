package com.testmaven.single;

public class SafeLazySingle {
    private static SafeLazySingle single = null;
    private SafeLazySingle(){}
    public synchronized static SafeLazySingle getInstance(){
        if(single == null){
            single = new SafeLazySingle();
        }
        return single;
    }
}
