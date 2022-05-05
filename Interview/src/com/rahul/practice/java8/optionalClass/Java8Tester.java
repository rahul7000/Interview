package com.rahul.practice.java8.optionalClass;

import java.util.Optional;

public class Java8Tester {

	public static void main(String... strings) {

		Java8Tester tester = new Java8Tester();
		Integer value1 = null;
		Integer value2 = new Integer(10);

		// Optional.ofNullable - allows passed parameter to be null.
		Optional<Integer> a = Optional.ofNullable(value1);

		// Optional.of - throws NullPointerException if passed parameter is null
		Optional<Integer> b = Optional.of(value2);

		System.out.println(tester.sum(a, b));
	}

	private Integer sum(Optional<Integer> a, Optional<Integer> b) {

		// Optional.isPresent - checks the value is present or not
		System.out.println("First Optional Object Present : " + a.isPresent());
		System.out.println("Second Optional Object Present : " + b.isPresent());

		// Optional.orElse - returns the value if present otherwise returnsthe default
		// value passed.
		Integer value1 = a.orElse(new Integer(10));

		// Optional.get - gets the value, value should be present
		Integer value2 = b.get();

		return value1 + value2;
	}
}
