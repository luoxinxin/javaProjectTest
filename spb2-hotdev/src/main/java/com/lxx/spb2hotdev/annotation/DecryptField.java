package com.lxx.spb2hotdev.annotation;

import java.lang.annotation.*;


/**
 * 注解实现解密
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DecryptField {
}

