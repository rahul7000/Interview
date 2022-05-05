package com.rahul.practice.basics.arrays;

/**
 * This code will give O(n) time complexity
 * 
 * @author Rahul
 *
 */
public class FindExtraElementIndexTest1 {

	public static void main(String[] args) {
		int[] arrA = { 2, 4, 6, 8, 10, 12, 13 };
		int[] arrB = { 2, 4, 6, 8, 10, 12 };

		int lengthA = arrA.length;
		int lengthB = arrB.length;

		if (lengthA > lengthB) {
			System.out.println(findIndex(arrA, arrB, lengthA));
		} else {
			System.out.println(findIndex(arrA, arrB, lengthB));
		}
	}

	private static int findIndex(int[] arrA, int[] arrB, int length) {
		int i;
		for (i = 0; i < length - 1; i++) {
			if (arrA[i] != arrB[i]) {
				return i;
			}
		}
		return i;
	}

}
