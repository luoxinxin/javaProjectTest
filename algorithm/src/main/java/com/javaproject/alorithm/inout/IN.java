package com.javaproject.alorithm.inout;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IN {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数据，输入#表示结束");
        while (scanner.hasNext()) {
            String next = scanner.next();
//            if(next.equals("#")){
//                break;
//            }
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a+b);
            break;
        }
    }

    /**
     * 字符串输入方法模版1
     * @throws IOException
     */
    public void in1() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 读取输入数据
        int n = Integer.parseInt(reader.readLine()); // 输入行数或数据数量
        String[] input = new String[n]; // 创建数组或集合来存储输入数据
        for (int i = 0; i < n; i++) {
            input[i] = reader.readLine(); // 逐行读取输入数据
        }
    }
}
