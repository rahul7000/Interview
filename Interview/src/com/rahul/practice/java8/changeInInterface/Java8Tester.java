package com.rahul.practice.java8.changeInInterface;

import java.util.HashMap;
import java.util.Map;

public class Java8Tester {

	public static void main(String... strings) {

		VehicleShop shop = new VehicleShop();
		shop.print();

		Vehicle vehicle = str -> System.out.println(str);
		FourWheeler car = str -> System.out.println(str);
		TwoWheeler cycle = str -> System.out.println(str);

		vehicle.name("BMW");
		car.name("Car-GT700");
		cycle.name("Cycle-456");

		Vehicle.helper();
		FourWheeler.helper();
		TwoWheeler.helper();

		Map<Integer, String> hMap = new HashMap<>();
		hMap.put(1, "Rahul");
		hMap.put(2, "Amar");
		hMap.put(4, "Gunjan");
		hMap.put(3, "Ayush");

		hMap.forEach((key, value) -> {
			System.out.println(key + " " + value);
		});

		hMap.keySet().stream()
		.filter(f -> f % 2 == 0)
		.forEach(key -> {
			System.out.println(hMap.get(key));
		});

	}
}
