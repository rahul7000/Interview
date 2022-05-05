package com.rahul.practice.basics.arrays;

/*
First Iteration of array:
index = 0
Math.abs(arr[0]) = 2
arr[2] = 5, Set its value to -5

Second Iteration of array:
index = 1
Math.abs(arr[1]) = 1
arr[1] = 1, Set its value to -1

Third Iteration of array:
index = 2
Math.abs(arr[2]) = 5
arr[5] = 3, Set its value to -3

Fourth iteration
....

Fifth Iteration of array: 
index = 4
Math.abs(arr[4]) = 2
arr[2] = -5 , Its value is negative, so 2 is duplicate value.
 */
class DuplicateElement {

	public void isDuplicate(int[] array) {
		for (int index = 0; index < array.length - 1; index++) {
			int absValue = Math.abs(array[index]);

			// visit second time
			if (array[absValue] < 0) {
				System.out.println("Duplicate found " + absValue + " at index " + index);
				return;
			}

			// visit first time
			else {
				array[absValue] = -array[absValue];
			}
		}

		System.out.println("No Duplicate found ");
		return;
	}
}

public class DuplicateElementTest {

	public static void main(String[] args) {
		DuplicateElement obj = new DuplicateElement();
		int[] array = { 2, 1, 5, 4, 2, 3, 1 };
		obj.isDuplicate(array);

		array = new int[] { 2, 1, 3, 0 };
		obj.isDuplicate(array);
	}
}
