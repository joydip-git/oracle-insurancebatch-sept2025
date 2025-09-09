package com.oracle.database.repository;

import java.io.IOException;
import java.io.InputStream;
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

    private Properties databaseConfiguration;    

    private void loadConfiguration() throws IOException {
        InputStream stream = null;
        try {
            databaseConfiguration = new Properties();

            stream = this
                    .getClass()
                    .getClassLoader()
                    .getResourceAsStream("databaseconfig.properties");
            databaseConfiguration.load(stream);
        } catch (IOException e) {
            throw e;
        } finally {
            if (stream != null)
                stream.close();
        }
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
        return product;
    }

    public ProductRepository() throws IOException {
        loadConfiguration();
    }
    
    public List<Product> getAll() throws ClassNotFoundException, SQLException, Exception {

        List<Product> products = null;
        Connection connection = null;
        Statement statement = null;
        try {
            connection = createConnection();
            String query = databaseConfiguration.getProperty("SELECT_ALL_QUERY");

            if (query == null || query.isBlank() || query.isEmpty())
                throw new Exception("query not found...");

            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);

            products = new ArrayList<>();
            while (result.next()) {
                Product product = mapResultSetRecordToProduct(result);
                products.add(product);
            }
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            if (statement != null)
                statement.close();

            if (connection != null)
                connection.close();
        }
        return products;
    }

    public Product get(int productId) throws ClassNotFoundException, SQLException, Exception {
        Product product = null;
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = createConnection();

            // parameterized query
            String query = databaseConfiguration.getProperty("SELECET_SINGLE_QUERY");
            if (query == null || query.isBlank() || query.isEmpty())
                throw new Exception("query not found...");

            statement = connection.prepareStatement(query);
            statement.setInt(1, productId);

            ResultSet result = statement.executeQuery();
            while (result.next()) {
                product = mapResultSetRecordToProduct(result);
            }
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            if (statement != null)
                statement.close();

            if (connection != null)
                connection.close();
        }

        return product;

    }

    public boolean insert(Product product) throws ClassNotFoundException, SQLException, Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = createConnection();

            String query = databaseConfiguration.getProperty("INSERT_QUERY");
            if (query == null || query.isBlank() || query.isEmpty())
                throw new Exception("query not found...");

            statement = connection.prepareStatement(query);
            statement.setInt(1, product.getId());
            statement.setString(2, product.getName());
            statement.setString(3, product.getDescription());
            statement.setDouble(4, product.getPrice());
            statement.setDate(5, Date.valueOf(product.getReleasedOn()));
            statement.setInt(6, product.getCategoryId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            if (statement != null)
                statement.close();

            if (connection != null)
                connection.close();
        }
        return result > 0;
    }

    public boolean update(int id, Product product) throws ClassNotFoundException, SQLException, Exception {

        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            connection = createConnection();

            String query = databaseConfiguration.getProperty("UPDATE_QUERY");

            if (query == null || query.isBlank() || query.isEmpty())
                throw new Exception("query not found...");

            statement = connection.prepareStatement(query);
            statement.setInt(6, id);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setDate(4, Date.valueOf(product.getReleasedOn()));
            statement.setInt(5, product.getCategoryId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            if (statement != null)
                statement.close();

            if (connection != null)
                connection.close();
        }
        return result > 0;
    }

    public boolean delete(int id) throws ClassNotFoundException, SQLException, Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            connection = createConnection();

            String query = databaseConfiguration.getProperty("DELETE_QUERY");
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);

            result = statement.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            if (statement != null)
                statement.close();

            if (connection != null)
                connection.close();
        }

        return result > 0;
    }
}
