package com.lxx.spb2hotdev;

import com.lxx.spb2hotdev.bean.Dogs;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) {
        // 获取类的Class对象
        Class<?> myClass = Dog.class;

        // 获取类的所有字段
        Field[] fields = myClass.getDeclaredFields();

        for (Field field : fields) {
            // 获取字段的名称
            String fieldName = field.getName();
            System.out.println("字段名称: " + fieldName);

            // 获取字段的块注释
            String fieldComment = getFieldComment(field);
            if (fieldComment != null) {
                System.out.println("字段注释: " + fieldComment);
            }
        }
    }

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

