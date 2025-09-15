package com.oracle.unittestapp;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			Calculator calculator = new Calculator();
			int result = calculator.divide(12, 0);
			System.out.println(result);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
