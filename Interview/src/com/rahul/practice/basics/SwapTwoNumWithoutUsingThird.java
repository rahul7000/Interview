package com.rahul.practice.basics;

/*
@description	:	class to swap two numbers without using third variable
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
public class SwapTwoNumWithoutUsingThird {

	public static void main(String args[]) {
		int num1 = 5;
		int num2 = 10;

		System.out.println("Before swapping, num1:" + num1 + " num2:" + num2);

		num1 = num1 + num2;// 15
		num2 = num1 - num2;// 10
		num1 = num1 - num2;// 5

		System.out.println("After swapping, num1:" + num1 + " num2:" + num2);

	}

}
