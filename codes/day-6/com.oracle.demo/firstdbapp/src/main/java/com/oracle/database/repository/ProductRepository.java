package com.oracle.database.repository;

import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
//import java.net.URL;
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
import java.util.Properties;

import com.oracle.database.models.Product;

public class ProductRepository {

    //The Properties class represents a persistent set of properties. The Properties can be saved to a stream or loaded from a stream. Each key and its corresponding value in the property list is a string.
    private Properties databaseConfiguration;

    public ProductRepository() throws FileNotFoundException, IOException {
        databaseConfiguration = new Properties();

        //1. using InputStream
        InputStream stream = this
                .getClass()
                .getClassLoader()
                .getResourceAsStream("databaseconfig.properties");
        databaseConfiguration.load(stream);
        stream.close();

        //2. using FileReader
        //Class URL represents a Uniform Resource Locator, a pointer to a "resource" on the World Wide Web. A resource can be something as simple as a file or a directory, or it can be a reference to a more complicated object, such as a query to a database or to a search engine.
        // URL url = this
        //         .getClass()
        //         .getClassLoader()
        //         .getResource("databaseconfig.properties");
        // String path = url.getPath();
        // FileReader reader = new FileReader(path);
        // databaseConfiguration.load(reader);
        // reader.close();
    }

    private Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(databaseConfiguration.getProperty("driverName"));
        Connection connection = DriverManager.getConnection(
                databaseConfiguration.getProperty("url"),
                databaseConfiguration.getProperty("userName"),
                databaseConfiguration.getProperty("password"));

        return connection;
    }

    private Product mapResultSetRecordToProduct(ResultSet result) throws SQLException {
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
        return product;
    }

    public List<Product> getAll() throws ClassNotFoundException, SQLException {

        List<Product> products = null;

        Connection connection = createConnection();
        String query = databaseConfiguration.getProperty("SELECT_ALL_QUERY");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(query);
        
        products = new ArrayList<>();
        while (result.next()) {
            Product product = mapResultSetRecordToProduct(result);
            products.add(product);
        }

        statement.close();
        connection.close();

        return products;
    }

    public Product get(int productId) throws ClassNotFoundException, SQLException {
        Product product = null;
        Connection connection = createConnection();

        //parameterized query
        String query = databaseConfiguration.getProperty("SELECET_SINGLE_QUERY");
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, productId);

        ResultSet result = statement.executeQuery();
        while (result.next()) {
                product = mapResultSetRecordToProduct(result);
        }

        statement.close();
        connection.close();

        return product;

    }

    public boolean insert(Product product) throws ClassNotFoundException, SQLException {
        Connection connection = createConnection();

        String query = databaseConfiguration.getProperty("INSERT_QUERY");
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
        Connection connection = createConnection();

        String query = databaseConfiguration.getProperty("UPDATE_QUERY");
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
        Connection connection = createConnection();

        String query = databaseConfiguration.getProperty("DELETE_QUERY");
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);

        int result = statement.executeUpdate();

        statement.close();
        connection.close();

        return result > 0;
    }
}
