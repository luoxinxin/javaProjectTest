package com.luoxinxin.test;

import java.util.*;

public class c {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String a = in.nextLine();
            String[] b = a.split(" ");
            Set<String> set = new TreeSet<>();

            Map<String, Integer> map = new TreeMap<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if(o2.length() == o1.length()){
                        for(int i = 0; i< o2.length(); i++){
                            if(o2.charAt(i) != o1.charAt(i)){
                                return o2.charAt(i) -o1.charAt(i);
                            }
                        }
                        return 0;
                    }else{
                        return o2.length() -o1.length();
                    }
                }
            });

            for(int i = 0; i< b.length; i++){
                map.put(b[i], map.getOrDefault(b[i], 0) + 1);
            }
            String res = "";
            for(String e : map.keySet()){
                for(int i = 1; i<e.length()-1; i++){
                    String str = e.substring(0, i);
                    Integer c = map.get(str);
                    boolean bool = map.containsKey(e.substring(0, i));
                    if(!map.containsKey(e.substring(0, i)) || map.get(e.substring(0,i)) == 0){
                        res = "";
                        break;
                    }else{
                        res = e;
                    }
                }
                if(!"".equals(res)){
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
