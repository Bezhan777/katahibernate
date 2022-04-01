package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String HOST = "jdbc:mysql://localhost:3306/mybase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "rasengan1997";
    private static final String driverClass = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName(driverClass);
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
           connection.setAutoCommit(false);
        } catch (SQLException | NullPointerException | ClassNotFoundException e) {
            System.out.println("error");
        }
        return connection;
    }
}
