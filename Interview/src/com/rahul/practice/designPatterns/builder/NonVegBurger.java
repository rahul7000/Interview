package com.rahul.practice.designPatterns.builder;

public class NonVegBurger extends Burger{

	@Override
	public String name() {
		return "Chicken Burger";
	}

	@Override
	public float price() {
		return 35.5f;
	}

}
