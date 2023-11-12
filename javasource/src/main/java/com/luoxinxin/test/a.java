package com.luoxinxin.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            System.out.println(solution(a, b, c));
        }
    }

    public static int solution(String a, String b, int k){
        int n1 = a.length();
        int n2 = b.length();
        int first = 0;
        int end = n1 + k;
        if(end>n2){
            return -1;
        }
        String str = "";
        for(int i = 0; i< n2 && end<=n2; i++){
            str = b.substring(first, end);
            String res = str;
           for(int j = 0; j < a.length(); j++){
                res = res.replace(String.valueOf(a.charAt(j)), "");
           }
           if(res.length() == k){
               return first;
           }
           first++;
           end++;
        }
        return -1;
    }
}
