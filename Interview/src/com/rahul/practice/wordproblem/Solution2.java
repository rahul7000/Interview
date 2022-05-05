package com.rahul.practice.wordproblem;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution2 {
	public static void main(String[] args) throws IOException {

		List<Integer> candles = Arrays.asList(4, 4, 1, 3);

		System.out.println(birthdayCakeCandles(candles));

	}
	/*
	 * Complete the 'birthdayCakeCandles' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * INTEGER_ARRAY candles as parameter.
	 */

	public static int birthdayCakeCandles(List<Integer> candles) {
		// Write your code here
		TreeMap<Integer, Integer> treeMap = new TreeMap<>();
		for (Integer tempNum : candles) {
			Integer prevValue = treeMap.get(tempNum);
			Integer newValue = (prevValue == null) ? 1 : prevValue + 1;
			treeMap.put(tempNum, newValue);
		}

		return treeMap.get(treeMap.lastEntry().getKey());

	}
}
