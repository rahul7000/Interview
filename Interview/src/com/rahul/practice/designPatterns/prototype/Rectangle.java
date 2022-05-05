package com.rahul.practice.designPatterns.prototype;

public class Rectangle extends Shape {

	public Rectangle() {
		type = "Rectangle";
	}

	@Override
	public void draw() {
		System.out.println("Lets draw a rectangle");
	}

}
