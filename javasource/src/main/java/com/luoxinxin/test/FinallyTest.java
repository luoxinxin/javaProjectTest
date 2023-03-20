package com.luoxinxin.test;

public class FinallyTest {
    public static void main(String[] args) {
        System.out.println("pb() = " + pb());
    }

    public static int pb(){
        int i = 1;
        try{
            int k = i/0;
        }catch (Exception e){
            e.printStackTrace();
            return i;
        }finally {
            return i + 1;
        }
    }
}
