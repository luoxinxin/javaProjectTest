package com.lxx.spb2hotdev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readfile {

    public static String main(String[] args) {
        String filePath = "C:\\Users\\25389\\IdeaProjects\\javaProjectTest\\spb2-hotdev\\src\\main\\java\\com\\lxx\\spb2hotdev\\bean\\Dog.java"; // 你需要替换成实际文件的路径

        String fileContent = "";
        try {
            // 创建一个字符缓冲输入流来读取文件
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            // 逐行读取文件内容并附加到字符串构建器
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n"); // 如果需要保留换行符
                // 或者 stringBuilder.append(line); // 如果不需要保留换行符
            }

            // 关闭文件读取器
            reader.close();

            // 将字符串构建器中的内容转换为一个字符串
            fileContent = stringBuilder.toString();

            // 打印文件内容
            System.out.println(fileContent);
            return fileContent;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}


