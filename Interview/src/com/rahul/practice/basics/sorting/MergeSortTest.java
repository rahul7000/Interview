package com.rahul.practice.basics.sorting;

/**
 * Merge sort with O(nlogn)
 * 
 * @author rahul
 *
 */
class MergeSort {

	public static void mergeSort(int[] actual, int length) {
		if (length < 2) {
			return;
		}
		int mid = length / 2;
		int[] leftArray = new int[mid];
		int[] rightArray = new int[length - mid];

		for (int i = 0; i < mid; i++) {
			leftArray[i] = actual[i];
		}
		for (int i = mid; i < length; i++) {
			rightArray[i - mid] = actual[i];
		}
		mergeSort(leftArray, mid);
		mergeSort(rightArray, length - mid);

		merge(actual, leftArray, rightArray, mid, length - mid);

	}

	private static void merge(int[] actual, int[] leftArray, int[] rightArray, int leftLength, int rightLength) {
		int i = 0, j = 0, k = 0;

		while (i < leftLength && j < rightLength) {
			if (leftArray[i] <= rightArray[j]) {
				actual[k++] = leftArray[i++];
			} else {
				actual[k++] = rightArray[j++];
			}
		}

		while (i < leftLength) {
			actual[k++] = leftArray[i++];
		}
		while (j < rightLength) {
			actual[k++] = rightArray[j++];
		}

	}

}

public class MergeSortTest {
	public static void main(String[] args) {
		int[] actual = { 5, 1, 6, 2, 3, 4 };

		MergeSort.mergeSort(actual, actual.length);

		for (int i = 0; i < actual.length; i++) {
			System.out.print(actual[i]);
		}
	}

}
