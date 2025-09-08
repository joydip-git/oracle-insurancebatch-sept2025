package com.oracle.database.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.oracle.database.models.Product;

public class ProductRepository {

    public List<Product> getAll() throws ClassNotFoundException, SQLException {

        List<Product> products = null;

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl",
                "system",
                "Oracle@2024");

        String query = "select * from products";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        products = new ArrayList<>();

        while (result.next()) {
            Product product = new Product();
            product.setId(result.getInt("product_id"));
            product.setName(result.getString("product_name"));
            product
                    .setDescription(
                            result.getString("product_desc")
                    );
            product
                    .setPrice(
                            result.getDouble("product_price")
                    );

            Date date = result.getDate("product_released_on");
            LocalDate releasedOn = date.toLocalDate();
            product.setReleasedOn(releasedOn);

            product
                    .setCategoryId(
                            result.getInt("category_id")
                    );

            products.add(product);
        }

        statement.close();
        connection.close();

        return products;
    }

    public Product get(int productId) throws ClassNotFoundException, SQLException {
        Product product = null;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl",
                "system",
                "Oracle@2024");

        //parameterized query
        String query = "select * from products where product_id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, productId);

        ResultSet result = statement.executeQuery();
        while (result.next()) {
            product = new Product();
            product.setId(result.getInt("product_id"));
            product.setName(result.getString("product_name"));
            product
                    .setDescription(
                            result.getString("product_desc"));
            product
                    .setPrice(
                            result.getDouble("product_price"));

            Date date = result.getDate("product_released_on");
            LocalDate releasedOn = date.toLocalDate();
            product.setReleasedOn(releasedOn);

            product
                    .setCategoryId(
                            result.getInt("category_id"));
        }

        statement.close();
        connection.close();

        return product;

    }

    public boolean insert(Product product) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl",
                "system",
                "Oracle@2024");

        String query = "insert into products(product_id,product_name,product_desc,product_price,product_released_on,category_id) values(?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, product.getId());
        statement.setString(2, product.getName());
        statement.setString(3, product.getDescription());
        statement.setDouble(4, product.getPrice());
        statement.setDate(5, Date.valueOf(product.getReleasedOn()));
        statement.setInt(6, product.getCategoryId());

        //common method to execute any query and returns boolean
        //statement.execute();
        // executeUpdate(): Executes the SQL statement in this PreparedStatement object, which must be an SQL Data Manipulation Language (DML) statement, such as INSERT, UPDATE or DELETE; or an SQL statement that returns nothing, such as a DDL statement.
        int result = statement.executeUpdate();

        statement.close();
        connection.close();

        return result > 0;
    }

    public boolean update(int id, Product product) throws ClassNotFoundException, SQLException {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(
                            "jdbc:oracle:thin:@localhost:1521:orcl",
                            "system",
                            "Oracle@2024");

            String query = "update products set product_name=?,product_desc=?,product_price=?,product_released_on=?,category_id=? where product_id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(6, id);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setDate(4, Date.valueOf(product.getReleasedOn()));
            statement.setInt(5, product.getCategoryId());

            int result = statement.executeUpdate();

            statement.close();
            connection.close();

            return result > 0;
    }
    
    public boolean delete(int id) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:orcl",
                "system",
                "Oracle@2024");

        String query = "delete from products where product_id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        int result = statement.executeUpdate();

        statement.close();
        connection.close();

        return result > 0;
    }
}
