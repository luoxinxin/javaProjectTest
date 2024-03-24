package com.lxx.spb2hotdev.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 值拷贝 引用拷贝
 */
public class CopyTest{
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
//        CopyTest testq = new CopyTest();
//        String a = null;
//        int b = 2;
//        testq.handle(a);
//        testq.handleInt(b);
//        System.out.println(a);
//        System.out.println(b);

        User1 user1 = new User1();
        User2 user2 = new User2();
        Method hello1 = Arrays.stream(User1.class.getMethods()).filter(item -> item.getName().contains("hello")).findFirst().get();
        hello1.invoke(user2);

    }
    public void handle(String a){
        a = "123";
        System.out.println(a);
    }

    public void handleInt(Integer a){
        a = 123;
        System.out.println(a);
    }
    static class User1  {
        public void hello() {
            System.out.println("1111");
        }
    }
    static class User2  extends User1 {
        public void hello() {
            System.out.println("before proxy");
            super.hello();
            System.out.println("after proxy");
        }
    }
}
