package com.rahul.practice.basics.arrays;

import java.util.HashSet;
import java.util.Set;

public class MaxConsecutiveNumInArrayTest2 {

	public static void main(String... strings) {

		int arr[] = { 1, 5, 92, 4, 93, 94, 95, 96, 97, 6, 7 };
		System.out.println(maxConsecutive(arr));
	}

	private static int maxConsecutive(int[] arr) {

		int ans = 0;
		Set<Integer> set = new HashSet<>();

		// insert all the array elements to get searching best case complexity as O(1)
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			int j = arr[i];
			
			//repeat search in the set with +1 value
			while (set.contains(j)) {
				j++;
			}
			
			// remove arr[i] from consecutive numbers 
			ans = Math.max(ans, j - arr[i]);

		}
		return ans;

	}
}
