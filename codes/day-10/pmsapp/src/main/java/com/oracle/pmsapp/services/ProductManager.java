package com.oracle.pmsapp.services;

import java.util.List;

import com.oracle.pmsapp.models.ProductModel;
import com.oracle.pmsapp.repository.RepositoryContract;

import jakarta.inject.Inject;

public class ProductManager implements Manager<ProductModel, Integer> {

	@Inject
	private RepositoryContract<ProductModel, Integer> repository;

//	@Inject
//	public ProductManager(RepositoryContract<ProductModel, Integer> repository) {
//		this.repository = repository;
//	}

	@Inject
//	public void setRepository(RepositoryContract<ProductModel, Integer> repository) {
//		this.repository = repository;
//	}

	@Override
	public ProductModel add(ProductModel data) throws Exception {
		try {
			if (data == null)
				throw new NullPointerException("product instance is null");
			
			if (data.getProductId() <= 0)
				throw new Exception("product id should be more than zero");
			
			if (data.getProductName().isBlank() || data.getProductName().isEmpty() || data.getProductName() == null)
				throw new Exception("product name must be present");
			
			return repository.insert(data);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ProductModel delete(Integer id) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public ProductModel fetch(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> fetchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductModel update(Integer id, ProductModel data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
