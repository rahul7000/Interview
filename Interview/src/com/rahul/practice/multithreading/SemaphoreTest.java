package com.rahul.practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
@description	:	class to implement singleton pattern and semaphore concurrency concept
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
class SingleInstance {
	private Semaphore sem = new Semaphore(10);
	private static SingleInstance onlyInstance = new SingleInstance();
	private int connection = 0;

	private SingleInstance() {

	}

	public static SingleInstance getInstance() {
		return onlyInstance;
	}

	public void connect() {
		System.out.println("Waiting for permit:" + Thread.currentThread().getName());
		try {
			sem.acquire();
			connection++;
			System.out.println("Permited" + connection);
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			sem.release();
		}
	}

}

/*
@description	:	class to test singleton pattern and semaphore
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
public class SemaphoreTest {

	public static void main(String args[]) {
		SingleInstance single = SingleInstance.getInstance();
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			executor.execute(() -> {
				single.connect();
			});
		}

		executor.shutdown();

		if (executor.isTerminated()) {
			System.out.println("Terminated");
		}
	}

}
