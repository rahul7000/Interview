package com.rahul.practice.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

interface MyStackInterface<T>{
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
@description	:	class to implement stack using queue
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
class MyStack<T> implements MyStackInterface<T>{

	private Queue<T> queue;
	//private int size;
	
	MyStack(){
		queue = new LinkedList<>();
	}

	@Override
	public T pop() {
		return queue.remove();
	}

	
	@Override
	public void push(T item) {
		int sizeOfQueue = queue.size();
		queue.add(item);
		
		for(int i=0;i<sizeOfQueue;i++) {
			//adds the same item from front to back for LIFO
			queue.add(queue.remove());
		}
		
	}

	@Override
	public int size() {
		return queue.size();
	}

	
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return queue.iterator();
	}
	
	
}

/*
@description	:	class to test MyStack
@see			:	
@version		:	1.0
@author			:	rahul
@since			:	17-Jan-2021
*/
public class MyStackTest {

	public static void main(String args[]) {
		MyStack<Integer> myStack = new MyStack<Integer>();
		myStack.push(new Integer(10));
		myStack.push(new Integer(20));
		myStack.push(new Integer(30));
		
		Iterator<Integer> itr = myStack.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("Size:"+myStack.size());
		System.out.println("IsEmpty:"+myStack.isEmpty());
		System.out.println("Pop:"+myStack.pop());
		
		Iterator<Integer> itr2 = myStack.iterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
		
	}
}
