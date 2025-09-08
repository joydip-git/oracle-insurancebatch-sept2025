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
        }

        statement.close();
        connection.close();

        return product;

    }
}
