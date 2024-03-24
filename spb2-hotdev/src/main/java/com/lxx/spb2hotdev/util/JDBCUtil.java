package com.lxx.spb2hotdev.util;

import java.sql.*;

public class JDBCUtil{
    /**
     * jdbc 执行sql
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void testJdbc() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/information_schema?characterEncoding=utf8&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
        Connection conn = DriverManager.getConnection(url, "root", "Vae970109vae");
        String sql = "select * from information_schema.ENGINES";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            String engine = resultSet.getString("ENGINE");
            String support = resultSet.getString("SUPPORT");
            String comment = resultSet.getString("COMMENT");
            String transactions = resultSet.getString("TRANSACTIONS");
            String xa = resultSet.getString("XA");
            String savepoints = resultSet.getString("SAVEPOINTS");
            System.out.println(engine);
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JDBCUtil jdbc = new JDBCUtil();
        jdbc.testJdbc();
    }

}


