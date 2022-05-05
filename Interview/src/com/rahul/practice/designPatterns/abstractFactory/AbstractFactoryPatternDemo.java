package com.rahul.practice.designPatterns.abstractFactory;

public class AbstractFactoryPatternDemo {

	public static void main(String...strings) {
		AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
		
		Shape shapeObj = shapeFactory.getShape("circle");
		System.out.println("Circle Object :");
		shapeObj.draw();
		
		 AbstractFactory colorFactory = FactoryProducer.getFactory("color");
		 Color colorObj = colorFactory.getColor("green");
		 System.out.println("Green Object :");
		 colorObj.fill();
	}
}
