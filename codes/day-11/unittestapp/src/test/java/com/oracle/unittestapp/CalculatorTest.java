package com.oracle.unittestapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;

//import org.junit.jupiter.api.Assertions;

public class CalculatorTest {
	
	private Calculator calculator;

	@BeforeEach
	public void setUp() {
		// Arrange
		calculator = new Calculator();
	}

	@AfterEach
	public void tearDown() {
		calculator = null;
	}

	@Test
	@DisplayName("Success Test Method for Calculator -> divide")
	void divideSuccessTest() {

		// Arrange
		// Calculator calculator = new Calculator();

		// Act
		int actual = calculator.divide(12, 3);

		// Assert
		int expected = 4;
		// Assertions.assertEquals(expected, actual);
		assertEquals(expected, actual);

		// calculator = null;
	}

	@Test
	@DisplayName("Exception Test Method for Calculator -> divide using try..catch")
	void divideExceptionTest() {
		// Arrange
		// Calculator calculator = new Calculator();

		try {
			// Act
			calculator.divide(12, 0);
		} catch (Exception e) {
			// Assert
			// assertEquals(ArithmeticException.class, e.getClass());
			assertEquals(e.getMessage(), "/ by zero");
		}
	}

	@Test
	@DisplayName("Exception Test Method for Calculator -> divide using assertThrows")
	void divideArithmeticExceptionTest() {
		// Arrange
		// Calculator calculator = new Calculator();

		// Act and Assert
		Executable executable = () -> {
			calculator.divide(12, 0);
		};
		assertThrows(ArithmeticException.class, executable);
	}
	
	@ParameterizedTest
	void divideTestWithMultipleInputs() {
		
	}
}
