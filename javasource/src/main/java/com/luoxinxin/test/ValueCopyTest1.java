package com.luoxinxin.test;

/**
 * Java 值拷贝
 */
public class ValueCopyTest1 {
    String name;
    static final String name1 = "name1";

    public static void main(String[] args) {
        ValueCopyTest1  valueCopyTest1 = new ValueCopyTest1();
        valueCopyTest1.test(valueCopyTest1.name1);
        valueCopyTest1.test1(valueCopyTest1.name1);
    }

    /**
     * 值拷贝
     * @param name1
     */
    public void test(String name1){
        System.out.println(name1);
        name1 = "name2";
        final String name11 = "name11";
        System.out.println(name1);
        System.out.println(name11);
    }

    /**
     * 参数final修饰 方法里不能修改其值
     * @param name1
     */
    public void test1(final String name1){
        System.out.println(name1);
    }
}
