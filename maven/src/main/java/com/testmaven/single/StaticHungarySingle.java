package com.testmaven.single;

public class StaticHungarySingle {
    private static StaticHungarySingle single= null;
    static{
        single = new StaticHungarySingle();
    }
    private StaticHungarySingle(){

    }
    public static StaticHungarySingle getInstance(){
        return single;
    }
}
