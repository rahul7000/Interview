package com.rahul.practice.basics;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Best loops is the old school loop for sysouts but if there will be any
 * operation performed with in the loop then stream will give best performance
 * 
 * @author Rahul
 *
 */
public class LoopTest {

	private static List<Integer> list = new ArrayList<>();
	private static long startTime;
	private static long endTime;
	static {
		for (int i = 0; i < 1100; i++) {
			list.add(i);
		}
	}

	public static void main(String[] args) {
		// Type 1
		startTime = Calendar.getInstance().getTimeInMillis();
		for (Integer i : list) {
			System.out.print(i);
		}
		endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("\n### 1) For each loop ::" + (endTime - startTime) + " ms");

		// Type 2
		startTime = Calendar.getInstance().getTimeInMillis();
		for (int j = 0; j < list.size(); j++) {
			System.out.print(j);
		}
		endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("\n### 2) Using collection.size() :: " + (endTime - startTime) + " ms");

		// Type 3
		startTime = Calendar.getInstance().getTimeInMillis();
		int size = list.size();
		for (int j = 0; j < size; j++) {
			System.out.print(j);
		}
		endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("\n### 3) Using [int size = list.size(); int j = 0; j < size ; j++] :: "
				+ (endTime - startTime) + " ms");

		// Type 4
		startTime = Calendar.getInstance().getTimeInMillis();

		list.stream().forEach(System.out::print);
		endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("\n### 4) Using stream :: " + (endTime - startTime) + " ms");

		// Type 5
		startTime = Calendar.getInstance().getTimeInMillis();

		list.forEach(System.out::print);
		endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("\n### 5) Using Collection.forEach :: " + (endTime - startTime) + " ms");

		// Type 5
		startTime = Calendar.getInstance().getTimeInMillis();

		list.parallelStream().forEach(System.out::print);
		endTime = Calendar.getInstance().getTimeInMillis();
		System.out.println("\n### 6) Using Collection.parallelStreamforEach :: " + (endTime - startTime) + " ms");
	}

}