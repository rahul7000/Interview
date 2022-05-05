package com.rahul.practice.java8.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;

public class Java8Tester {

	public static void main(String... strings) {
		MyFunctionalInterface myFunctionalInterface = (a, b) -> a + b;
		System.out.println("sum() from myFunctionalInterface : " + myFunctionalInterface.sum(10, 20));

		IntBinaryOperator intBinaryOperator = (aa, bb) -> aa + bb;
		System.out.println("applyAsInt() from intBinaryOperator : " + intBinaryOperator.applyAsInt(10, 20));

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		// test method will always return true no matter what value n has.
		Predicate<Integer> pred1 = n -> true;
		System.out.println("Print all no.s :");
		eval(list, pred1);

		// test method will return true if n%2 comes to be zero
		Predicate<Integer> pred2 = n -> n % 2 == 0;
		System.out.println("Print all even no.s :");
		eval(list, pred2);

		// test method will return true if n>3
		Predicate<Integer> pred3 = n -> n > 3;
		System.out.println("Print all no.s greater than 3 :");
		eval(list, pred3);

	}

	private static void eval(List<Integer> list, Predicate<Integer> pred) {
		for(Integer m : list) {
			if(pred.test(m)) {
				System.out.println(m);
			}
		}
	}
}
