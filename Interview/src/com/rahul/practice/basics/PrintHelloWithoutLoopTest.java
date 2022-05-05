package com.rahul.practice.basics;

public class PrintHelloWithoutLoopTest {
	public static void main(String[] args) {
		int num = 10;
		printHello(num);
	}

	private static void printHello(int num) {
		if(num ==0) {
			return;
		}else {
			System.out.println("Hello");
		}
		printHello(num-1);
		
	}

}
