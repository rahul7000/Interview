package com.rahul.practice.designPatterns.prototype;

public class PrototypePatternDemo {
	public static void main(String... strings) {
		ShapeCache.loadCache();
		Shape clonedCircle = ShapeCache.getShape("1");
		Shape clonedSquare = ShapeCache.getShape("2");
		Shape clonedRectangle = ShapeCache.getShape("3");
		
		System.out.println(clonedCircle.getType());
		System.out.println(clonedSquare.getType());
		System.out.println(clonedRectangle.getType());
	}
}
