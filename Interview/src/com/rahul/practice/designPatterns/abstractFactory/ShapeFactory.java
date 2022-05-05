package com.rahul.practice.designPatterns.abstractFactory;

public class ShapeFactory extends AbstractFactory{

	@Override
	public Shape getShape(String shape) {
		Shape shapeObj = null;
		if (shape.equalsIgnoreCase("circle")) {
			shapeObj = new Circle();
		}
		if (shape.equalsIgnoreCase("square")) {
			shapeObj = new Square();
		}
		if (shape.equalsIgnoreCase("rectangle")) {
			shapeObj = new Rectangle();
		}
		return shapeObj;
	}

	@Override
	public Color getColor(String color) {
		return null;
	}
}
