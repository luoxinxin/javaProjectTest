package com.luoxinxin.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class b {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        b b = new b();
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i<n; i++){
                nums[i] = sc.nextInt();
            }
            int sum = 0;
            b.backtrack(500, 0,  nums);
            for(List<Integer> e : b.res){
                System.out.println(e);
            }
        }
    }

    void backtrack(int target ,int start, int[] nums){
        if(target == trackSum){
            res.add(new ArrayList<>(track));
            return;
        }else if(trackSum >500){
            return;
        }
        for(int i = start; i<nums.length; i++){
            trackSum = trackSum + nums[i];
            track.add(nums[i]);
            backtrack(target, i, nums);
            trackSum = trackSum -nums[i];
            track.removeLast();
        }
    }
}
