package org.awesome.servlet;

import java.sql.*;

public class DbConnection {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/awesomeServlet";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Statement getStatement() {
        try {
            Class.forName(JDBC_DRIVER);

            return DriverManager.getConnection(DB_URL, USER, PASSWORD).createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
