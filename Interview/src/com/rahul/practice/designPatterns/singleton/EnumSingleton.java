package com.rahul.practice.designPatterns.singleton;

/**
 * This type of implementation employs the use of enum. Enum, as written in the
 * java docs, provided implicit support for thread safety and only one instance
 * is guaranteed
 * 
 * @author rahul
 *
 */
public enum EnumSingleton {
	
	INSTANCE;
	
	public void someMethod(String param) {
	    // some class member
	  }

}
