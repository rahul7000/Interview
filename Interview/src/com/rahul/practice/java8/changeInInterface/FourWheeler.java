package com.rahul.practice.java8.changeInInterface;

public interface FourWheeler {

	public abstract void name(String name);

	public default void print() {
		System.out.println("FourWheeler.print()");
	}

	public static void helper() {
		System.out.println("FourWheeler.helper()");
	}
}
