package com.lxx.designpattern.builder.sqldemo1;

public class test {
    public static void main(String[] args) {
        SQLQuery query = new SQLQuery.Builder()
                .select("SELECT *")
                .from("FROM Users")
                .where("age > 30")
                .where("name LIKE 'John%'")
                .build();

        System.out.println(query);
    }
}

