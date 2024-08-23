package com.lxx.designpattern.builder.sqldemo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        SQLQuery query = new SQLQuery.Builder()
                .select("SELECT *")
                .from("FROM Users")
                .where("age", ">", 30)
                .where("name", "LIKE", "John%")
                .groupBy("age")
                .having("COUNT(*) > 1")
                .orderBy("name ASC")
                .limit(10)
                .build();

        System.out.println(query.getQuery());
        System.out.println(query.getParameters());

        Class.forName("com.mysql.cj.jdbc.Driver");
        try (

                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ry-vue", "root", "Vae970109vae");
//                Statement stat = com.createStatement();
//                Connection conn = Database.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query.getQuery())
        ) {

            List<Object> parameters = query.getParameters();
            for (int i = 0; i < parameters.size(); i++) {
                pstmt.setObject(i + 1, parameters.get(i));
            }

            // Execute the query
            pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
