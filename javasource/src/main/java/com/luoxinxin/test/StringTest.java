package com.luoxinxin.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringTest {
    public static void main(String[] args) {
        String a = "abc-defg";
        String k = op(a);
        System.out.println("k = " + k);

    }
    public static String op(String param){
        int index = param.indexOf("-");
        StringBuilder stringBuilder = new StringBuilder(param.replace("-", "")).reverse();
        stringBuilder.insert(index, "-");
        return stringBuilder.toString();
    }
}
