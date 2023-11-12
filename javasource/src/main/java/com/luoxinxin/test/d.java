package com.luoxinxin.test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class d {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int num = in.nextInt();
            int price = in.nextInt();
            int[] prices = new int[n];
            int[] priceCha = new int[n];
            Map<Integer, Integer> map = new TreeMap<>();
            List<int[]> list = new ArrayList<>();
            for(int i = 0; i< n; i++){
                prices[i] = in.nextInt();
                list.add(new int[]{prices[i], Math.abs(price - prices[i])});
            }
            Collections.sort(list, new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1] == o2[1]){
                        return o1[0] -o2[0];
                    }else{
                        return o1[1] -o2[1];
                    }
                }
            });
            int[] res = new int[num];
            for(int i = 0; i<num; i++){
                res[i] = list.get(i)[0];
            }
            Arrays.sort(res);
            for(int i = 0; i< num; i++){
                System.out.print(res[i] + " ");
            }

        }
    }

}
