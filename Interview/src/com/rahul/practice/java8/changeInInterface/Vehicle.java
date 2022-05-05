package com.rahul.practice.java8.changeInInterface;

public interface Vehicle {

	public abstract void name(String name);
	
	public default void print() {
		System.out.println("Vehicle.print()");
	}
	
	public static void helper() {
		System.out.println("Vehicle.helper()");
	}
}
