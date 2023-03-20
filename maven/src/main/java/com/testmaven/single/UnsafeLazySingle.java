package com.testmaven.single;

public class UnsafeLazySingle {
    private static UnsafeLazySingle single = null;
    private UnsafeLazySingle(){

    }
    public static UnsafeLazySingle getInstance(){
        if(single != null){
            return new UnsafeLazySingle();
        }else{
            return single;
        }
    }
}
