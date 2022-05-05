package com.rahul.practice.java8.methodReference;

public class Java8Tester {

	// normal method for method refernce for object::instanceMethod
	public void myRunDefinition() {
		System.out.println("myRunDefinition()");
	}

	// static method for Class::staticMethod
	public static void myStaticRunDefinition() {
		System.out.println("myStaticrunDefinition()");
	}

	// default constructor for Class::new, it may be of other class
	public Java8Tester() {
		System.out.println("Java8tester()");
	}

	public static void main(String... strings) {

		Java8Tester tester = new Java8Tester();
		Thread t1 = new Thread(() -> {
			System.out.println("Thread-1");
		});
		t1.start();
		Thread t2 = new Thread(() -> {
			System.out.println("Thread-2");
		});
		t2.start();

		Thread t3 = new Thread(tester::myRunDefinition);
		t3.start();
		Thread t4 = new Thread(Java8Tester::myStaticRunDefinition);
		t4.start();
		Thread t5 = new Thread(Java8Tester::new);
		t5.start();

	}
}
