package com.rahul.practice.multithreading;

/*
@description	:	class to implement ping pong print using different threads
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
class PingPong {
	private boolean ping = true;
	private boolean pong = false;

	public void printPing() throws InterruptedException {
		synchronized (this) {
			while (!ping) {
				wait();
			}
			System.out.println("ping");
			notify();
			ping = false;
			pong = true;
		}
	}

	public void printPong() throws InterruptedException {
		synchronized (this) {
			while (!pong) {
				wait();
			}
			System.out.println("pong");
			notify();
			ping = true;
			pong = false;
		}
	}
}

/*
 * @description : class to test PingPong
 * 
 * @see :
 * 
 * @version : 1.0
 * 
 * @author : rahul
 * 
 * @since : 17-Jan-2021
 */
public class PingPongTest {

	public static void main(String args[]) {
		PingPong pp = new PingPong();
		Thread ping = new Thread(() -> {
			while (true) {
				try {
					pp.printPing();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "ping");

		Thread pong = new Thread(() -> {
			while (true) {
				try {
					pp.printPong();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "pong");

		ping.start();
		pong.start();
	}
}
