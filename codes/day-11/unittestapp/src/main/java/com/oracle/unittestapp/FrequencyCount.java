package com.oracle.unittestapp;

import java.util.Map;
import java.util.TreeMap;

public class FrequencyCount {
	public Map<String, Integer> countWordFrequency(String sentence) {
		if (sentence == null)
			throw new NullPointerException("sentence is null");

		if (sentence.isBlank() || sentence.isEmpty())
			throw new IllegalArgumentException("sentence is either empty or blank");

		String[] words = sentence.split("[,\\.\\s]");
		Map<String, Integer> output = new TreeMap<>();

		for (String word : words) {
			if (output.containsKey(word.toLowerCase())) {
				output.put(word.toLowerCase(), output.get(word.toLowerCase()) + 1);
			} else {
				output.put(word.toLowerCase(), 1);
			}
		}
		return output;
	}
}
