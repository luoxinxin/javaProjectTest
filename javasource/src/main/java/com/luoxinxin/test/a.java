package com.luoxinxin.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

public class a {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //input();

        ArrayList a;
        Vector b;

        List<Integer> c = Arrays.asList(1, 2, 3);
        Integer d;

        Collection e;

        System.out.println(f());
        System.out.println(f2()[0]);

        Collections.synchronizedList(new ArrayList<>());

//        Enum c;

        String encode = URLEncoder.encode("", "utf-8");
        System.out.println(encode);
        System.out.println("");
        System.out.println("1");

        HashMap<Object, Object> map = new HashMap<>();
        map.put(null, "123");


    }

    //测试 修改值类型
    static int f() {
        int ret = 0;
        try {
            return ret; // 返回 0，finally 内的修改效果不起作用
        } finally {
            ret++;
            System.out.println("finally 执行");
        }
    }
    // 测试 修改引用类型
    static int[] f2(){
        int[] ret = new int[]{0};
        try {
            return ret; // 返回 [1]，finally 内的修改效果起了作用
        } finally {
            ret[0]++;
            System.out.println("finally 执行");
        }
    }


    /**
     * 控制台输入
     */
    private static void input() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            System.out.println(solution(a, b, c));
        }
    }

    public static int solution(String a, String b, int k) {
        int n1 = a.length();
        int n2 = b.length();
        int first = 0;
        int end = n1 + k;
        if (end > n2) {
            return -1;
        }
        String str = "";
        for (int i = 0; i < n2 && end <= n2; i++) {
            str = b.substring(first, end);
            String res = str;
            for (int j = 0; j < a.length(); j++) {
                res = res.replace(String.valueOf(a.charAt(j)), "");
            }
            if (res.length() == k) {
                return first;
            }
            first++;
            end++;
        }
        return -1;
    }
}
