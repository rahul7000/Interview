package com.rahul.practice.java8.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Java8Tester {

	public static void main(String... strings) {

		System.out.println("Count empty strings");
		List<String> strList = Arrays.asList("abc", "", "efg", "", "jkl");
		System.out.println("List : " + strList);

		Integer count7 = getEmptyStringCountUsingJava7(strList);
		Integer count8 = getEmptyStringCountUsingJava8(strList);
		System.out.println("Using java 7 : " + count7 + " Using java 8 : " + count8);

		System.out.println("Count strings with length 3");
		count7 = getLength3StringUsingJava7(strList);
		count8 = getLength3StringUsingJava8(strList);
		System.out.println("Using java 7 : " + count7 + " Using java 8 : " + count8);

		System.out.println("Eliminate empty strings");
		List<String> strList7 = getNonEmptyStringUsingJava7(strList);
		List<String> strList8 = getNonEmptystringUsingJava8(strList);
		System.out.println("Using java 7 : " + strList7 + " Using java 8 : " + strList8);

		System.out.println("Eliminate empty string and join using comma");
		String mergedString7 = getMergedStringUsingJava7(strList, ", ");
		String mergedString8 = getMergedStringUsingJava8(strList, ", ");
		System.out.println("Using java 7 : " + mergedString7 + " Using java 8 : " + mergedString8);

		System.out.println("Get list of square of distinct numbers");
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		System.out.println("List of numbers : " + numbers);
		List<Integer> squaresList7 = getSquaresUsingJava7(numbers);
		List<Integer> squaresList8 = getSquaresUsingJava8(numbers);
		System.out.println("Using java 7 : " + squaresList7 + " Using java 8 : " + squaresList8);

		System.out.println("Get stats of numbers");
		getStatsUsingJava7(numbers);
		getStatsUsingJava8(numbers);

		System.out.println("Print 10 distinct random numbers");
		printRandomNumbersUsingJava7();
		printRandomNumbersUsingJava8();
	}

	private static void printRandomNumbersUsingJava8() {
		System.out.println("Using java 8 : ");

		Random random = new Random();
		random.ints(10).forEach(System.out::println);
	}

	private static void printRandomNumbersUsingJava7() {
		System.out.println("Using java 7 : ");

		Random random = new Random(10);
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt());
		}
	}

	private static void getStatsUsingJava8(List<Integer> numbers) {
		System.out.println("Using java 8 : ");

		IntSummaryStatistics stats = numbers.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
	}

	private static void getStatsUsingJava7(List<Integer> numbers) {
		System.out.println("Using java 7 : ");

		Integer minNumber = Integer.MIN_VALUE;
		Integer maxNumber = Integer.MAX_VALUE;
		Integer sum = new Integer(0);
		for (Integer number : numbers) {
			if (minNumber < number) {
				minNumber = number;
			}
			if (maxNumber > number) {
				maxNumber = number;
			}

			sum += number;
		}

		System.out.println("Highest number in List : " + minNumber);
		System.out.println("Lowest number in List : " + maxNumber);
		System.out.println("Sum of all numbers : " + sum);
		System.out.println("Average of all numbers : " + (double) sum / numbers.size());
	}

	private static List<Integer> getSquaresUsingJava8(List<Integer> numbers) {
		return numbers.stream().map(number -> number * number).distinct().collect(Collectors.toList());
	}

	private static List<Integer> getSquaresUsingJava7(List<Integer> numbers) {
		List<Integer> squares = new LinkedList<>();
		for (Integer number : numbers) {
			if (!squares.contains(number * number)) {
				squares.add(number * number);
			}
		}
		return squares;
	}

	private static String getMergedStringUsingJava8(List<String> strList, String separator) {
		return strList.stream().filter(str -> !str.isEmpty()).collect(Collectors.joining(separator));
	}

	private static String getMergedStringUsingJava7(List<String> strList, String separator) {
		StringBuilder mergedString = new StringBuilder();
		Iterator<String> itr = strList.listIterator();
		while (itr.hasNext()) {
			String str = (String) itr.next();
			if (!str.isEmpty()) {
				mergedString.append(str);
				if (itr.hasNext()) {
					mergedString.append(separator);
				}
			}
		}
		return mergedString.toString();
	}

	private static List<String> getNonEmptystringUsingJava8(List<String> strList) {
		return strList.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList());
	}

	private static List<String> getNonEmptyStringUsingJava7(List<String> strList) {
		List<String> nonEmptyStrings = new LinkedList<>();
		for (String str : strList) {
			if (!str.isEmpty()) {
				nonEmptyStrings.add(str);
			}
		}
		return nonEmptyStrings;
	}

	private static Integer getLength3StringUsingJava8(List<String> strList) {
		return (int) strList.stream().filter(str -> str.length() == 3).count();
	}

	private static Integer getLength3StringUsingJava7(List<String> strList) {
		Integer count = new Integer(0);
		for (String str : strList) {
			if (str.length() == 3) {
				count++;
			}
		}
		return count;
	}

	private static Integer getEmptyStringCountUsingJava8(List<String> strList) {
		return (int) strList.stream().filter(str -> str.isEmpty()).count();
	}

	private static Integer getEmptyStringCountUsingJava7(List<String> strList) {
		Integer count = new Integer(0);
		for (String str : strList) {
			if (str.isEmpty()) {
				count++;
			}
		}
		return count;
	}
}
