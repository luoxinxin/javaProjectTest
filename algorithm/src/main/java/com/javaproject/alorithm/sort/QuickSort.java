package com.javaproject.alorithm.sort;

//https://www.runoob.com/w3cnote/quick-sort.html

/**
 * 该方法的基本思想是：
        1．先从数列中取出一个数作为基准数。
        2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
        3．再对左右区间重复第二步，直到各区间只有一个数。*/


/*对挖坑填数进行总结:

        1．i =L; j = R; 将基准数挖出形成第一个坑a[i]。
        2．j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
        3．i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
        4．再重复执行2，3二步，直到i==j，将基准数填入a[i]中。*/

public class QuickSort {
    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }*/
        int[] nums = {4,3,7,9,3,0};
        int n = nums.length;
//        quickSort(nums, 0, n - 1);
        quickSort2(nums, 0, n - 1);
        for (int i = 0; i < n; ++i) {
            System.out.printf("%d ", nums[i]);
        }
    }


    /**
     * 最佳的做法
     * @param nums
     * @param left
     * @param right
     */
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {//终止递归的条件
            return;
        }
        int i = left - 1, j = right + 1;//left-1和right+1给下面while循环用
        int x = nums[left];//x拷贝left的值，left本身再while循环中被改变位置
        while (i < j) {
            while (nums[++i] < x);
            while (nums[--j] > x);
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }

    public static void quickSort2(int[] nums, int left, int right){
        if(left<right){
            int i = left -1;
            int j = right + 1;
            int mid = nums[left];
            while(i<j){
                while(nums[++i]<mid);
                while(nums[--j]>mid);
                if(i<j){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
            quickSort2(nums, left, j);
            quickSort2(nums, j + 1, right);
        }
    }


    public static void quickSort1(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left -1, j = right + 1;
        int x = nums[left];
        while(i < j) {
            while(nums[++i] < x);
            while(nums[j--] > x);
            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        quickSort1(nums, left,j);
        quickSort1(nums, j + 1,right);
    }

/*    public static void quickSort(int[] in){
        int len;
        if(in == null || (len = in.length) == 0 || len ==1){
            return ;
        }
        sort(in,0,len-1);
    }*/
    public static void sort(int[] in, int left, int right){
        if(left > right){
            return;
        }else{
            int base = in[left];
            int i = left, j = right;
            while(i!=j){
                while(in[j]>=base && j>i){
                    j--;
                }
                while(in[i]<=base && i<j){
                    i++;
                }
                if(i<j){
                    int tmp = in[i];
                    in[i] = in[j];
                    in[j] = tmp;
                }
            }

            in[left] = in[i];
            in[i] = base;

            sort(in,left,i-1);
            sort(in,i+1,right);
        }
    }

 /*   public static void sort(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }*/
}
