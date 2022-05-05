package com.rahul.practice.basics.arrays;

import java.util.HashSet;
import java.util.Set;

public class PrintDuplicateElementsTest {

	public static void main(String args[]) {
		int arr[] = { 1, 6, 3, 1, 3, 6 };
		int arr_size = arr.length;

		// Function call
		 printRepeating(arr, arr_size);
		//printRepeat(arr);
	}

	private static void printRepeat(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (set.add(arr[i]) == false) {
				System.out.println(arr[i]);
			}
		}
	}

	private static void printRepeating(int[] arr, int n) {
		// First check all the values that are present in an array then go to that
		// values as indexes and increment by the size of array
		for (int i = 0; i < n; i++) {
			int index = arr[i] % n;
			arr[index] += n;
		}

		// Now check which value exists more than once by dividing with the size of
		// array
		for (int i = 0; i < n; i++) {
			if ((arr[i] / n) >= 2)
				System.out.println(i + " ");
		}
	}
}
