package com.rahul.practice.java8.changeInInterface;

public interface TwoWheeler {
	public abstract void name(String name);

	public default void print() {
		System.out.println("TwoWheeler.print()");
	}

	public static void helper() {
		System.out.println("TwoWheeler.helper()");
	}
}
