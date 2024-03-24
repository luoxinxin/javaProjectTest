package com.lxx.designpattern.single;

public class HungarySingle {

    private HungarySingle(){

    }
    private static HungarySingle single1 = new HungarySingle();
    public static HungarySingle getInstance(){
        return single1;
    }
}
