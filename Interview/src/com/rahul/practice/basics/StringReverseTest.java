package com.rahul.practice.basics;

/*
 * Using for loop
 * Using recursion
 * Using StringBuffer
*/

class StringReverse {

	public static String reverseUsingLoop(String str) {
		String reverse = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}

		System.out.println("reverseString using loop: " + reverse);
		return reverse;
	}

	public static String reverseUsingRecursion(String str) {
		if (str.isEmpty()) {
			return str;
		}
		return reverseUsingRecursion(str.substring(1)) + str.charAt(0);

	}
}

public class StringReverseTest {
	public static void main(String[] args) {

		StringReverse.reverseUsingLoop("Rahul");
		System.out.println("reverseString using recursion: " + StringReverse.reverseUsingRecursion("Rahul"));
	}
}
