package com.rahul.practice.designPatterns.factory;

public class FactoryPatternDemo {

	public static void main(String...strings) {
		
		Shape circleShape = ShapeFactory.getShape("Circle");
		System.out.println("Circle Obj : ");
		circleShape.draw();
		
		Shape squareShape = ShapeFactory.getShape("square");
		System.out.println("Square Obj : ");
		squareShape.draw();
		
		Shape rectangleShape = ShapeFactory.getShape("Rectangle");
		System.out.println("Rectangle Obj : ");
		rectangleShape.draw();
	}
}
