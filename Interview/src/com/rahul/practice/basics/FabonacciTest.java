package com.rahul.practice.basics;

/*
@description	:	class to test fabonacci series in recursion method
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
public class FabonacciTest {
	public static void main(String args[]) {
		int num = 10;
		for (int i = 0; i < num; i++) {
			System.out.print(fibonacci(i)+" ");
		}

	}

	public static int fibonacci(int number) {
		if (number < 2) {
			return number;
		} else {
			return fibonacci(number - 1) + fibonacci(number - 2);
		}
	}
}
