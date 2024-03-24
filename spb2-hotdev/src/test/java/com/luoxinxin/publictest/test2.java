package com.luoxinxin.publictest;

import com.lxx.spb2hotdev.util.FileUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test2 {
    public static void main(String[] args) {
        String input = FileUtil.in("C:\\Users\\25389\\IdeaProjects\\javaProjectTest\\spb2-hotdev\\src\\main\\java\\com\\lxx\\spb2hotdev\\bean\\Dog.java");
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
        FileUtil.out(replacedCode.toString(), "C:\\Users\\25389\\IdeaProjects\\javaProjectTest\\spb2-hotdev\\src\\main\\java\\com\\lxx\\spb2hotdev\\bean\\Dog_bak.java");
        System.out.println(replacedCode.toString());
    }
}
