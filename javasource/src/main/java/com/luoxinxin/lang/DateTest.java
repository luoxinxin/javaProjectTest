package com.luoxinxin.lang;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class DateTest {
    public static void main(String[] args) throws InterruptedException, UnknownHostException {
/*        Date openDate = new Date();
        System.out.println(openDate);
        Date soutDate = new Date();
        System.out.println(soutDate);
        Thread.sleep(1000);
        Date openTime = new Date();
        System.out.println(openTime);
        soutDate.setDate(openDate.getDate());
        soutDate.setTime(openTime.getTime());
        System.out.println(soutDate);*/
     /*   Object object = null;
        Map map = (Map)object;
        System.out.println(object);
        String year = Integer.toString(new Date().getYear());
        System.out.println(new Date().getYear()+1987);
        System.out.println("year = " + year);
        System.out.println("String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) = " + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
        System.out.println("Calendar.YEAR = " + Calendar.YEAR);
        //打印今天日期*/


        System.out.println("InetAddress.getLocalHost().getHostAddress() = " + InetAddress.getLocalHost().getHostAddress());


    }
}
