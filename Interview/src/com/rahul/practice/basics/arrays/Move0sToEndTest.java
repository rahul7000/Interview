package com.rahul.practice.basics.arrays;

import java.util.Arrays;

/*
First Iteration of array:
index = 0
arr[0] = 0
nonZeros = 0

Second Iteration of array:
index = 1
arr[2] = 2
nonZeros=0
arr[nonZeros] = arr[index], [2,.....]
nonZeros=1

Third Iteration of array:
index = 2
arr[2] = 0
nonZeros = 1

Fourth iteration
index = 3
arr[3] = 5
nonZeros=1
arr[nonZeros] = arr[index], [2,5,...]
nonZeros=2

Fifth Iteration of array: 
index = 4
arr[4] = 2
nonZeros=2
arr[nonZeros] = arr[index], [2,5,2,...]
nonZeros=3

and so on and after this add zeros in array using nonZeros<length
 */
class Move0sToEnd {

	public void moveZeroToEnd(int[] arr) {
		int nonZeros = 0;
		for (int index = 0; index < arr.length; index++) {
			if (arr[index] != 0) {
				arr[nonZeros] = arr[index];
				nonZeros++;
			}
		}
		while (nonZeros < arr.length) {
			arr[nonZeros] = 0;
			nonZeros++;
		}
		System.out.println(Arrays.toString(arr));

	}

}

public class Move0sToEndTest {

	public static void main(String[] args) {

		Move0sToEnd obj = new Move0sToEnd();
		int arr[] = { 0, 2, 0, 5, 2, 0, 3, 1 };
		String sArray = Arrays.toString(arr);
		System.out.printf("1. Move zeros of array %s to end :", sArray);
		obj.moveZeroToEnd(arr);

		arr = new int[] { 1, 0, 2, 3, 0, 4, 0 };
		sArray = Arrays.toString(arr);
		System.out.printf("\n2. Move zeros of array %s to end :", sArray);
		obj.moveZeroToEnd(arr);
	}
}
