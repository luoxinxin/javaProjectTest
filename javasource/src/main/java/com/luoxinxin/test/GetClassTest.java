package com.luoxinxin.test;

import com.luoxinxin.domain.Father;
import com.luoxinxin.domain.Person;
import com.luoxinxin.domain.Son;

public class GetClassTest {
    public void test(Integer param){

    }
    public static void main(String[] args) throws ClassNotFoundException {
        String a = "hello";
        Object b = a;
        Person person = new Person();
        System.out.println(b.getClass());//Object
        System.out.println(String.class);
        System.out.println("Person.class.getClass() = " + Person.class);
        System.out.println("person.getClass() = " + person.getClass());
        Class clz = Class.forName("com.luoxinxin.domain.Person");
        System.out.println(clz);
        System.out.println("Class.forName(\"com.luoxinxin.domain.Person\").getClass() = " + Class.forName("com.luoxinxin.domain.Person"));

        Father father = new Son();
        System.out.println(father.hello);
    }
}
