package com.oracle.pmsapp.repository;

//static member import
import static com.oracle.pmsapp.repository.utilities.DaoUtility.closeConnection;
import static com.oracle.pmsapp.repository.utilities.DaoUtility.convertRecordToModel;
import static com.oracle.pmsapp.repository.utilities.DaoUtility.createConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oracle.pmsapp.models.ProductModel;

public class ProductRepository implements RepositoryContract<ProductModel, Integer> {

	@Override
	public ProductModel insert(ProductModel data) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		String insertQuery = "insert into products(product_id,product_name,product_desc,product_price,product_released_on,category_id) values(?,?,?,?,?,?)";
		int result = 0;
		try {
			connection = createConnection();

			statement = connection.prepareStatement(insertQuery);

			statement.setInt(1, data.getProductId());
			statement.setString(2, data.getProductName());
			statement.setString(3, data.getProductDescription());
			statement.setDouble(4, data.getProductPrice());
			statement.setDate(5, Date.valueOf(data.getProductReleasedOn()));
			statement.setInt(6, data.getCategoryId());

			result = statement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			statement.close();
			closeConnection(connection);
		}
		return result > 0 ? data : null;
	}

	@Override
	public ProductModel remove(Integer id) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		String deleteQuery = "delete from products where product_id=?";
		int result = 0;
		ProductModel model = null;
		try {
			model = get(id);

			connection = createConnection();
			statement = connection.prepareStatement(deleteQuery);
			statement.setInt(1, id);

			result = statement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			statement.close();
			closeConnection(connection);
		}
		return result > 0 ? model : null;
	}

	@Override
	public ProductModel modify(Integer id, ProductModel data) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		String updateQuery = "update products set product_name=?, product_desc=?, product_price=?,product_released_on=?,category_id=? where product_id=?";
		int result = 0;
		try {
			connection = createConnection();

			statement = connection.prepareStatement(updateQuery);

			statement.setInt(6, id);
			statement.setString(1, data.getProductName());
			statement.setString(2, data.getProductDescription());
			statement.setDouble(3, data.getProductPrice());
			statement.setDate(4, Date.valueOf(data.getProductReleasedOn()));
			statement.setInt(5, data.getCategoryId());

			result = statement.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			statement.close();
			closeConnection(connection);
		}
		if (result > 0) {
			data.setProductId(id);
			return data;
		} else
			return null;
	}

	@Override
	public ProductModel get(Integer id) throws Exception {
		Connection connection = null;
		PreparedStatement statement = null;
		String fetchQuery = "select product_id as ID, product_name as NAME, product_desc as DESCRIPTION, product_price as PRICE, product_released_on as RELEASE_DATE, category_id as CATEGORY from products where product_id=?";
		ProductModel model = null;
		ResultSet result = null;
		try {
			connection = createConnection();
			statement = connection.prepareStatement(fetchQuery);
			statement.setInt(1, id);

			result = statement.executeQuery();
			while (result.next()) {
				model = convertRecordToModel(result);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			statement.close();
			closeConnection(connection);
		}
		return model;
	}

	@Override
	public List<ProductModel> getAll() throws Exception {
		Connection connection = null;
		Statement statement = null;
		String fetchQuery = "select product_id as ID, product_name as NAME, product_desc as DESCRIPTION, product_price as PRICE, product_released_on as RELEASE_DATE, category_id as CATEGORY from products";
		List<ProductModel> models = null;
		ResultSet result = null;
		try {
			connection = createConnection();
			statement = connection.createStatement();

			result = statement.executeQuery(fetchQuery);

			models = new ArrayList<ProductModel>();
			while (result.next()) {
				ProductModel model = convertRecordToModel(result);
				models.add(model);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			statement.close();
			closeConnection(connection);
		}
		return models;
	}

}
