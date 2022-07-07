package com.rahul.practice.basics.arrays;

import java.util.Vector;

public class SubarrayMaxSumTest {
	public static void main(String[] args) {
		Vector<Integer> arr = new Vector<Integer>();
		arr.add(-2);
		arr.add(-5);
		arr.add(6);
		arr.add(-2);
		arr.add(-3);
		arr.add(1);
		arr.add(5);
		arr.add(-6);
		// Function call
		SubarrayWithMaxSum(arr);
	}

	private static void SubarrayWithMaxSum(Vector<Integer> nums) {
		int currMax = nums.get(0), globalMax = nums.get(0);
		int endIndex = 0, startIndex = 0, globalMaxStartIndex = 0;

		for (int i = 1; i < nums.size(); ++i) {
			// Update currMax and startIndex
			if (nums.get(i) > nums.get(i) + currMax) {
				currMax = nums.get(i);
				startIndex = i;
			}

			// Update currMax
			else if (nums.get(i) < nums.get(i) + currMax) {
				currMax = nums.get(i) + currMax;
			}

			// Update globalMax and globalMaxStartIndex
			if (currMax > globalMax) {
				globalMax = currMax;
				endIndex = i;
				globalMaxStartIndex = startIndex;
			}
		}

		// Printing the elements of subarray with max sum
		for (int i = globalMaxStartIndex; i <= endIndex; ++i) {
			System.out.print(nums.get(i) + " ");
		}

	}

}
