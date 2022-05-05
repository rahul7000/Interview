package com.rahul.practice.basics;

/*
@description	:	class to test a num is prime or not
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
public class PrimeTest {
	public static void main(String... strings) {
		int num = 71;
		System.out.println("IsPrime:" + checkForPrime(num));

	}

	private static boolean checkForPrime(int num) {
		boolean flag = true;
		for (int i = 2; i < num / 2; i++) {
			if (num % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
