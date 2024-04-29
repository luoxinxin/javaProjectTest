package com.javaproject.alorithm.select;

/**
 * 二分查找
 */
public class BinarySelect {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySelect(nums, 5));
    }

    public static int binarySelect(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        int mid;
        while(begin < end){
            mid = (begin + end)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]>target){
                end = mid - 1;
            }else if(nums[mid]<target){
                begin = mid + 1;
            }
        }
        return -1;
    }
}
