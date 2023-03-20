package com.javaproject.alorithm.sort;

public class SelectionSort {

    //选出最大的元素放到最后面
    public int[] fun(int[] in){
        for(int i=in.length-1;i>=0;i--){//找出最大的元素放到最后，一次找到一个
            int max = i;
            for(int j=0;j<i;j++){//找到最大的元素
                if(in[max]<in[j]){
                    max = j;
                }
            }
            if(max != i){//放到i位置
                int tmp = in[max];
                in[max] = in[i];
                in[i] = tmp;
            }
        }
        return in;
    }

    public int[] fun1(int[] in){
        for (int i = in.length -1; i >=0 ; i--) {//假定最后一个元素i最大，找到最大的元素max放到i的位置
            int max = i;
            for (int j = 0; j < i; j++) {
                if(in[j]>in[max]){
                    max = j;
                }
            }
            if(max != i){
                int tmp = in[max];
                in[max] = in[i];
                in[i] = tmp;
            }
        }
        return in;
    }

    public int[] funV(int[] in){
        for(int i = 0;i<=in.length-1;i++){
            int min = i;
            for(int j=in.length-1; j>i; j--){
                if(in[min]>in[j]){
                    min = j;
                }
            }
            if(min != i){
                int tmp = in[min];
                in[min] = in[i];
                in[i] = tmp;
            }
        }
        return in;
    }

    public static void main(String[] args) {
        int[] in = {6,4,5,3,9,2,1};
        SelectionSort selectionSort = new SelectionSort();
        int[] out = selectionSort.funV(in);
        for(int i:out){
            System.out.println(i);
        }
    }
}
