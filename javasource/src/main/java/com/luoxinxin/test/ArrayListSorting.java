package com.luoxinxin.test;

import com.luoxinxin.domain.Person;

import java.util.*;

public class ArrayListSorting {
    public Set<String> duplicateRemoval(List<String> stringList){
        stringList.add("hello1");
        stringList.add("hello22");
        stringList.add("hello333");
        stringList.add("hello333");
        stringList.add("hello4444");
        stringList.add("hello55555");
        Set<String> stringSet = new HashSet<>(stringList);
        stringSet.stream().sorted(Comparator.comparingInt(String::length)).forEach(string-> System.out.println(string));
        return stringSet;
    }

    public Set<Person> duplicateRemoval1(List<Person> stringList){
        stringList.add(new Person(1,"hello",11));
        stringList.add(new Person(2,"hello",11));
        stringList.add(new Person(3,"hello",11));
        stringList.add(new Person(4,"hello",11));
        stringList.add(new Person(5,"hello",11));
        stringList.add(new Person(6,"hello",11));
        stringList.add(new Person(8,"hello",11));
        stringList.add(new Person(7,"hello",11));
        stringList.add(new Person(9,"hello",11));
        stringList.add(new Person(10,"hello",11));
        Set<Person> stringSet = new HashSet<>(stringList);
        stringSet.stream().sorted().forEach(string-> System.out.println(string.toString()));
        return stringSet;
    }
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        ArrayListSorting arrayListSorting = new ArrayListSorting();
        arrayListSorting.duplicateRemoval(stringList);
        arrayListSorting.duplicateRemoval1(personList);
    }
}
