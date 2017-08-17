package org.awesome.servlet;

import java.sql.*;

public class DbStatement {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/awesomeServlet";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Statement statement = null;

    private DbStatement() {}

    private static Statement createStatement() throws Exception {
        Class.forName(JDBC_DRIVER);

        return DriverManager.getConnection(DB_URL, USER, PASSWORD).createStatement();
    }

    public static Statement get() throws Exception {
        if (DbStatement.statement == null) {
            DbStatement.statement = DbStatement.createStatement();
        }

        return DbStatement.statement;
    }

}
