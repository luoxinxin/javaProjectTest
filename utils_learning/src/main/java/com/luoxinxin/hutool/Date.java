package com.luoxinxin.hutool;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.crypto.SecureUtil;
import com.luoxinxin.bean.Person;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Date {
    public static void main(String[] args) {
        String now = DateUtil.now();
        StrUtil.containsAny("hello", "L");
        //DateUtil
        //StrUtil
        //NumberUtil
        //BeanUtil
        //CollUtil
        //MapUtil
        //ArrayUtil
        //IdUtil
        //SecureUtil
        //CaptchaUtil
        //PageUtil
        //ReflectUtil
        //AnnotationUtil
        //URLUtil
        Map<String, Object> beanMap = BeanUtil.beanToMap(new Person());
        String randomUUID = IdUtil.randomUUID();
        String simpleUUID = IdUtil.simpleUUID();
        String next = ObjectId.next();
        String objectId = IdUtil.objectId();
        Snowflake snowflake = IdUtil.getSnowflake();
        long snowflakeId = snowflake.nextId();

        SecureUtil.md5();
//        AnnotationUtil.getAnnotation();

        //获取定义在src/main/resources文件夹中的配置文件
        ClassPathResource resource = new ClassPathResource("generator.properties");
        Properties properties = new Properties();
        try {
            properties.load(resource.getStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        URLUtil.normalize("");

        IdcardUtil.getCityCodeByIdCard("");
        IdcardUtil.getProvinceByIdCard("");

        ArrayList<Integer> intList = CollUtil.newArrayList(1, 2, 3, 4);

        Stream<Integer> sorted = intList.stream().sorted((v1, v2) -> {
            return v1 - v2;
        });
        Comparator.comparing(Person::getAge);


    }
}
