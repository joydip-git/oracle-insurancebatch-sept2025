package com.oracle.unittestapp;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FrequencyCountTest {

	private FrequencyCount frequencyCount;
	// write unit test case methods to test the countWordFrequency() method
	// test for
	// 1. success (with multiple sentences, at least 2 sentences)
	// 2. exception test:
	// a. if the sentence if null -> NullPointerException
	// b. if the sentence is empty or blank -> IllegalArgumentException

	@BeforeEach
	void setUp() {
		frequencyCount = new FrequencyCount();
	}

	@AfterEach
	void tearDown() {
		frequencyCount = null;
	}

	@ParameterizedTest
	@ValueSource(strings = { "I teach Java. I am working on Java for last 20 years, since 2005." })
	void countWordFrequencySuccessTest(String sentence) {
		Map<String, Integer> actual = frequencyCount.countWordFrequency(sentence);
	}
}
