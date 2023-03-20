package com.testmaven.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {

    public void iteratorEntrySet(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public void iteratorKeySet(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Integer key = iterator.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }

    public void forEachEntrySet(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
        for(Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public void forEachKeySet(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
        for(Integer key : map.keySet()){
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }

    public void mapForEach(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
        map.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
        });
    }

    public void singleStreams(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
        map.entrySet().stream().forEach((entry)->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }

    public void parallerlStreams(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
        map.entrySet().parallelStream().forEach((entry)->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }
    public static void main(String[] args) {
        HashMapTest hashMapTest = new HashMapTest();
        //hashMapTest.iteratorEntrySet();
        //hashMapTest.iteratorKeySet();
        //hashMapTest.forEachEntrySet();
        //hashMapTest.forEachKeySet();
        //hashMapTest.mapForEach();
        hashMapTest.parallerlStreams();
    }

}
