package com.oracle.pmsapp.models;

import java.time.LocalDate;

public class ProductModel {
	private int productId;
	private String productName;
	private String productDescription;
	private double productPrice;
	private LocalDate productReleasedOn;
	private int categoryId;
	
	public ProductModel() {
	}

	public ProductModel(int productId, String productName, String productDescription, double productPrice,
			LocalDate productReleasedOn, int categoryId) {
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productReleasedOn = productReleasedOn;
		this.categoryId = categoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public LocalDate getProductReleasedOn() {
		return productReleasedOn;
	}

	public void setProductReleasedOn(LocalDate productReleasedOn) {
		this.productReleasedOn = productReleasedOn;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + ", productReleasedOn=" + productReleasedOn
				+ ", categoryId=" + categoryId + "]";
	}	
}
