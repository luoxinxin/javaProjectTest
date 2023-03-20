package com.luoxinxin.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayListDuplicateRemoval {
    List<String> stringList = new ArrayList<>();
    public Set<String> duplicateRemoval1(List<String> stringList){
        stringList.add("hello1");
        stringList.add("hello2");
        stringList.add("hello3");
        stringList.add("hello3");
        stringList.add("hello4");
        stringList.add("hello5");
        Set<String> stringSet = new HashSet<>(stringList);
        stringSet.stream().forEach(string-> System.out.println(string));
        return stringSet;
    }

    public Set<String> duplicateRemoval2(List<String> stringList){
        stringList.add("hello1");
        stringList.add("hello2");
        stringList.add("hello3");
        stringList.add("hello3");
        stringList.add("hello4");
        stringList.add("hello5");
        Set<String> stringSet = new HashSet<>();
        stringSet.addAll(stringList);
        stringSet.stream().forEach(string-> System.out.println(string));
        return stringSet;
    }

    public List<String> duplicateRemoval3(List<String> stringList){
        stringList.add("hello1");
        stringList.add("hello2");
        stringList.add("hello3");
        stringList.add("hello3");
        stringList.add("hello4");
        stringList.add("hello5");
        List<String> newString = stringList.stream().distinct().collect(Collectors.toList());
        newString.stream().forEach(string -> System.out.println(string));
        return newString;
    }

    public List<String> duplicateRemoval4(List<String> stringList){
        stringList.add("hello1");
        stringList.add("hello2");
        stringList.add("hello3");
        stringList.add("hello3");
        stringList.add("hello4");
        stringList.add("hello5");
        List<String> stringListTmp = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String temp = stringList.get(i);
            if (i == (stringList.lastIndexOf(stringList.get(i)))) {
                stringListTmp.add(stringList.get(i));
            }
        }
        stringListTmp.stream().forEach(string-> System.out.println(string));
        return stringListTmp;
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        ArrayListDuplicateRemoval arrayListDuplicateRemoval = new ArrayListDuplicateRemoval();
        //arrayListDuplicateRemoval.duplicateRemoval1(stringList);
        //arrayListDuplicateRemoval.duplicateRemoval2(stringList);
        //arrayListDuplicateRemoval.duplicateRemoval3(stringList);
        arrayListDuplicateRemoval.duplicateRemoval4(stringList);
    }
}
