package com.lxx.spb2hotdev.util;


import com.lxx.spb2hotdev.annotation.MyAnnotation;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class BeanClassUtil {
    /**
     * 注释转化为注解内容
     * @param classFilePath 类路径
     * @param className 生成文件名
     */
    public static void generateClass(String classFilePath, String className) {
        try {
            //读取类文件并转换为字节数组
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

            // 写入替代后的类文件
            FileOutputStream fos = new FileOutputStream(classFilePath);
            fos.write(updatedString.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据bean 属性 获取属性的MyAnnotation注解的 value
     * @param field
     * @return
     */
    public static String getFieldComment(Field field) {
        // 获取字段的块注释
        String fieldComment = null;
        Annotation[] annotations = field.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation) {
                fieldComment = ((MyAnnotation) annotation).value();
                break;
            }
        }
        return fieldComment;
    }
}
