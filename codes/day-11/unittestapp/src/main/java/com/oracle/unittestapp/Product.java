package com.oracle.unittestapp;

import java.time.LocalDate;
import java.util.Objects;

public class Product {

	private int id;
	private String name;
	private String description;
	private LocalDate releasedOn;
	private int categoryId;
	private double price;
	
	public Product() {
	}

	public Product(int id, String name, String description, LocalDate releasedOn, int categoryId, double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.releasedOn = releasedOn;
		this.categoryId = categoryId;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getReleasedOn() {
		return releasedOn;
	}

	public void setReleasedOn(LocalDate releasedOn) {
		this.releasedOn = releasedOn;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", releasedOn=" + releasedOn
				+ ", categoryId=" + categoryId + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		
		if (this == obj)
			return true;
		
		if (getClass() != obj.getClass())
			return false;
		
		Product other = (Product) obj;
		return id == other.id;
	}
	
}
