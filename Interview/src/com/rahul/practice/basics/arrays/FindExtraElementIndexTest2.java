package com.rahul.practice.basics.arrays;

/**
 * This code will give O(n) time complexity
 * 
 * @author Rahul
 *
 */
public class FindExtraElementIndexTest2 {

	public static void main(String[] args) {
		int[] arrA = { 2, 4, 6, 8, 10, 12, 13 };
		int[] arrB = { 2, 4, 6, 8, 10, 12 };

		System.out.println(findIndex(arrA, arrB));

	}

	private static int findIndex(int[] arrA, int[] arrB) {
		int extraElement;
		if (arrA.length > arrB.length) {
			extraElement = sumOfElements(arrA) - sumOfElements(arrB);
		} else {
			extraElement = sumOfElements(arrB) - sumOfElements(arrA);
		}

		if (arrA.length > arrB.length) {
			return indexOf(extraElement, arrA);
		} else {
			return indexOf(extraElement, arrB);
		}

	}

	private static int indexOf(int extraElement, int[] arr) {
		int i;
		for (i = 0; i < arr.length; i++) {
			if (arr[i] == extraElement) {
				return i;
			}
		}
		return i;
	}

	private static int sumOfElements(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			count += arr[i];
		}
		return count;
	}
}
