package com.rahul.practice.basics.arrays;

/**
 * This code will give O(logn) time complexity
 * 
 * @author Rahul
 *
 */
public class FindExtraElementIndexTest3 {

	public static void main(String[] args) {
		int[] arrA = { 2, 4, 6, 8, 10, 12, 13 };
		int[] arrB = { 2, 4, 6, 8, 10, 12 };

		System.out.println(findIndex(arrA, arrB));

	}

	private static int findIndex(int[] arrA, int[] arrB) {
		return binarySearch(arrA, arrB);

	}

	private static int binarySearch(int[] arrA, int[] arrB) {
		int index = 0;
		int low = 0;
		int high = arrA.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			
			if (low == high) {
				index = high;
				break;
			}
			
			if (arrA[mid] == arrB[mid]) {
				low = mid + 1;
			} else {
				index = mid;
				high = mid - 1;
			}

		}
		return index;
	}
}
