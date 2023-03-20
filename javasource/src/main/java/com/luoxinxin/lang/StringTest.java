package com.luoxinxin.lang;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.*;
import java.util.logging.SimpleFormatter;

public class StringTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        for(int i = 0;;){
            System.out.println("SFIT" +i);
            break;
        }
        String str="sfit123456";
        System.out.println("str.substring(1,6).indexOf('t') = " + str.substring(1, 6).indexOf('t'));
        int x=1;
        int a=(~x>>x);
        System.out.println("~x = " + ~x);
        System.out.println("a = " + a);
       /* String a = new String("1") + new String("1");
        String b = "11";
        String c = b.intern();
        System.out.println("a == b = " + a == b);
        System.out.println("c == b = " + c == b);*/
        /*        String  a = new String("1");
        a.intern();
        String b = "1";
        System.out.println("a==b = " + a == b);
        String c = new String("1") + new String("1");
        c.intern();
        String d = "11";
        System.out.println("c == d = " + c == d);*/
        /*String b = "hahaha";
        System.out.println("a==b = " + a == b);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        a.intern();
        System.out.println(a == b);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());*/


        /*String string = new String();
        char[] chars = {'1','2','3'};
        String charArray = new String(chars);
        for(int i = 0;i<chars.length;i++){
            System.out.println(chars[i]);;
        }
        System.out.println(charArray);
        chars[0] = '2';
        for(int i = 0;i<chars.length;i++){
            System.out.println(chars[i]);;
        }
        System.out.println(charArray);
        HashMap map ;
        ConcurrentHashMap concurrentHashMap;
        Comparable comparable;
        Comparator comparator;
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        CopyOnWriteArrayList copyOnWriteArrayList;
        Class clazz = random.getClass();
        clazz.newInstance();
        clazz.getConstructor().newInstance();
        Field field = clazz.getField("hello");
        InputStreamReader inputStreamReader;//字节转化为字符流输入
        OutputStreamWriter outputStreamWriter;//字符转化字节流输出
        BigDecimal bigDecimal;
        SimpleDateFormat simpleDateFormat;
        Semaphore semaphore;
        ThreadPoolExecutor threadPoolExecutor;
        ThreadPoolExecutor threadPoolExecutor1;
        ConcurrentSkipListMap concurrentSkipListMap;
        concurrentSkipListMap.headMap()*/
    }
}
