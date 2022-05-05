package com.rahul.practice.basics.arrays;

class NumberOddTimes {

	/*
	 * Let us apply XOR gate on example1 = { 1, 1, 2, 2, 3, 4, 4 } 
	 * OddNumber = 1 ^ 1 ^ 2 ^ 2 ^ 3 ^ 4 ^ 4 
	 * OddNumber = (1 ^ 1) ^ (2 ^ 2) ^ 3 ^ (4 ^ 4) 
	 * OddNumber = 0 ^ 0 ^ 3 ^ 0
	 * OddNumber = 3
	 */
	public void oddTimes(int[] arr) {
		int oddElement = arr[0];
		for (int counter = 1; counter < arr.length; counter++) {
			oddElement = oddElement ^ arr[counter];
		}
		System.out.println("Odd Element is:" + oddElement);
	}
}

public class NumberOddTimesTest {
	public static void main(String... strings) {
		NumberOddTimes obj = new NumberOddTimes();
		int[] integerArray = { 1, 1, 2, 2, 3, 3, 4, 4 };
		obj.oddTimes(integerArray);
	}
}
