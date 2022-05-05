package com.rahul.practice.datastructure;

import java.util.Iterator;

interface MyStackUsingNodeInterface<T> {
	// return the top item and removes it from stack
	T pop();

	// adds an item to the stack
	void push(T item);

	// returns the number of items in stack right now
	int size();

	// returns true if stack is empty, false otherwise
	boolean isEmpty();

	// returns the iterator to iterate through the stack
	Iterator<T> iterator();

}

/*
 * @description : class to implement stack using Node/List
 * 
 * @see :
 * 
 * @version : 1.0
 * 
 * @author : rahul
 * 
 * @since : 17-Jan-2021
 */
class MyStackUsingNode<T> implements MyStackUsingNodeInterface<T> {

	// inner class to define node
	private class Node<T> {
		T item;
		Node<T> next;

		public Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;

		}
	}

	// inner class to implement Iterator interface
	private class MyStackIterator<T> implements Iterator<T> {

		private int i = size;
		private Node first = head; // the first node

		@Override
		public boolean hasNext() {
			return (i > 0);
		}

		@Override
		public T next() {
			T item = (T) first.item;
			first = first.next;
			i--;
			return item;
		}

	}

	private Node<T> head;
	private int size;

	public MyStackUsingNode() {
		head = null;
		size = 0;
	}

	@Override
	public T pop() {
		if (head == null) {
			System.out.println("UnderFlow:");
			System.exit(0);
		}

		T item = head.item;
		head = head.next;
		size--;
		return item;
	}

	@Override
	public void push(T item) {
		Node<T> oldHead = head;
		Node<T> temp = new Node(item, oldHead);
		head = temp;
		size++;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size <= 0 ? true : false;
	}

	@Override
	public Iterator<T> iterator() {
		return new MyStackIterator();
	}

}

/*
 * @description : class to test MyStackUsingNode
 * 
 * @see :
 * 
 * @version : 1.0
 * 
 * @author : rahul
 * 
 * @since : 17-Jan-2021
 */
public class MyStackUsingNodeTest {
	public static void main(String args[]) {
		MyStackUsingNode<Integer> myStack = new MyStackUsingNode<>();

		myStack.push(new Integer(10));
		myStack.push(new Integer(20));
		myStack.push(new Integer(30));

		Iterator<Integer> itr = myStack.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("Size:" + myStack.size());
		System.out.println("IsEmpty:" + myStack.isEmpty());
		System.out.println("Pop:" + myStack.pop());
	}
}
