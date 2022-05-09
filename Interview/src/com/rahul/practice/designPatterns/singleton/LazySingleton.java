package com.rahul.practice.designPatterns.singleton;

/**
 * it restricts the creation of the instance until it is requested for first
 * time
 * 
 * @author rahul
 *
 */
public class LazySingleton {

	private static volatile LazySingleton instance = null;

	private LazySingleton() {

	}

	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}

	// Suppose there are two threads T1 and T2. Both come to create the instance and
	// check if “instance==null”. Now both threads have identified instance variable
	// as null thus they both assume they must create an instance

	// This error can be solved using double-checked locking. This principle tells
	// us to recheck the instance variable again in a synchronized block as given
	// below:

	public static LazySingleton getInstance2() {
		if (instance == null) {
			synchronized (LazySingleton.class) {
				if (instance == null) {
					instance = new LazySingleton();
				}
			}

		}
		return instance;
	}
}
