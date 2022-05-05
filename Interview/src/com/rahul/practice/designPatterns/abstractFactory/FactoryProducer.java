package com.rahul.practice.designPatterns.abstractFactory;

public class FactoryProducer {

	public static AbstractFactory getFactory(String factory) {
		AbstractFactory abstractFactory = null;

		if (factory.equalsIgnoreCase("shape")) {
			abstractFactory = new ShapeFactory();
		}

		if (factory.equalsIgnoreCase("color")) {
			abstractFactory = new ColorFactory();
		}
		return abstractFactory;

	}
}
