package com.luoxinxin.test;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class we {

//    面试题1
//    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了不止一次。找出那个只出现了一次的元素。
//    示例 :
//    输入: [2,2,3,2,4,5,4,5,5]
//    输出: 3
//    class Solution {
        public static int singleNumber(int[] nums) {
//            for(int i = 0;i<nums.length;i++){
//                for (int j = 0; j<nums.length; j++){
//                    if(nums[i] != nums[j] && i!=j){
//                        continue;
//                    }
//                }
//            }


            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
//            Optional<Map.Entry<Integer, Integer>> first1 = map.entrySet().stream().filter(v -> v.getValue() == 1).findFirst();
            AtomicReference<Integer> k = new AtomicReference<>(0);
            map.entrySet().forEach(v-> {
                if(v.getValue() == 1){
                    System.out.println(v.getKey());
//                    k.set(v.getKey());
//                    break;
                }
            });

            for (Map.Entry<Integer, Integer> e: map.entrySet()){
                if(e.getValue() == 1){
                    return e.getKey();
                }
            }
//            if (first1.isPresent()) {
//                first1.get().getKey();
//            }

//            ArrayList<Integer> integers = new ArrayList<Integer>(nums);


            ArrayList<Integer> list = new ArrayList<>();
            Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);
            List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());

            List<Integer> list1 = Arrays.asList(array);
            Integer integer = 0;
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            Optional<Integer> first = list.stream().filter(v -> list.contains(v) && list.indexOf(v) == list.lastIndexOf(v)).findFirst();
            if (first.isPresent()) {
                return first.get();
            }
            return 0;
        }

    public static void main(String[] args) {
        int i = singleNumber(new int[]{2, 2, 3, 2, 4, 5, 4, 5, 5});
        System.out.println(i);
    }





//    面试题2
//    题目2：数据库中有“项目表”和“部门表”，结构如下：
//    select id, name, dept_id from project
//    select id, name from department
//（其中dept_id为部门id）
//    写一句SQL：统计各部门的项目数量
//    输出示例：
//    部门名字   项目数量
//    部门X      3

//    select d.name, count(*) from department d left join project  di on d.id = di.dept_id group by d.name;



}
