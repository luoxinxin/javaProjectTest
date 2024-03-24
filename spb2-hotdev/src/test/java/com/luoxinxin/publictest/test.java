package com.luoxinxin.publictest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class test {
    public static void main(String[] args) {
        String yyyyMMdd = LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        System.out.println(yyyyMMdd);
    }
}

