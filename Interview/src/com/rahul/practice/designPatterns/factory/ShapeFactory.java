package com.rahul.practice.designPatterns.factory;

public class ShapeFactory {

	public static Shape getShape(String shape) {
		Shape shapeObj = null ;
		if(shape.equalsIgnoreCase("circle")) {
			shapeObj = new Circle();
		}
		if(shape.equalsIgnoreCase("square")) {
			shapeObj= new Square();
		}
		if(shape.equalsIgnoreCase("rectangle")) {
			shapeObj = new Rectangle();
		}
		return shapeObj;
		
	}
}
