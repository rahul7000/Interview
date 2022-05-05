package com.rahul.practice.datastructure;

import java.util.Iterator;

interface MyLinkedListInterface<T> {

	void addFirst(T item);

	void add(T item);

	T removeFirst();

	T remove();

	int size();

	boolean isEmpty();

	Iterator<T> iterator();

}

/*
@description	:	class to implement doubly linked list using Node class
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
class MyLinkedList<T> implements MyLinkedListInterface<T> {

	//inner class to define node
	private class Node<T> {
		T item;
		Node<T> next;
		Node<T> prev;

		public Node(Node<T> prev, T item, Node<T> next) {
			this.item = item;
			this.prev = prev;
			this.next = next;

		}
	}

	//inner class to implement Iterator interface
	private class MyLinkedListIterator<T> implements Iterator<T> {

		private int i = size;
		private Node f = head;

		@Override
		public boolean hasNext() {
			return (i > 0);
		}

		@Override
		public T next() {
			T item = (T) f.item;
			f = f.next;
			i--;
			return item;
		}

	}

	private Node<T> head;
	private Node<T> tail;
	private int size;
	private int modCount;

	public MyLinkedList() {
		head = null;
		tail = null;
		size = 0;
		modCount = 0;
	}

	@Override
	public void addFirst(T item) {
		Node<T> f = head;
		Node<T> temp = new Node(null, item, f);

		head = temp;

		if (f == null) {
			tail = temp;
		} else {
			f.prev = temp;
		}
		size++;
		modCount++;
	}

	@Override
	public void add(T item) {
		Node<T> l = tail;
		Node<T> temp = new Node(l, item, null);

		tail = temp;

		if (l == null) {
			head = temp;
		} else {
			l.next = temp;
		}
		size++;
		modCount++;

	}

	@Override
	public T removeFirst() {
		if (head == null) {
			System.out.println("UnderFlow:");
			System.exit(0);
		}
		T item = head.item;
		head = head.next;
		head.prev = null;
		size--;
		modCount--;

		return item;
	}

	@Override
	public T remove() {
		if (tail == null) {
			System.out.println("UnderFlow:");
			System.exit(0);
		}
		T item = tail.item;
		tail = tail.prev;
		tail.next = null;
		size--;
		modCount--;

		return item;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public Iterator<T> iterator() {

		return new MyLinkedListIterator();
	}

}

/*
@description	:	class to test MyLinkedList
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
public class MyLinkedListTest {

	public static void main(String args[]) {
		MyLinkedList<Integer> myList = new MyLinkedList<>();
		myList.add(new Integer(10));
		myList.add(new Integer(20));
		myList.addFirst(new Integer(30));
		myList.add(new Integer(40));

		Iterator<Integer> itr = myList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("Size:" + myList.size());
		System.out.println("IsEmpty:" + myList.isEmpty());
		System.out.println("Remove:" + myList.remove());
		
		Iterator<Integer> itr2 = myList.iterator();
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}
	}
}
