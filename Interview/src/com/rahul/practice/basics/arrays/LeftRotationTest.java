package com.rahul.practice.basics.arrays;

public class LeftRotationTest {
	// Function to leftRotate array multiple
	// times
	static void leftRotate(int arr[], int n, int k) {
		/*
		 * To get the starting point of rotated array
		 */
		int mod = k % n;

		//Collections.rotate(Arrays.asList(arr), n - k);
		
		// Prints the rotated array from
		// start position
		for (int i = 0; i < n; ++i)
			System.out.print(arr[(i + mod) % n] + " ");

		System.out.println();
	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7, 9 };
		int n = arr.length;

		int k = 2;

		// Function Call
		leftRotate(arr, n, k);

		k = 3;

		// Function Call
		leftRotate(arr, n, k);

		k = 4;

		// Function Call
		leftRotate(arr, n, k);
	}
}
