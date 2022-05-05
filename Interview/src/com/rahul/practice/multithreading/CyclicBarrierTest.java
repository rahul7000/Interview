package com.rahul.practice.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
@description	:	class to work with barrier.await()
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
class CabService extends Thread {

	private CyclicBarrier barrier;
	private long duration;

	public CabService(String threadName, CyclicBarrier barrier, long duration) {
		super(threadName);
		this.barrier = barrier;
		this.duration = duration;
	}

	@Override
	public void run() {

		System.out.println("Passenger:" + Thread.currentThread().getName() + " take its seat");

		try {
			Thread.sleep(duration);

			int await = barrier.await();

			if (await == 0) {
				System.out.println("All four passenger has arrived now start the ride");
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

/*
 * @description : class to test working of CyclicBarrier
 * 
 * @see :
 * 
 * @version : 1.0
 * 
 * @author : rahul
 * 
 * @since : 17-Jan-2021
 */
public class CyclicBarrierTest {

	public static void main(String args[]) {
		CyclicBarrier barrier = new CyclicBarrier(4);
		Thread passenger1 = new CabService("passenger1", barrier, 1500);
		Thread passenger2 = new CabService("passenger2", barrier, 1500);
		Thread passenger3 = new CabService("passenger3", barrier, 1500);
		Thread passenger4 = new CabService("passenger4", barrier, 1500);

		passenger1.start();
		passenger2.start();
		passenger3.start();
		passenger4.start();
	}
}
