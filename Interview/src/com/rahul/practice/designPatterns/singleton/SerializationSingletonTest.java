package com.rahul.practice.designPatterns.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Let’s say your application is distributed and it frequently serializes
 * objects into the file system, only to read them later when required. Please
 * note that de-serialization always creates a new instance
 * 
 * @author rahul
 *
 */
class DemoSingleton implements Serializable {

	private static final long serialVersionUID = 1L;

	private volatile static DemoSingleton instance = null;

	public static DemoSingleton getInstance() {
		if (instance == null) {
			instance = new DemoSingleton();
		}
		return instance;
	}

	// This method will be invoked when you will de-serialize the object. Inside of
	// this method, you must return the existing instance to ensure a single
	// instance application wide.
	protected Object readResolve() {
		return instance;
	}

	private int i = 10;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}

public class SerializationSingletonTest {
	static DemoSingleton instanceOne = DemoSingleton.getInstance();

	public static void main(String[] args) {
		try {
			// Serialize to a file
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
			out.writeObject(instanceOne);
			out.close();

			instanceOne.setI(20);

			// Serialize to a file
			ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
			DemoSingleton instanceTwo = (DemoSingleton) in.readObject();
			in.close();

			System.out.println(instanceOne.getI());
			System.out.println(instanceTwo.getI());

			// Unfortunately, both variables have different values of the variable “i”.
			// Clearly, there are two instances of our class. So, again we are in the same
			// problem of multiple instances in our application.
			// 20,10

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
