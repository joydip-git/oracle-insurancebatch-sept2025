package com.oracle.pmsapp.repository.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.oracle.pmsapp.models.ProductModel;

public class DaoUtility {
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		loadDriver();

		String url = "";
		String userName = "";
		String password = "";

		return DriverManager.getConnection(url, userName, password);
	}

	public static void closeConnection(Connection connection) throws SQLException {
		if (connection != null)
			connection.close();
	}

	public static ProductModel convertRecordToModel(ResultSet result) throws SQLException {
		ProductModel model = new ProductModel();
		model.setProductId(result.getInt("ID"));
		model.setProductName(result.getString("NAME"));
		model.setProductDescription(result.getString("DESCRIPTION"));
		model.setProductPrice(result.getDouble("PRICE"));
		model.setProductReleasedOn(result.getDate("RELEASE_DATE").toLocalDate());
		model.setCategoryId(result.getInt("CATEGORY"));
		return model;
	}

	private static void loadDriver() throws ClassNotFoundException {
		String driver = "";
		Class.forName(driver);
	}
}
