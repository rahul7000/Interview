package com.rahul.practice.designPatterns.builder;

public abstract class ColdDrink implements Item {
	public Packing packing() {
		return new Bottle();
	}
}
