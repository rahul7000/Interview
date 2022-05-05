package com.rahul.practice.basics.arrays;

import java.util.Arrays;

/*
Traverse the array from right to left.
Replace last element by -1.
Initialize maxElement with last element of array.
Traverse input array from right to left
Take the backup of current element.
Replace current element by maxElement
If current element greater than maxElement
update the maxElement by current element
end of array traversal
 */
class ReplaceByRightGreatest {

	public void replaceElements(int[] arr) {
		int length = arr.length - 1;
		int maxElement = arr[length];
		int curElement = 0;
		arr[length--] = -1;

		while (length >= 0) {
			curElement = arr[length];
			arr[length] = maxElement;

			if (curElement > maxElement) {
				maxElement = curElement;
			}

			length--;
		}
		System.out.println("\nOutput array : " + Arrays.toString(arr));
	}

}

public class ReplaceByRightGreatestTest {
	public static void main(String[] args) {
		ReplaceByRightGreatest obj = new ReplaceByRightGreatest();
		int[] arr = { 4, 10, 7, 5 };

		System.out.printf("1. Input array : %s ", Arrays.toString(arr));
		obj.replaceElements(arr);

		arr = new int[] { 10, 12, 20, 15, 17, 8 };
		System.out.printf("\n\n2. Input array : %s ", Arrays.toString(arr));
		obj.replaceElements(arr);
	}
}
