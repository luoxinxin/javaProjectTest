package com.lxx.spb2hotdev.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    /**
     * 读取文件内容
     * @param path 文件路径
     * @return String
     */
    public static String in(String path){
        String fileContent = "";
        try {
            // 创建一个字符缓冲输入流来读取文件
            BufferedReader reader = new BufferedReader(new FileReader(path));
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

    /**
     * 将字符串写入文件
     * @param content 文件内容
     * @param pathAndName 文件路径
     */
    public static void out(String content, String pathAndName){
        try {
            FileWriter fileWriter = new FileWriter(pathAndName);
            // 将字符串写入文件
            fileWriter.write(content);
            // 关闭文件写入流
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
