package com.rahul.practice.designPatterns.singleton;

/**
 * you can use the fact that static blocks are executed during the loading of a
 * class, even before the constructor is called.
 * 
 * @author rahul
 *
 */
public class StaticBlockSingleton {

	private static final StaticBlockSingleton instance;

	static {
		instance = new StaticBlockSingleton();
	}

	private StaticBlockSingleton() {

	}

	public static StaticBlockSingleton getInstance() {
		return instance;
	}

}
