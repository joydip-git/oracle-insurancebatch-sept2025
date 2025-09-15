package com.oracle.unittestapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

	private ProductRepository repository;

	@BeforeEach
	void setUp() {
		repository = new ProductRepository();
	}

	@AfterEach
	void tearDown() {
		repository = null;
	}

	@Test
	void getProductSuccessTest() throws ClassNotFoundException, SQLException {
		Product actual = repository.getProduct(101);
		Product expected = new Product(101, "iphone 16", "new phone from apple", LocalDate.of(2025, 7, 23), 2, 70000);
		assertEquals(expected, actual);// expected.equals(actual)
	}

	@Test
	void getProductIllegalArgumentTest() throws ClassNotFoundException, SQLException {
		assertThrows(IllegalArgumentException.class, () -> {
			repository.getProduct(-1);
		});
	}
}
