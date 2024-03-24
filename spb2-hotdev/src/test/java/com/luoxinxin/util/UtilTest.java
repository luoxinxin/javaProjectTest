package com.luoxinxin.util;

import com.lxx.spb2hotdev.generatebean.Dog;
import com.lxx.spb2hotdev.util.BeanClassUtil;

import java.lang.reflect.Field;

public class UtilTest {
    public static void main(String[] args) {
        UtilTest utilTest = new UtilTest();
        utilTest.fieldComment();
        utilTest.generateClass();
        utilTest.fieldComment();
    }

    /**
     * 获取属性和注释测试
     */
    public void fieldComment(){
        // 获取类的Class对象
        Class<?> myClass = Dog.class;

        // 获取类的所有字段
        Field[] fields = myClass.getDeclaredFields();

        for (Field field : fields) {
            // 获取字段的名称
            String fieldName = field.getName();
            System.out.println("字段名称: " + fieldName);

            // 获取字段的块注释
            String fieldComment = BeanClassUtil.getFieldComment(field);
            if (fieldComment != null) {
                System.out.println("字段注释: " + fieldComment);
            }
        }
    }

    /**
     * 根据类的注释生成注解
     */
    public void generateClass(){
        // 读取类文件
        String classFilePath = "C:\\Users\\25389\\IdeaProjects\\javaProjectTest\\spb2-hotdev\\src\\main\\java\\com\\lxx\\spb2hotdev\\bean\\Dog.java"; // 替换为实际类文件的路径
        String className = "com.lxx.spb2hotdev.bean.Dogs"; // 替换为实际类名
        BeanClassUtil.generateClass(classFilePath, className);
    }


}
