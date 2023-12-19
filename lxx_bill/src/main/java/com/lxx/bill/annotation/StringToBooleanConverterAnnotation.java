package com.lxx.bill.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author husky
 * @Date 2022/3/15 11:25
 * @Description: 字符串 转布尔 注解，用于easyExcel。与 CustomStringToBooleanConverter 连用
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StringToBooleanConverterAnnotation {

    /**
     * 为true时的字符串
     * @return
     */
    public String trueStr();

    /**
     * 为false时的字符串
     * @return
     */
    public String falseStr();
}
