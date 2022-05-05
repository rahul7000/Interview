package com.rahul.practice.basics.sorting;

/**
 * Quicksort is the preferred algorithm, as it has an O(log(n)) space
 * complexity. Mergesort, on the other hand, requires O(n) extra storage
 * 
 * @author rahul
 *
 */

class QuickSort {

	public static void quickSort(int[] actual, int begin, int end) {

		if (begin < end) {
			int partitionIndex = partition(actual, begin, end);
			quickSort(actual, begin, partitionIndex - 1);
			quickSort(actual, partitionIndex + 1, end);
		}

	}

	private static int partition(int[] actual, int begin, int end) {
		int pivot = actual[end];
		int i = (begin - 1);

		for (int j = begin; j < end; j++) {
			if (actual[j] <= pivot) {
				i++;

				int swapTemp = actual[i];
				actual[i] = actual[j];
				actual[j] = swapTemp;
			}
		}

		int swapTemp = actual[i + 1];
		actual[i + 1] = actual[end];
		actual[end] = swapTemp;

		return i + 1;
	}

}

public class QuickSortTest {
	public static void main(String[] args) {
		int[] actual = { 5, 1, 6, 2, 3, 4 };

		QuickSort.quickSort(actual, 0, actual.length-1);
		
		for (int i = 0; i < actual.length; i++) {
			System.out.print(actual[i]);
		}

	}
}
