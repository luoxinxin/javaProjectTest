package com.luoxinxin.test;

import java.util.*;

class Decrementer {
    public void decrement(double decMe) {
        decMe = decMe - 1.0;
    }
}

class Question {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i<n; i++){
                nums[i] = sc.nextInt();
            }
            System.out.println(maxSubArray(nums));
        }
    }

    public static int maxSubArray(int[] nums) {
        int left = 0, right = 0;
        int windowSum = 0, maxSum = Integer.MIN_VALUE;
        while(right < nums.length){
            // 扩大窗口并更新窗口内的元素和
            windowSum += nums[right];
            right++;

            // 更新答案
            maxSum = windowSum > maxSum ? windowSum : maxSum;

            // 判断窗口是否要收缩
            while(windowSum < 0) {
                // 缩小窗口并更新窗口内的元素和
                windowSum -=  nums[left];
                left++;
            }
        }
        return maxSum;
    }

//    public static boolean canPartition(int[] nums) {
//        int sum = 0;
//        int maxNum = 0;
//        int target = 0;
//        for(int i = 0; i<nums.length; i++){
//            sum = sum + nums[i];
//            if(maxNum<nums[i]){
//                maxNum = nums[i];
//            }
//        }
//        if(sum%2 != 0){
//            return false;
//        }
//        target = sum/2;
//        if(maxNum>target){
//            return false;
//        }
//        boolean[][] dp = new boolean[nums.length+1][target+1];
//        //dp[0][0] = true;
//        for(int i = 1; i<nums.length+1;i++){
//            dp[i][0] = true;
//        }
//        dp[1][nums[0]] = true;
//        for(int i = 2; i<=nums.length;i++){
//            for(int j = 1; j<=target; j++){
//                if(j>=nums[i-1]){
//                    dp[i][j] = dp[i-1][j]|dp[i-1][j-nums[i-1]];
//                }else{
//                    dp[i][j] = dp[i-1][j];
//                }
//            }
//        }
//        return dp[nums.length][target];
//    }

//        static int jump(int[] nums) {
//            int n = nums.length;
//            int end = 0, farthest = 0;
//            int jumps = 0;
//            for (int i = 0; i < n - 1; i++) {
//                farthest = Math.max(nums[i] + i, farthest);
//                if (end == i) {
//                    jumps++;
//                    end = farthest;
//                }
//            }
//            return jumps;
//        }
//    static int b;
//    int d;
//
//    public static void main(String args[]) {
//        System.out.println(b);
//        int c = 0;
//        System.out.println(c);
//        Question q = new Question();
//        System.out.println(q.d);
//        System.out.println(Integer.parseInt("a"));
//    }
}



