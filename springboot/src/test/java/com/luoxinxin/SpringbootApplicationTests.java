package com.luoxinxin;

import com.luoxinxin.component.HelloReceiver;
import com.luoxinxin.component.HelloSender;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private HelloReceiver helloReceiver;
/*    @Test
    public void hello(){
        helloSender.send();
    }

    String aa = StringUtil.EMPTY_STRING;
    @Test
    void contextLoads() {
    }*/
   // Dog.MyMap myMap = null;

    public static void main(String[] args) {
//        HashSet hashSet;
//        HashMap hashMap;
//        int i = 1;
//
//        Collections.synchronizedMap(new HashMap());
//
//        ConcurrentHashMap concurrentHashMap;
//
//        Integer integer;
//
//        Arrays.asList();
//        Integer[] k = {1,2,3,4,5};
//        List<Integer> w = Arrays.asList(k);
//        Collections.reverse(w);
//        w.stream().forEach(r->{
//            System.out.println("l = " + r);
//        });
//        for(int r : w){
//            System.out.println("r = " + r);
//        }
//
//        Collections.sort(w);
//        Collections.reverse(w);
//
//        ArrayList arrayList;
//
//        System.out.println("Double. MIN_VALUE = " + Double.MIN_VALUE);
//
//        String string = "qewrwerqrqwre";
//
//        System.out.println("string.indexOf(e) = " + string.indexOf('e'));
//        System.out.println("string.charAt(3) = " + string.charAt(3));
//        System.out.println("string.replace('q','t') = " + string.replace('q', 't'));
//        System.out.println("string.split('r') = " + string.split("r").length);
//        System.out.println("string.getBytes() = " + string.getBytes());
//        System.out.println("string.substring(3) = " + string.substring(3));
//
//        Thread thread;
        //Thread.holdsLock();
        Object obj1 = new Object();
        Object obj2 = new Object();

        /*new Thread(
                ()->{
                    synchronized (obj1){
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(Thread.currentThread().getName());
                        System.out.println("obj1 = " + obj1);
                        synchronized (obj2){
                            System.out.println("obj2 = " + obj2);
                        }
                    }
                }
        ).start();

        new Thread(
                ()->{
                    synchronized (obj2){
                        System.out.println(Thread.currentThread().getName());
                        System.out.println("obj2 = " + obj2);
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        synchronized (obj1){
                            System.out.println("obj1 = " + obj1);
                        }
                    }
                }
        ).start();*/

        ConcurrentHashMap concurrentHashMap;

        System.out.println( 1f == 0.999999999999f );

    }

    interface caozuo{
        void eat();
        default void kill(){
            System.out.println("\"kill\" = " + "kill");
        }
    }


    class Test{

    }



}
