package com.rahul.practice.basics;

/*
@description	:	class to test a string is palindrome or not
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
public class PalindromTest {

	public static void main(String... strings) {
		String str = "namman";
		System.out.println("IsPalindrome:" + checkForPalindrome(str));
	}

	private static boolean checkForPalindrome(String str) {
		String revStr = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			revStr = revStr + str.charAt(i);
		}

		if (revStr.equalsIgnoreCase(str)) {
			return true;
		}
		return false;
	}

}
