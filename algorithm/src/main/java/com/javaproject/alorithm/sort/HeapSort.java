package com.javaproject.alorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {
    private static int[] h = new int[10];
    private static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 1; i <= n; ++i) {
            h[i] = sc.nextInt();
        }
        size = n;
        for (int i = n / 2; i > 0; --i) {
            up(i);
        }
        System.out.println(Arrays.toString(h));
        while (m-- > 0) {
            System.out.print(h[1] + " ");
            h[1] = h[size--];

            up(1);
            System.out.println(Arrays.toString(h));
        }
    }

    public static void down(int u) {
        int t = u;
        if (u * 2 <= size && h[u * 2] < h[t]) {
            t = u * 2;
        }
        if (u * 2 + 1 <= size && h[u * 2 + 1] < h[t]) {
            t = u * 2 + 1;
        }
        if (t != u) {
            swap(t, u);
            down(t);
        }
    }

    public static void up(int u) {
        while (u / 2 > 0 && h[u / 2] > h[u]) {
            swap(u / 2, u);
            u /= 2;
        }
    }

    public static void swap(int i, int j) {
        int t = h[i];
        h[i] = h[j];
        h[j] = t;
    }




    /*//交换元素
    public static void exchange(int[] array,int i,int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    //获得父节点
    public static int parentNode(int i)
    {
        return (i - 1)/2;
    }
    //获得左节点
    public static int leftNode(int i)
    {
        return 2*i + 1;
    }
    //获得右节点
    public static int rightNode(int i)
    {
        return 2*i + 2;
    }
    //最大堆
    public static void maxHeap(int[] array,int heapSize,int index)
    {
        int left = leftNode(index);
        int right = rightNode(index);
        int largeNode = index;
        if(left < heapSize && array[left] > array[largeNode])
        {
            largeNode = left;
        }
        if(right < heapSize && array[right] > array[largeNode])
        {
            largeNode = right;
        }
        if(index != largeNode)
        {
            exchange(array, index, largeNode);
            maxHeap(array,heapSize,largeNode);
        }
    }
    public static void buildHeap(int[] array)
    {
        if(array == null || array.length <= 1){
            return;
        }
        int half = array.length/2;
        for(int i=half;i>=0;i--)
        {
            maxHeap(array,array.length,i);
        }
    }
    public static void heapSort(int[] array)
    {
        if(array == null || array.length <= 1)
        {
            return;
        }
        buildHeap(array);
        for(int i=array.length -1;i>=1;i--)
        {
            System.out.println(i + "堆结构");
            printHeapTree(array);
            exchange(array,0,i);
            maxHeap(array,i,0);
        }
    }
    public static void printHeapTree(int[] array)
    {
        for(int i=1;i<=array.length;i=i*2)
        {
            for(int k=i-1;k<2*i-1 && k<array.length;k++)
            {
                System.out.print(array[k]+" ");
            }
            System.out.println();
        }
    }
    public static void printHeap(int[] array)
    {
        for(int i=0;i<array.length;i++)
        {
            System.out.print(array[i]+" ");
        }
    }
    public static void main(String[] args)
    {
        int[] array = {7,4,5,3,2,6,9,1};
        System.out.println("执行最大堆化前，堆结构：");
        printHeapTree(array);//单纯的打印

        buildHeap(array);
        System.out.println("执行最大堆化后，堆结构：");
        printHeapTree(array);

        heapSort(array);
        System.out.println("执行排序后，堆结构：");
        printHeapTree(array);
        System.out.println("堆排序结果：");
        printHeap(array);
    }*/
}
