package com.lxx.designpattern.builder.sqldemo2;

import java.sql.*;
import java.util.List;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SQLQuery query = new SQLQuery.Builder()
                .select("SELECT *")
                .from("FROM sys_user")
                .where("email like ", "%.com")
                .where("user_name LIKE ", "John%")
                .groupBy("user_id")
                .having("COUNT(*) > 1")
                .orderBy("sex ASC")
                .limit(10)
                .build();

        System.out.println(query.getQuery());
        System.out.println(query.getParameters());

        // Execute the query using a PreparedStatement (to avoid SQL injection)
        // Replace with your database connection method
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
