package com.testmaven.pdf;

public class TestBreak {
    public static void main(String[] args) {
        int i = 1;
        ok:
        while(i<10){
            i++;
            while(i<10){
                i++;
                System.out.println(i);
                while(i<10){
                    i++;
                    System.out.println(i);
                    while(i<10){
                        i++;
                        System.out.println(i+"o");
                        while(i<10){
                            i++;
                            System.out.println(i);
                            break ok;

                        }
                    }
                }
            }
        }
    }

}
