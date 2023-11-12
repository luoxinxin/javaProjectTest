package com.lxx.spb2hotdev;

import java.io.*;
import java.util.regex.*;
import java.util.StringJoiner;

public class ReplaceTest {
    public static void main(String[] args) {
        // 读取类文件
        String classFilePath = "C:\\Users\\25389\\IdeaProjects\\javaProjectTest\\spb2-hotdev\\src\\main\\java\\com\\lxx\\spb2hotdev\\bean\\Dog.java"; // 替换为实际类文件的路径
        String className = "com.lxx.spb2hotdev.bean.Dogs"; // 替换为实际类名

        try {
            // 读取类文件并转换为字节数组
            FileInputStream fis = new FileInputStream(classFilePath);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
            }
            fis.close();
            byte[] classBytes = bos.toByteArray();
            bos.close();

            // 使用正则表达式替换注释为自定义注解格式
            String classText = new String(classBytes);
            // 使用正则表达式匹配以 /** 开头的注释块
            String pattern = "/\\*\\*.*?\\*/";
            String replacement = "@MyAnnotation(\"\")";

            // 使用正则表达式替换注释块为 @MyAnnotation("")
            String updatedString = classText.replaceAll(pattern, replacement);

            System.out.println(updatedString);
            // 写入替代后的类文件
            FileOutputStream fos = new FileOutputStream(classFilePath);
            fos.write(updatedString.getBytes());
            fos.close();

            // 加载类并验证修改
            Class<?> modifiedClass = Class.forName(className);
            // TODO: 进行进一步的验证或操作

            System.out.println("Class file updated successfully.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
