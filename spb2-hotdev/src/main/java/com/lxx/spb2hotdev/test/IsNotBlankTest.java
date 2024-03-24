package com.lxx.spb2hotdev.test;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
 * isNotBlank 判断加赋值
 */
public class IsNotBlankTest {

    public static void main(String[] args) {
        String a;
        if (StringUtils.isNotBlank(a = get())) {
            System.out.println(a);
        }
        System.out.println(a);
    }

    public static String get(){
        return "";
    }
}
