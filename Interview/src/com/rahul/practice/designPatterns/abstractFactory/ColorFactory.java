package com.rahul.practice.designPatterns.abstractFactory;

public class ColorFactory extends AbstractFactory{

	@Override
	public Color getColor(String color) {
		Color colorObj = null;
		if(color.equalsIgnoreCase("red")) {
			colorObj= new Red();
		}
		if(color.equalsIgnoreCase("green")) {
			colorObj= new Green();
		}
		if(color.equalsIgnoreCase("blue")) {
			colorObj = new Blue();
		}
		return colorObj;
	}

	@Override
	public Shape getShape(String shape) {
		return null;
	}
}
