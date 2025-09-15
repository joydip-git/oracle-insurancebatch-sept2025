package com.oracle.unittestapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringManipulatorTest {

	private StringManipulator manipulator;

	@BeforeEach
	void setUp() {
		manipulator = new StringManipulator();
	}

	@AfterEach
	void tearDown() {
		manipulator = null;
	}

	@Test
	void reverseSuccessTest() {
		String actual = manipulator.reverse("joydip");
		assertEquals("pidyoj", actual);
	}
}
