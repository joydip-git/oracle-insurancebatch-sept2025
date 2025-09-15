package com.oracle.unittestapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

	@ParameterizedTest
	@ValueSource(strings = { "joydip mondal", "I work. for Oracle" })
	void reverseSuccessTestWithMultipleInputs(String value) {
		String actualReversedString = manipulator.reverse(value);
		List<String> expectedOutputs = List.of("ladnom pidyoj","elcarO rof .krow I");
		//anyMatch => Returns whether any elements of this stream match the provided predicate. May not evaluate the predicate on all elements if not necessary for determining the result. If the stream is empty then false is returned and the predicate is not evaluated.
		assertTrue(expectedOutputs.stream().anyMatch(s->s.equals(actualReversedString)));
	}
}
