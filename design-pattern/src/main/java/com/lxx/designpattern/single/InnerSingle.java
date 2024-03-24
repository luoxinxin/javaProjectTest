package com.lxx.designpattern.single;

public class InnerSingle {
    private InnerSingle(){}
    private static class SingletonHolder{
        private static final InnerSingle single = new InnerSingle();
    }
    public static InnerSingle getInstance(){
        return SingletonHolder.single;
    }

}
