package com.rahul.practice.basics.arrays;

import java.util.Arrays;

/*
Take two indexes low and high.
low will points to lowest position of an array (index = 0)
high will points to highest position of an array (index = array’s length – 1)
Start incrementing low index till we find element value = 1
Stops incrementing as soon as we found 1
Start decrementing the high index till we find element value = 0
Stops decrementing as soon as we found 0
Now swap the values pointed by low and high index ( 1 and 0)
After swapping, 0 will come in left side of array and 1 will be come in right side of array
 */
class Segregate0sAnd1s {

	public void sortArray(int[] arr) {
		int low = 0, high = arr.length - 1;
		while (low < high) {
			
			//decrement till we find 1
			while (arr[low] == 0 && low < high) {
				low++;
			}
			
			//decrement till we find 0
			while (arr[high] == 1 && low < high) {
				high--;
			}

			//Swap or simply put 0 or 1
			if (low < high) {
				int temp = arr[high];
				arr[high] = arr[low];
				arr[low] = temp;
			}
		}

	}

}

public class Segregate0sAnd1sTest {
	public static void main(String[] args) {
		Segregate0sAnd1s obj = new Segregate0sAnd1s();
		int[] arr = { 0, 1, 0, 1, 0, 1, 0 };

		obj.sortArray(arr);
		System.out.println("Sorted array is:" + Arrays.toString(arr));

	}
}
