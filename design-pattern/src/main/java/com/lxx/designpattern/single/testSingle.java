package com.lxx.designpattern.single;

public class testSingle {


    public static void main(String[] args) {
 /*       UnsafeLazySingle single1 = UnsafeLazySingle.getInstance();
        UnsafeLazySingle single2 = UnsafeLazySingle.getInstance();
        System.out.println(single1 == single2);

        HungarySingle single3 = HungarySingle.getInstance();
        HungarySingle single4 = HungarySingle.getInstance();
        System.out.println(single3 == single4);*/

        //System.out.println(single1 == single4);

        EnumSingle.INSTANCE.doSomething();
    }

}
