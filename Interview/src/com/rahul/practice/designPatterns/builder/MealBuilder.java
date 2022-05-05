package com.rahul.practice.designPatterns.builder;

public class MealBuilder {

	//complex object(meal) using simple objects
	public Meal prepareVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}
	
	//complex object(meal) using simple objects
	public Meal prepareNonVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new NonVegBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}
