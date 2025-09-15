package com.oracle.unittestapp;

public class StringManipulator {
	public String reverse(String value) {
		try {
			if (value == null)
				throw new NullPointerException("the value passed in null");
			if (value.isEmpty() || value.isBlank())
				throw new IllegalArgumentException("argument is either blank or empty");

			String reversed = "";
			for (int i = value.length() - 1; i >= 0; i--) {
				reversed += value.charAt(i);
			}
			return reversed;
		} catch (IndexOutOfBoundsException e) {
			throw e;
		} catch (NullPointerException e) {
			throw e;
		} catch (IllegalArgumentException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}
}
