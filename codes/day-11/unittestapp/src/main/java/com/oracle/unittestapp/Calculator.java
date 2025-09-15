package com.oracle.unittestapp;

public class Calculator {
	public int divide(int a, int b) {
		try {
			return a / b;			
		}catch(ArithmeticException e) {
			throw e;
		}catch(Exception e) {
			throw e;
		}
	}
}
