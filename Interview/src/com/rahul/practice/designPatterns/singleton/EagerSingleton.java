package com.rahul.practice.designPatterns.singleton;

/**
 * The singleton instance is created irrespective of whether any other class
 * actually asked for its instance or not.
 * 
 * @author rahul
 *
 */
public class EagerSingleton {

	private static volatile EagerSingleton instance = new EagerSingleton();

	private EagerSingleton() {

	}

	public static EagerSingleton getInstance() {
		return instance;
	}

}
