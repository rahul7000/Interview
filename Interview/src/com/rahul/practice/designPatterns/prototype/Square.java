package com.rahul.practice.designPatterns.prototype;

public class Square extends Shape {

	public Square() {
		type = "Square";
	}

	@Override
	public void draw() {
		System.out.println("Lets draw a square");
	}

}
