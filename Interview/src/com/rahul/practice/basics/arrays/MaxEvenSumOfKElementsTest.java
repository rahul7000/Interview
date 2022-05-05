package com.rahul.practice.basics.arrays;

import java.util.Arrays;

public class MaxEvenSumOfKElementsTest {
	static int solution(int A[], int K) {
		// check if size is smaller then k
		if (K > A.length)
			return -1;

		Arrays.sort(A);

		// size
		int size = A.length;
		int sum = 0;

		// loop
		for (int i = size - 1, j = K; j >= 1; i--, j--) {
			sum += A[i];
		}
		// check even
		if (sum % 2 == 0)
			return sum;

		// check size equal to k
		if (size == K)
			return -1;

		int minOdd = -1, minEven = -1;
		// loop to find mineven and minodd from the last k elements
		for (int i = size - K; i < size; i++) {
			// If current element is an odd number
			if (minOdd == -1 && A[i] % 2 == 1)
				minOdd = A[i];
			if (minEven == -1 && A[i] % 2 == 0)
				minEven = A[i];
			if (minOdd != -1 && minEven != -1)
				break;
		}

		int maxOdd = -1, maxEven = -1;

		// loop to find maxEven and maxOdd from the other elements
		for (int i = size - K - 1; i >= 0; i--) {
			// If current element is an odd number
			if (maxOdd == -1 && A[i] % 2 == 1)
				maxOdd = A[i];
			if (maxEven == -1 && A[i] % 2 == 0)
				maxEven = A[i];
			if (maxOdd != -1 && maxEven != -1)
				break;
		}

		// subtract minEven from last k elements and maxOdd from others
		int diffMaxOddMinEven = -1;
		if (maxOdd != -1 && minEven != -1)
			diffMaxOddMinEven = minEven - maxOdd;

		int diffMaxEvenMinOdd = -1;
		// subtract minOdd from last k elements and maxEven from others
		if (maxEven != -1 && minOdd != -1)
			diffMaxEvenMinOdd = minOdd - maxEven;

		// all same elements
		if (diffMaxOddMinEven == -1 && diffMaxEvenMinOdd == -1)
			return -1;

		if (diffMaxOddMinEven == -1)
			return sum - diffMaxEvenMinOdd;

		if (diffMaxEvenMinOdd == -1)
			return sum - diffMaxOddMinEven;

		return sum - Math.min(diffMaxOddMinEven, diffMaxEvenMinOdd);
	}

	public static void main(String[] args) {
		
		System.out.println(solution(new int[] { 4, 9, 8, 2, 6 }, 3));
		System.out.println(solution(new int[] { 5, 6, 3, 4, 2 }, 5));
		System.out.println(solution(new int[] { 7, 7, 7, 7, 7 }, 1));
		System.out.println(solution(new int[] { 10000 }, 2));
		System.out.println(solution(new int[] { 2, 3, 3, 5, 5 }, 3));
	}
}
