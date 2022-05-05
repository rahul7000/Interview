package com.rahul.practice.basics.arrays;

import java.util.Arrays;

/*
Take two indexes low and high.
low index points lowest position of array (low = 0).
high index points to highest position of array (high = array’s length – 1).
Increments low index till, we find odd number.
Stop, when we found out odd number.
Decrements high index till, we find even number.
Stop, when we found out even number.
Now swap the values pointed by low and high index (odd number and even number).
After swapping, even number will come in left side of array and odd number will be come in right side of array
 */
class SegregateEvenOdd {

	public void segregateArray(int[] arr) {
		int low = 0, high = arr.length - 1;
		while (low < high) {
			while ((arr[low] % 2 == 0) && low < high) {
				low++;
			}
			while ((arr[high] % 2 != 0) && low < high) {
				high--;
			}

			// got odd from starting and even from end now swap them
			if (low < high) {
				arr[high] = arr[high] + arr[low];
				arr[low] = arr[high] - arr[low];
				arr[high] = arr[high] - arr[low];
			}
		}

	}

}

public class SegregateEvenOddTest {
	public static void main(String... strings) {

		SegregateEvenOdd obj = new SegregateEvenOdd();
		int[] arr = { 10, 11, 20, 31, 50, 61, 90 };

		obj.segregateArray(arr);
		System.out.println("Segregated array is : " + Arrays.toString(arr));
	}
}
