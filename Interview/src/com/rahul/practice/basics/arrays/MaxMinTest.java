package com.rahul.practice.basics.arrays;

import java.util.Arrays;

class MaxMin {

	public void printMinMax(int[] arr) {
		int min = arr[0];
		int max = arr[0];

		for (int index = 0; index < arr.length; index++) {
			if (min > arr[index]) {
				min = arr[index];
			}

			if (max < arr[index]) {
				max = arr[index];
			}
		}
		System.out.println("Min : " + min + " Max : " + max);

	}

}

public class MaxMinTest {
	public static void main(String[] args) {

		MaxMin obj = new MaxMin();
		int arr[] = { 5, 10, 40, 35, 20 };
		String sArray = Arrays.toString(arr);
		System.out.printf("1. Minimum & Maximum value in array %s\n", sArray);
		obj.printMinMax(arr);

		arr = new int[] { 50, 20, 63, 15, 50, 25 };
		sArray = Arrays.toString(arr);
		System.out.printf("2. Minimum & Maximum value in array %s\n", sArray);
		obj.printMinMax(arr);

	}
}
