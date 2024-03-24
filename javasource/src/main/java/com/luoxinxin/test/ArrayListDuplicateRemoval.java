package com.luoxinxin.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description: ArrayList去重
 * @Version: 1.0
 **/
public class ArrayListDuplicateRemoval {

    private List<String> createList() {
        List<String> stringList = new ArrayList<>();
        stringList.add("hello1");
        stringList.add("hello2");
        stringList.add("hello3");
        stringList.add("hello3");
        stringList.add("hello4");
        stringList.add("hello5");
        return stringList;
    }

    /**
     * 利用set将list去重
     * @return
     */
    public Set<String> duplicateRemoval1(){
        List<String> list = createList();
        Set<String> stringSet = new HashSet<>(list);
        stringSet.stream().forEach(string-> System.out.println(string));
        return stringSet;
    }

    /**
     * 利用set将list去重
     * @return
     */
    public Set<String> duplicateRemoval2(){
        List<String> list = createList();
        Set<String> stringSet = new HashSet<>();
        stringSet.addAll(list);
        stringSet.stream().forEach(string-> System.out.println(string));
        return stringSet;
    }

    /**
     * 利用stream流将list去重 distinct
     * @return
     */
    public List<String> duplicateRemoval3(){
        List<String> list = createList();
        List<String> newString = list.stream().distinct().collect(Collectors.toList());
        newString.stream().forEach(string -> System.out.println(string));
        return newString;
    }

    /**
     * 利用for循环将list去重
     * @return
     */
    public List<String> duplicateRemoval4(){
        List<String> stringList = createList();
        List<String> stringListTmp = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            if (i == (stringList.lastIndexOf(stringList.get(i)))) {
                stringListTmp.add(stringList.get(i));
            }
        }
        stringListTmp.stream().forEach(string-> System.out.println(string));
        return stringListTmp;
    }

    public static void main(String[] args) {
        ArrayListDuplicateRemoval arrayListDuplicateRemoval = new ArrayListDuplicateRemoval();
        arrayListDuplicateRemoval.duplicateRemoval1();
        arrayListDuplicateRemoval.duplicateRemoval2();
        arrayListDuplicateRemoval.duplicateRemoval3();
        arrayListDuplicateRemoval.duplicateRemoval4();
    }
}
