package com.javaproject.alorithm.sort;

/**
 * 插入排序
 */
public class InsertSort {

    public int[] fun(int[] in){
        int tmp;
        int k;
        for(int i=1;i<in.length;i++){//从第一个数据开始与之前所有数据往前比较,共1到length-1个数据
            tmp = in[i];
            k = i;
            while(k-1>=0 && tmp < in[k-1]) {//直到找到tmp in[i]可以存放的位置k
                in[k] = in[k-1];
                k--;
            }
            if(k!=i){//找到需要插入的位置k，将数据i插入到k位置
                in[k] = tmp;
            }
        }
        return in;
    }

    public int[] fun1(int[] in){
        int tmp;
        int k;
        for(int i = 1; i<in.length;i++){
            tmp = in[i];
            k = i;
            while(k-1>=0 && tmp<in[k-1]){
                in[k] = in[k-1];
                k--;
            }
            if(k != i){
                in[k] = tmp;
            }
        }
        return in;
    }

    public int[] fun2(int[] in){
        int tmp;
        int k;
        for(int i = 1; i<in.length; i++){
            tmp = in[i];
            k = i;
            while(k-1>=0 && tmp<in[k-1]){
                in[k] = in[k-1];
                k--;
            }
            if(k != i){
                in[k] = tmp;
            }
        }
        return in;
    }

    public static void main(String[] args) {
        int[] in = {6,4,5,3,9,2,1};
        InsertSort insertSort = new InsertSort();
        int[] out = insertSort.fun(in);
        for(int i:out){
            System.out.println(i);
        }
    }
}
