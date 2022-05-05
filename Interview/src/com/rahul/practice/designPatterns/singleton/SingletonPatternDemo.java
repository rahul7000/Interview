package com.rahul.practice.designPatterns.singleton;

public class SingletonPatternDemo {

	public static void main(String... strings) {
		// illegal construct
		// Compile Time Error: The constructor SingleObject() is not visible
		// Singleton single = new Singleton();

		// Get the only object available
		Singleton singleObj = Singleton.getInstance();

		singleObj.showMessage();
	}
}
