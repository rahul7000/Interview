package com.rahul.practice.basics.arrays;

import java.util.Arrays;

public class MaxConsecutiveNumInArrayTest1 {

	public static void main(String... strings) {

		int arr[] = { 1, 5, 92, 4, 93,94,95,96,97, 6, 7 };
		System.out.println(maxConsecutive(arr));
	}

	private static int maxConsecutive(int[] arr) {

		Arrays.sort(arr);
		int maxCons = 1;
		int curCons = 1;

		for (int i = 0; i < arr.length; i++) {
			if ((i == arr.length - 1)) {
				if (arr[i] == arr[i - 1] + 1) {
					curCons += 1;
				}
			} else if (arr[i + 1] == arr[i] + 1) {
				curCons += 1;
			}else {
				curCons=0;
			}
			if (maxCons < curCons) {
				maxCons = curCons;
			}

		}

		return maxCons;
	}

}
