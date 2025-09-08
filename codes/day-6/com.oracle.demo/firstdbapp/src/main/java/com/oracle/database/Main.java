package com.oracle.database;

// import oracle.jdbc.driver.OracleDriver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. dynamically load the driver (in Java runtime)
        Class.forName("oracle.jdbc.driver.OracleDriver");

        //2. create connection
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system",
                "Oracle@2024");

        System.out.println(connection.isClosed());

        connection.close();

        System.out.println(connection.isClosed());
    }
}
