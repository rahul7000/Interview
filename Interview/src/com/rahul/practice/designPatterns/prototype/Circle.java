package com.rahul.practice.designPatterns.prototype;

public class Circle extends Shape {

	public Circle() {
		type = "Circle";
	}

	@Override
	public void draw() {
		System.out.println("Lets draw a circle");
	}

}
