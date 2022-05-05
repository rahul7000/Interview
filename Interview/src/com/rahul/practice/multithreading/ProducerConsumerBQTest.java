package com.rahul.practice.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * The BlockingQueue interface is part of the java.util.concurrent package. 
 * If a producer thread tries to put an element in a full BlockingQueue, it gets blocked and stays blocked until a consumer removes an element.
 * Similarly, if a consumer thread tries to take an element from an empty BlockingQueue, it gets blocked and remains blocked until a producer adds an element.
 * BlockingQueue has two primary methods i.e. put() and take()
 */

/**
 * BlockingQueue also has add(E e) and remove() methods. But these methods must not be used for producer-consumer problems because: 
 * add will throw IllegalStateException if the queue is full.
 * remove returns a boolean, but an element is to be returned.
 */

/**
 * ArrayBlockingQueue
 * As the name suggests, an ArrayBlockingQueue uses the array data structure as a buffer.
 * Since it is an array, its capacity is fixed after declaration.
 * It provides fairness as an option. This means threads are given access to the buffer on a first-come, first-serve basis. 
 * Fairness is off by default. It can be turned on by placing the boolean value true inside the constructor.
 */

/**
 * Producer using BlockingQueue example
 * 
 * @author rahul
 *
 */
class Producer implements Runnable {
	// Queue
	private BlockingQueue<Integer> queue;
	private Integer poison = -1;

	// Constructor to initialize
	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	// run method for producer threaad
	public void run() {
		// handle excception
		try {
			// loop
			for (int i = 0; i < 10; i++) {
				// put task/message in the queue
				queue.put(produce());
				// sleep for 500ms
				Thread.sleep(500);
			}
			// put poison element
			queue.put(poison); // indicates end of producing
			System.out.println("Producer STOPPED.");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	// Method to produce message/task
	private Integer produce() {
		// task/message
		Integer number = new Integer((int) (Math.random() * 100));
		System.out.println("Producing number => " + number);
		return number;
	}
}

/**
 * Consumer using BlockingQueue example
 * 
 * @author rahul
 *
 */
class Consumer implements Runnable {
	// queue
	private BlockingQueue<Integer> queue;
	// thread id
	private String threadId;
	// poison element
	private Integer poison = -1;

	// cons to initialize
	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	// overridden run method
	public void run() {
		threadId = "Consumer-" + Thread.currentThread().getId();
		// handle exception
		try {
			// loop
			while (true) {
				// poll from queue
				Integer number = queue.poll(5, TimeUnit.SECONDS);
				// check
				if (number == null || number == poison) {
					break;
				}
				// consume task
				consume(number);
				// sleep for 1000ms
				Thread.sleep(1000);
			}
			System.out.println(threadId + " STOPPED.");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	// action performed by consumer thread
	private void consume(Integer number) {
		System.out.println(threadId + ": Consuming number <= " + number);
	}
}

public class ProducerConsumerBQTest {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(20);

		Thread producer = new Thread(new Producer(queue));

		Thread consumer1 = new Thread(new Consumer(queue));
		Thread consumer2 = new Thread(new Consumer(queue));
		Thread consumer3 = new Thread(new Consumer(queue));

		producer.start();

		consumer1.start();
		consumer2.start();
		consumer3.start();

	}

}
