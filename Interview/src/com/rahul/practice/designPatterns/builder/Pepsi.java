package com.rahul.practice.designPatterns.builder;

public class Pepsi extends ColdDrink{

	@Override
	public String name() {
		return "Pepsi";
	}

	@Override
	public float price() {
		return 30f;
	}

}
