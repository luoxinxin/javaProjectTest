package com.lxx.spb2hotdev.annotation;

import java.lang.annotation.*;


/**
 * 注解实现加密
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EncryptField {
}

