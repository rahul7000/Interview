package com.rahul.practice.designPatterns.prototype;

import java.util.Hashtable;

public class ShapeCache {

	static Hashtable<String, Shape> shapeMap = new Hashtable<>();

	public static Shape getShape(String id) {
		Shape chacheShape = shapeMap.get(id);
		return (Shape) chacheShape.clone();
	}

	// for each shape run database query and create shape shapeMap.put(shapeKey,
	// shape);
	// for example, we are adding three shapes
	public static void loadCache() {
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);
		
		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(), square);

		Rectangle rectangle = new Rectangle();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(), rectangle);
	}
}
