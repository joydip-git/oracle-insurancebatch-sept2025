package com.oracle.database.models;

import java.time.LocalDate;

public class Product {

    private int id;
    private String name;
    private double price;
    private String description;
    private LocalDate releasedOn;
    private int categoryId;

    public Product() {
    }

    public Product(int categoryId, String description, int id, String name, double price, LocalDate releasedOn) {
        this.categoryId = categoryId;
        this.description = description;
        this.id = id;
        this.name = name;
        this.price = price;
        this.releasedOn = releasedOn;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Integer.hashCode(id);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Product)) {
            return false;
        }

        Product other = (Product) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
                + ", releasedOn=" + releasedOn + ", categoryId=" + categoryId + "]";
    }    
}
