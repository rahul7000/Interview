package com.rahul.practice.basics.arrays;

import java.util.Arrays;

/*
Maintain three indexes low = 0, mid = 0 and high = array length – 1 low, mid and high represents 0s, 1s and 2s respectively.
Start iterating from mid to high
If found 0 at mid index then swap it with low
If found 1 at mid index (It is at it’s right place) then its fine let us increment it.
If found 2 at mid index, swap it with high.
 */
class SortArrayWithZerosOnesTwos {

	public void segregateArray(int[] arr) {

		int low = 0, mid = 0, high = arr.length - 1;

		while (mid <= high) {
			if (arr[mid] == 0) {
				swap(arr, mid, low);
				mid++;
				low++;
			} else if (arr[mid] == 1) {
				mid++;
			} else if (arr[mid] == 2) {
				swap(arr, mid, high);
				high--;
			}
		}

	}

	private void swap(int[] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}
}

/*
 * Dutch national flag contains three colors red, white and blue. Given the
 * Balls of three colors, Our job is to arrange these balls So that balls having
 * same color are lying together.
 */
public class DutchNationalFlagProblemTest {

	public static void main(String... strings) {
		SortArrayWithZerosOnesTwos obj = new SortArrayWithZerosOnesTwos();
		int[] example1 = { 0, 1, 2, 1, 2, 1, 0 };
		obj.segregateArray(example1);
		System.out.println("Example 1 segregated array is : " + Arrays.toString(example1));

		int[] example2 = { 2, 1, 2, 0, 0, 2, 1 };
		obj.segregateArray(example2);
		System.out.println("Example 2 segregated array is : " + Arrays.toString(example2));
	}

}
