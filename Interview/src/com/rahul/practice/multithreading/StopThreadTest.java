package com.rahul.practice.multithreading;

/*
@description	:	thread class to implement the code to stop a running thread
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
class StopThread extends Thread {

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			System.out.println("Running Thread");
		}
		System.out.println("Thread is stopped");
	}
}

/*
@description	:	class to test StopThread
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
public class StopThreadTest {
	public static void main(String args[]) {
		Thread thread1 = new StopThread();
		thread1.start();
		System.out.println("Thread is started");
		thread1.interrupt();
	}
}
