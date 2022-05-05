package com.rahul.practice.java8.lambda;

public class Java8Tester {

	public static void main(String... args) {

		Java8Tester tester = new Java8Tester();

		// with type declaration
		MathOperation addition = (int a, int b) -> a + b;

		// with out type declaration
		MathOperation substraction = (a, b) -> a - b;

		// with return statement along with curly braces
		MathOperation multiplication = (a, b) -> {
			return a * b;
		};

		// without return statement and without curly braces
		MathOperation division = (a, b) -> a / b;
		
		GreetingService greet = ()->System.out.println("Hello ! world");

		System.out.println("10+5=" + tester.operation(10, 5, addition));
		System.out.println("10-5=" + tester.operation(10, 5, substraction));
		System.out.println("10X5=" + tester.operation(10, 5, multiplication));
		System.out.println("10/5=" + tester.operation(10, 5, division));
		greet.sayMessage();

	}

	private int operation(int a, int b, MathOperation methOperation) {

		return methOperation.operate(a, b);

	}
}
