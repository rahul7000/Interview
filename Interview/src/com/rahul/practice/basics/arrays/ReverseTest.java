package com.rahul.practice.basics.arrays;

import java.util.Arrays;

/*
Initialize length = inputArray.length & half = length / 2.
Start traversing the input array till half length of array
Swap elements of array e.g. first element of array swapped with last element.

Initialize low = 0 & high = inputArray.length – 1
Swap elements at low & high index
Increment low & decrement high index
Recursively call reverse method to reverse rest of elements of array.
 */
class Reverse {

	public void reverseArrayIterative(int[] arr) {

		int low = 0, high = arr.length - 1, temp = 0;

		for (int index = 0; index < arr.length / 2; index++) {
			temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}

	}

	public void reverseArrayRecursive(int[] arr, int low, int high) {

		if (high < low)
			return;

		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
		reverseArrayRecursive(arr, low + 1, high - 1);
	}

}

public class ReverseTest {

	public static void main(String[] args) {
		Reverse obj = new Reverse();
		int[] inputArray = { 1, 2, 3, 4, 5 };
		System.out.println("1. Input Array is :" + Arrays.toString(inputArray));

		int[] copy = inputArray.clone();
		obj.reverseArrayIterative(copy);
		String reverseArray = Arrays.toString(copy);
		System.out.println("2. Iterative method - reverse array :" + reverseArray);

		copy = inputArray.clone();
		obj.reverseArrayRecursive(copy, 0, copy.length - 1);
		reverseArray = Arrays.toString(copy);
		System.out.println("3. Recursive method - reverse array :" + reverseArray);

	}
}
