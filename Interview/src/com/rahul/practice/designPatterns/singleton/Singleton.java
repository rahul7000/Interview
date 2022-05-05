package com.rahul.practice.designPatterns.singleton;

public class Singleton {
	
	//create an object of Singleton
	private static Singleton onlyObject = new Singleton();

	//make the constructor private so that this class cannot be instantiated
	private Singleton() {
	}
	
	//Get the only object available
	public static Singleton getInstance () {
		return onlyObject;
	}
	
	public void showMessage() {
		System.out.println("Only one object created and this can be used for connection purposes");
	}
}
