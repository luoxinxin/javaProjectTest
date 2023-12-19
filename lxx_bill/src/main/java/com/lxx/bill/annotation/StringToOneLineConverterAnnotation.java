package com.lxx.bill.annotation;


import com.lxx.bill.enumbean.StringToIntegerConverterEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author husky
 * @Date 2022/3/15 13:34
 * @Description: 字符串去除换行符
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StringToOneLineConverterAnnotation {
}
