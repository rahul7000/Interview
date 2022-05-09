package com.rahul.practice.designPatterns.singleton;

/**
 * Bill Pugh was main force behind the java memory model changes. His principle
 * “Initialization-on-demand holder idiom” also uses the static block idea, but
 * in a different way
 * 
 * @author rahul
 *
 */
public class BillPughSingleton {

	private BillPughSingleton() {

	}

	private static class LazyHolder {
		private static BillPughSingleton instance = new BillPughSingleton();
	}

	public static BillPughSingleton getInstance() {
		return LazyHolder.instance;
	}

	// As you can see, until we need an instance, the LazyHolder class will not be
	// initialized until required and you can still use other static members of
	// BillPughSingleton class. This is the solution, i will recommend to use. I
	// have used it in my all projects.
}
