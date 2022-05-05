package com.rahul.practice.multithreading;

/*
@description	:	class to implement inter thread communication to print pattern
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
class Pattern {

	private boolean firstStar = true;
	private boolean secondStar = false;
	private boolean thirdStar = false;

	public void printFirst() throws InterruptedException {
		synchronized (this) {
			while (!firstStar) {
				wait();
			}
			System.out.println("*");
			notifyAll();
			firstStar = false;
			secondStar = true;
			thirdStar = false;
		}
	}

	public void printSecond() throws InterruptedException {
		synchronized (this) {
			while (!secondStar) {
				wait();
			}
			System.out.println("* *");
			notifyAll();
			firstStar = false;
			secondStar = false;
			thirdStar = true;
		}
	}

	public void printThird() throws InterruptedException {
		synchronized (this) {
			while (!thirdStar) {
				wait();
			}
			System.out.println("* * *");
			notifyAll();
			firstStar = true;
			secondStar = false;
			thirdStar = false;
		}
	}
}

/*
@description	:	class to test Pattern class with three threads
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
public class PatternTest {

	public static void main(String args[]) {
		Pattern p = new Pattern();
		Thread first = new Thread(() -> {
			while (true) {
				try {

					p.printFirst();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "first");

		Thread second = new Thread(() -> {
			while (true) {
				try {
					p.printSecond();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "second");

		Thread third = new Thread(() -> {
			while (true) {
				try {
					p.printThird();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "third");

		first.start();
		second.start();
		third.start();
	}
}
