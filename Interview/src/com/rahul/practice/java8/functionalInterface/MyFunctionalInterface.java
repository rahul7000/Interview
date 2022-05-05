package com.rahul.practice.java8.functionalInterface;

@FunctionalInterface
public interface MyFunctionalInterface {

	public abstract int sum(int a, int b);

	public default int sum(int a, int b, int c) {
		return a + b + c;
	}
}
