package com.rahul.practice.datastructure;

import java.util.Iterator;
import java.util.Stack;

interface MyQueueInterface<T> {
	// return the front item and removes it from queue
	T dequeue();

	// adds an item to the rear of queue
	void enqueue(T item);

	// returns the number of items in queue right now
	int size();

	// returns true if queue is empty, false otherwise
	boolean isEmpty();

	// returns the iterator to iterate through the queue
	Iterator<T> iterator();
}

/*
 * @description : class to implement queue using two stacks
 * 
 * @see :
 * 
 * @version : 1.0
 * 
 * @author : rahul
 * 
 * @since : 17-Jan-2021
 */
class MyQueue<T> implements MyQueueInterface<T> {

	Stack<T> s1;
	Stack<T> s2;

	public MyQueue() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	@Override
	public T dequeue() {
		if (s1.isEmpty()) {
			System.out.println("UnderFlow:");
			System.exit(0);
		}
		return s1.pop();
	}

	@Override
	public void enqueue(T item) {

		// Move all elements from the first stack to the second stack
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}

		// Push item into the first stack
		s1.push(item);

		// Move all elements back to the first stack from second stack to follow FIFO
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}

	@Override
	public int size() {
		return s1.size();
	}

	@Override
	public boolean isEmpty() {
		return s1.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return s1.iterator();
	}

}

/*
 * @description : class to implement queue using single stack
 * 
 * @see :
 * 
 * @version : 1.0
 * 
 * @author : rahul
 * 
 * @since : 17-Jan-2021
 */
class MyQueueUsingSingleStack<T> implements MyQueueInterface<T> {

	private Stack<T> s;

	public MyQueueUsingSingleStack() {
		s = new Stack<>();
	}

	@Override
	public T dequeue() {

		if (s.isEmpty()) {
			System.out.println("UnderFlow:");
			System.exit(0);
		}

		// pop an item from the stack
		T top = s.pop();

		// if stack becomes empty, return the popped item
		if (s.isEmpty()) {
			return top;
		}

		// recurrsion
		T item = dequeue();

		// push popped item back to the stack
		s.push(top);

		// return the result of dequeue() call
		return item;
	}

	@Override
	public void enqueue(T item) {
		s.push(item);
	}

	@Override
	public int size() {
		return s.size();
	}

	@Override
	public boolean isEmpty() {

		return s.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return s.iterator();
	}

}

/*
 * @description : class to test MyQueue
 * 
 * @see :
 * 
 * @version : 1.0
 * 
 * @author : rahul
 * 
 * @since : 17-Jan-2021
 */
public class MyQueueTest {

	public static void main(String args[]) {
		MyQueue<Integer> myQueue = new MyQueue<>();
		myQueue.enqueue(new Integer(10));
		myQueue.enqueue(new Integer(20));
		myQueue.enqueue(new Integer(30));

		Iterator<Integer> itr = myQueue.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("Size:" + myQueue.size());
		System.out.println("IsEmpty:" + myQueue.isEmpty());
		System.out.println("Dequeue:" + myQueue.dequeue());

		Iterator<Integer> itr2 = myQueue.iterator();
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}

		MyQueueUsingSingleStack<Integer> myQueue2 = new MyQueueUsingSingleStack<>();
		myQueue2.enqueue(new Integer(10));
		myQueue2.enqueue(new Integer(20));
		myQueue2.enqueue(new Integer(30));

		Iterator<Integer> itr3 = myQueue2.iterator();
		while (itr3.hasNext()) {
			System.out.println(itr3.next());
		}

		System.out.println("Size:" + myQueue2.size());
		System.out.println("IsEmpty:" + myQueue2.isEmpty());
		System.out.println("Dequeue:" + myQueue2.dequeue());

		Iterator<Integer> itr4 = myQueue2.iterator();
		while (itr4.hasNext()) {
			System.out.println(itr4.next());
		}

	}
}
