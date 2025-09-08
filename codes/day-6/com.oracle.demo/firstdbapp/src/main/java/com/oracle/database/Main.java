package com.oracle.database;

// import oracle.jdbc.driver.OracleDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        getAll();
    }

    private static void getAll() throws ClassNotFoundException, SQLException {
        //1. dynamically load the driver (in Java runtime)
        Class.forName("oracle.jdbc.driver.OracleDriver");

        //2. create connection
        //getConnection() creates an instance of a class which implements the Connection interface (up-casting)
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system",
                "Oracle@2024");

        //3. create a statement
        String query = "select * from products";
        //createStatement() creates an object of a class which implements the Statement interface (upcasting)
        Statement statement = connection.createStatement();

        //4. execute the query using executeQuery method (for SELECT queries)
        //the returned record(s) will be stored in an instance of ResultSet type (the class which implements the ResultSet interface) object created by executeQuery() method
        ResultSet result = statement.executeQuery(query);

        //ResultSet provides a cursor to read through the records, one record at a time (use next() method)
        while (result.next()) {
            //fetch data from every column of the current record (as pointed by the cursor)
            System.out.println(
                    result.getInt("product_id")
                    + "\t"
                    + result.getString("product_name")
                    + "\t"
                    + result.getDouble("product_price")
                    + "\t"
                    + result.getString("product_desc")
                    + "\t"
                    + result.getDate("product_released_on")
                    + "\t"
                    + result.getInt("category_id")
            );
        }

        statement.close();
        connection.close();
    }
}
