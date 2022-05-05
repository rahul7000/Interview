package com.rahul.practice.multithreading;

import java.util.concurrent.CountDownLatch;

/*
@description	:	class to work with latch.countDown()
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
class DeveloperTeam extends Thread {
	private CountDownLatch latch;
	private long duration;

	DeveloperTeam(String message, CountDownLatch latch, long duration) {
		super(message);
		this.latch = latch;
		this.duration = duration;
	}

	@Override
	public void run() {

		System.out.println("Developer:" + Thread.currentThread().getName() + " start working");
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Developer:" + Thread.currentThread().getName() + " done working");
		latch.countDown();

	}
}

/*
 * @description : class to test CountDownLatch so that testing will be started
 * once all the dev thread done with their computation
 * 
 * @see :
 * 
 * @version : 1.0
 * 
 * @author : rahul
 * 
 * @since : 17-Jan-2021
 */
public class CountDownLatchTest {

	public static void main(String args[]) {
		CountDownLatch latch = new CountDownLatch(4);
		Thread dev1 = new DeveloperTeam("dev1", latch, 1500);
		Thread dev2 = new DeveloperTeam("dev2", latch, 1500);
		Thread dev3 = new DeveloperTeam("dev3", latch, 1500);
		Thread dev4 = new DeveloperTeam("dev4", latch, 1500);

		dev1.start();
		dev2.start();
		dev3.start();
		dev4.start();

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(
				"Now testing team can start their testing, all developer threads are done with their computation");
	}
}
