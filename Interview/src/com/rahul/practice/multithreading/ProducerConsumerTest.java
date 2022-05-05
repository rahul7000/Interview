package com.rahul.practice.multithreading;

import java.util.LinkedList;
import java.util.Queue;

/*
@description	:	class to implement producer consumer
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
class ProducerConsumer {
	private Queue<Integer> queue;
	private int size;

	ProducerConsumer(int size) {
		queue = new LinkedList<>();
		this.size = size;
	}

	public void produces(int value) throws InterruptedException {
		synchronized (this) {
			while (queue.size() == size) {
				wait();
			}
			queue.add(value);
			System.out.println(
					"Thread is:" + Thread.currentThread().getName() + " Produces:" + value + " size:" + queue.size());
			notify();
			Thread.sleep(500);
		}
	}

	public void consumes() throws InterruptedException {

		synchronized (this) {
			while (queue.size() == 0) {
				wait();
			}

			System.out.println("Thread is:" + Thread.currentThread().getName() + " Consumes:" + queue.remove()
					+ " size:" + queue.size());
			notify();
			Thread.sleep(500);
		}
	}
}

/*
@description	:	class to test producer consumer problem
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
public class ProducerConsumerTest {

	public static void main(String args[]) {

		ProducerConsumer pc = new ProducerConsumer(4);
		int value = 1;

		Thread producer = new Thread(() -> {
			while (true) {
				try {
					pc.produces(value);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "producer");

		Thread consumer = new Thread(() -> {
			while (true) {
				try {
					pc.consumes();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "consumer");

		producer.start();
		consumer.start();
	}
}
