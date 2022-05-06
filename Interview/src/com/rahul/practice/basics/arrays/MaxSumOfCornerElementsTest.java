package com.rahul.practice.basics.arrays;

public class MaxSumOfCornerElementsTest {

	public static void main(String[] args) {

		System.out.println(solution(new int[] { 4, 9, 8, 2, 6 }, 3));
		System.out.println(solution(new int[] { 5, 6, 3, 4, 2 }, 5));
		System.out.println(solution(new int[] { 7, 7, 7, 7, 7 }, 1));
		System.out.println(solution(new int[] { 10000 }, 2));
		System.out.println(solution(new int[] { 2, 3, 3, 5, 5 }, 3));
	}

	private static int solution(int[] arr, int k) {
		int size = arr.length;
		int curSum = 0;
		int maxSum = 0;
		if (k > arr.length) {
			return -1;
		}

		for (int i = 0; i < k; i++) {
			curSum += arr[i];
		}

		maxSum = curSum;

		for (int i = k - 1, j = size - 1; i >= 0; i--, j--) {
			curSum = curSum + arr[j] - arr[i];
			maxSum = Math.max(maxSum, curSum);
		}

		return maxSum;
	}
}
