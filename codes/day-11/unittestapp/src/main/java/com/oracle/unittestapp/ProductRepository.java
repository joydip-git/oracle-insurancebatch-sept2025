package com.oracle.unittestapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepository {
	public Product getProduct(int id) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String query = "select product_id as Id, product_name as Name, product_desc as Description, product_released_on as ReleaseDate, product_price as Price, category_id as Category from products where product_id=?";
		Product product = null;
		try {
			if (id <= 0)
				throw new IllegalArgumentException("id should be >0");

			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "Oracle@2024");

			statement = connection.prepareStatement(query);
			statement.setInt(1, id);

			result = statement.executeQuery();
			while (result.next()) {
				product = new Product();
				product.setId(result.getInt("Id"));
				product.setName(result.getString("Name"));
				product.setDescription(result.getString("Description"));
				product.setPrice(result.getDouble("Price"));
				product.setReleasedOn(result.getDate("ReleaseDate").toLocalDate());
				product.setCategoryId(result.getInt("Category"));
			}
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} catch (NullPointerException e) {
			throw e;
		} catch (IllegalArgumentException e) {
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
}
