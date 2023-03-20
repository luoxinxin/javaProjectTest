package com.testmaven.single;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicSingle {
    private static final AtomicReference<AtomicSingle> INSTANCE = new AtomicReference<>();

    private static AtomicSingle single;

    private AtomicSingle(){}

    public static final AtomicSingle getSingle(){
        for(;;){
            single = INSTANCE.get();
            if(null != single){
                return single;
            }
            INSTANCE.compareAndSet(null,new AtomicSingle());
            return INSTANCE.get();
        }
    }

}
