package com.rahul.practice.basics.arrays;

public class RemoveDuplicateElementsTest {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5 };
		int size = removeDuplicate(arr);
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + "");
		}
	}

	private static int removeDuplicate(int[] arr) {
		int n = arr.length;
		if (n == 0 || n == 1)
			return n;
		int j = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				arr[j++] = arr[i];
			}
		}
		arr[j++] = arr[n - 1];

		return j;
	}

}
