package com.rahul.practice.basics.arrays;

/**
 * Let p be the position of element to be searched. Number of steps for finding
 * high index ‘h’ is O(Log p). The value of ‘h’ must be less than 2*p. The
 * number of elements between h/2 and h must be O(p). Therefore, time complexity
 * of Binary Search step is also O(Log p) and overall time complexity is 2*O(Log
 * p) which is O(Log p).
 * 
 * @author Rahul
 *
 */
public class FindPositionInInfiniteSizedArrayTest {

	public static void main(String[] args) {
		int arr[] = new int[] { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		int ans = findPos(arr, 10);

		if (ans == -1)
			System.out.println("Element not found");
		else
			System.out.println("Element found at index " + ans);
	}

	private static int findPos(int[] arr, int element) {

		int low = 0;
		int high = 1;
		int val = arr[low];

		while (val < element) {
			low = high;
			// check that 2*h doesn't exceeds array
			if (2 * high < arr.length) {
				high = 2 * high;
			} else {
				high = arr.length;
			}

			val = arr[low];
		}
		return binarySearch(arr, low, high, element);
	}

	// Simple binary search algorithm using recursion
	private static int binarySearch(int[] arr, int low, int high, int element) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == element)
				return mid;
			if (arr[mid] > element)
				return binarySearch(arr, low, mid - 1, element);
			return binarySearch(arr, mid + 1, high, element);
		}
		return -1;
	}
}
