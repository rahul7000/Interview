package com.rahul.practice.multithreading;

/*
@description	:	class to implement logic for even or odd numbers 
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
class EvenOdd {

	private int count = 0, maxCount;

	public EvenOdd(int maxCount) {
		this.maxCount = maxCount;
	}

	public void even() throws InterruptedException {
		synchronized (this) {
			while (count < maxCount) {
				while (count % 2 != 0) {
					wait();
				}
				System.out.println("Thread:" + Thread.currentThread().getName() + " Even no.:" + count);
				notify();
				count++;
			}
		}
	}

	public void odd() throws InterruptedException {
		synchronized (this) {
			while (count < maxCount) {
				while (count % 2 == 0) {
					wait();
				}
				System.out.println("Thread:" + Thread.currentThread().getName() + " Odd no.:" + count);
				notify();
				count++;
			}
		}
	}

}

/*
@description	:	class to test EvenOdd class
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
public class EvenOddTest {

	public static void main(String args[]) {

		EvenOdd eo = new EvenOdd(10);

		Thread even = new Thread(() -> {
			try {
				eo.even();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "even");

		Thread odd = new Thread(() -> {
			try {
				eo.odd();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "odd");

		even.start();
		odd.start();

	}
}
