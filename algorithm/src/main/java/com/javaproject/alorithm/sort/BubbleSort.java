package com.javaproject.alorithm.sort;


/**
 * 冒泡排序
 */
public class BubbleSort {

    //找出最大的放到最后
    public int[] fun(int[] in) {
        int tmp;
        for (int i = in.length; i > 1; i--) {//比较数的个数
            for (int j = 0; j < i - 1; j++) {//每个数比较的次数
                if (in[j] > in[j + 1]) {
                    tmp = in[j];
                    in[j] = in[j + 1];
                    in[j + 1] = tmp;
                }
            }
        }
        return in;
    }

    //每次比较找出最大的一个数放到最后
    public int[] fun2(int[] in) {
        int tmp;
        boolean order = true;
        for(int i = in.length; i>1; i--){//比较数的个数
            for(int j = 0; j<i-1; j++){
                if(in[j]>in[j+1]){
                    order = false;
                    tmp = in[j];
                    in[j] = in[j+1];
                    in[j+1] = tmp;
                }
            }
            if(!order){
                order = true;
            }else{
                break;
            }
        }
        return in;
    }


    public int[] fun1(int[] in) {
        int tmp;
/*        for (int i = in.length; i > 1 ; i--) {//需要比較数的个数，每比较一次，需要比较的数减一
            for (int j = 0; j < i -1; j++) {//每个数比较的次数，越到后面比较的次数越少
                if(in[j]>in[j+1]){
                    tmp = in[j];
                    in[j] = in[j+1];
                    in[j+1] = tmp;
                }
            }
        }*/

        for (int i = 0; i< in.length -1; i++) {//需要比较数的个数
            for (int j = 0; j < in.length-1-i ; j++) {//每个数比较的次数，j还要做数组的小标，不能越界
                if(in[j]>in[j+1]){
                    tmp = in[j];
                    in[j] = in[j+1];
                    in[j+1] = tmp;
                }
            }
        }
        return in;

    }

    //找出最小的数放到最前面
    public int[] funV(int[] in){
        int tmp;
        for(int i=in.length-1;i>0;i--){
            for(int j = in.length-1;j>in.length-i-1;j--){
                if(in[j]<in[j-1]){
                    tmp = in[j];
                    in[j] = in[j-1];
                    in[j-1] = tmp;
                }
            }
        }
        return in;
    }

    public int[] funV1(int[] in) {
        int tmp;
        for(int i = in.length -1; i>0; i--) {//比较数的个数为数组长度-1，数组从0开始到length -1
            for (int j = in.length -1; j > in.length -1 -i; j--) {//每个数比较的次数，最多比较数组长度-1次
                if(in[j]<in[j-1]){
                    tmp = in[j];
                    in[j] = in[j-1];
                    in[j-1] = tmp;
                }
            }
        }
        return in;
    }

    //找出最大的放到最后
    public int[] funPlus(int[] in){
        int tmp;
        boolean order = true;
        for(int i=in.length;i>1;i--){//比较数的个数
            for(int j= 0; j<i-1;j++){//每个数比较的次数
                if(in[j]>in[j+1]){
                    order = false;
                    tmp = in[j];
                    in[j] = in[j+1];
                    in[j+1] = tmp;
                }
            }
            if(order==false){
                order = true;
            }else {
                break;
            }
        }
        return in;
    }

    public int[] funPlus1(int[] in){
        int tmp;
        boolean order = true;
        for (int i = in.length -1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(in[j]>in[j+1]){
                    order = false;
                    tmp = in[j];
                    in[j] = in[j+1];
                    in[j+1] = tmp;
                }
            }
            if(order == false){
                order = true;
            }else{
                break;
            }
        }
        return in;
    }

    public static void main(String[] args) {
        int[] in = {6,4,5,3,9,2,1};
        BubbleSort bubbleSort = new BubbleSort();
        int[] out = bubbleSort.funPlus1(in);
        for(int i:out){
            System.out.println(i);
        }
    }
}
