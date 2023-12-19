package com.lxx.bill.annotation;


import com.lxx.bill.enumbean.StringToIntegerConverterEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author husky
 * @Date 2022/3/15 13:34
 * @Description: 指定字符串转指定数字注解，用于easyExcel。与 CustomStringToIntegerConverter 连用
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StringToIntegerConverterAnnotation {

    /**
     * 带转换枚举
     * @return
     */
    public StringToIntegerConverterEnum[] converterEnums();
}
