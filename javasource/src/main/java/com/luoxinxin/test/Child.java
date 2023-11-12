package com.luoxinxin.test;


class Person {
    private String name = "Person";
    int age = 0;

    protected void p() {
    }

    ;

    public Person() {
        System.out.println("Person");
    }
}


public class Child extends Person {

    public String grade;

    public Child(String grade) {
        super();
        this.grade = grade;
        //super();
    }

    public final void info() {
        //System.out.println("name:"+name+",age:"+age);
    }

    public final void info(int i) {
        //System.out.println("name:"+name+",age:"+age);
    }

    int i = 12;


    public static void main(String[] args) {

        int i = 12;
        System.out.println(i += i -= i *= i);

    }

}


