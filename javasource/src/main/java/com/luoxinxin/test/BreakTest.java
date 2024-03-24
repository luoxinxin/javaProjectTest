package com.luoxinxin.test;


/**
 * break本身只跳出当前的循环
 * 只有跟标签一起出现，才能跳出整个循环
 */
public class BreakTest {
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
