package com.lxx.spb2hotdev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
    public static void main(String[] args) {
        String input = in("C:\\Users\\25389\\IdeaProjects\\javaProjectTest\\spb2-hotdev\\src\\main\\java\\com\\lxx\\spb2hotdev\\bean\\Dog.java");
        // 使用正则表达式匹配块注释
        Pattern pattern = Pattern.compile("/\\*\\*(.*?)\\*/", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(input);
        StringBuffer replacedCode = new StringBuffer();
        while (matcher.find()) {
            String matchedContent = matcher.group(); // 获取匹配的整个注释块
            // 去除前后的换行和*号
            String cleanedContent = matchedContent.substring(3, matchedContent.length() - 2).trim().replace("\n", "").replace("*", "").trim();
            matcher.appendReplacement(replacedCode, "@MyAnnotation(\"" + cleanedContent + "\")");
        }
        matcher.appendTail(replacedCode);
        out(replacedCode.toString(), "C:\\Users\\25389\\IdeaProjects\\javaProjectTest\\spb2-hotdev\\src\\main\\java\\com\\lxx\\spb2hotdev\\bean\\Dog_bak.java");
        System.out.println(replacedCode.toString());
    }

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

    public static void out(String content, String pathAndName){
        try {
//            String fileName = "output.txt"; // 文件名
            FileWriter fileWriter = new FileWriter(pathAndName);

            // 将字符串写入文件
            fileWriter.write(content);

            // 关闭文件写入流
            fileWriter.close();

            System.out.println("String has been written to " + pathAndName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
