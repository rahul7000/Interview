package com.rahul.practice.basics.arrays;

class MissingNumber {
	public int missingNumberUsingSum(int[] arrOfIntegers) {
		int length = arrOfIntegers.length + 1;
		int sumOfElements = 0;
		int sumFormula = 0;

		// n(n+1)/2
		sumFormula = (length * (length + 1)) / 2;
		for (int counter = 0; counter < arrOfIntegers.length; counter++) {
			sumOfElements += arrOfIntegers[counter];
		}
		return sumFormula - sumOfElements;

	}
}

public class MissingNumberTest {
	public static void main(String... strings) {
		int[] arrOfIntegers = { 1, 2, 3, 5 };
		MissingNumber obj =new MissingNumber();
		System.out.println(obj.missingNumberUsingSum(arrOfIntegers));
	}
}
