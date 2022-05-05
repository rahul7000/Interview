package com.rahul.practice.datastructure;

import java.util.EmptyStackException;

class StackUsingArray {

	private int size;
	private int index = 0;
	private int[] array;

	public StackUsingArray(int size) {
		this.size = size;
		array = new int[size];
	}

	public void push(int element) {
		if (!isFull()) {
			new StackOverflowError("Stack is full");
		}
		array[index] = element;
		index++;
	}

	public boolean isEmpty() {
		return (index == 0);
	}

	public int size() {
		return size;
	}

	public Object pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		size--;
		return array[--index];
	}

	public boolean isFull() {
		return (index == size);
	}
}

public class StackUsingArrayTest {
	public static void main(String[] args) {

		StackUsingArray stack = new StackUsingArray(5);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);

		System.out.println("1. Size of stack after push operations: " + stack.size());

		System.out.printf("2. Pop elements from stack : ");
		while (!stack.isEmpty()) {
			System.out.printf(" %d", stack.pop());
		}

		System.out.println("\n3. Size of stack after pop operations : " + stack.size());
	}
}
