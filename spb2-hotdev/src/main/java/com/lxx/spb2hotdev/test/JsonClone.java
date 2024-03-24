package com.lxx.spb2hotdev.test;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.lxx.spb2hotdev.bean.*;

import java.math.BigDecimal;

public class JsonClone {

    public static void main(String[] args) {
        // 使用 Hutool 的 JsonUtil 将对象格式化成 JSON 字符串
        Cat cat = new Cat();
//        cat.setName("Tom");
        Dog dog = new Dog();
        dog.setName("jr");
        dog.setCat(cat);
        String jsonString = JSONUtil.toJsonStr(dog);


        System.out.println(StrUtil.equalsAny("4", "4") ? "4" : null);


        // 使用 Hutool 的 JsonUtil 将 JSON 字符串转换为新对象，实现深拷贝
        Dog copiedObject = JSONUtil.toBean(jsonString, Dog.class);
        Cat cat1 = new Cat();
//        cat1.setName("tom1");
        copiedObject.setCat(cat1);

        // 输出拷贝后的对象
        System.out.println("Original Object: " + dog);
        System.out.println("Copied Object: " + copiedObject);

        System.out.println(NumberUtil.isGreater(new BigDecimal("10"), new BigDecimal("10").multiply(new BigDecimal("0.8"))));
    }
}
