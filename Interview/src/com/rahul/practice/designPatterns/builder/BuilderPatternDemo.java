package com.rahul.practice.designPatterns.builder;

import java.util.ArrayList;
import java.util.List;

public class BuilderPatternDemo {

	public static void main(String...strings) {
		MealBuilder mealBuilder = new MealBuilder();
		
		Meal vegMeal = mealBuilder.prepareVegMeal();
		Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
		
		System.out.println("#### Veg Meal ##########");
		vegMeal.showItems();
		System.out.println("Cost for veg meal: "+vegMeal.getCost());
		
		System.out.println("#### NON Veg Meal ##########");
		nonVegMeal.showItems();
		System.out.println("Cost for non-veg meal: "+nonVegMeal.getCost());
		
		List<Meal> mealList = new ArrayList<>();
		mealList.add(vegMeal);
		mealList.add(nonVegMeal);
		System.out.println("Total price");
		float cost = 0.0f;
		for(Meal meal : mealList) {
			cost += meal.getCost();
		}
		System.out.println(cost);
	}
}
