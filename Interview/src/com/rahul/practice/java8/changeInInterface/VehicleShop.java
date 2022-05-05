package com.rahul.practice.java8.changeInInterface;

public class VehicleShop implements Vehicle, FourWheeler, TwoWheeler {

	@Override
	public void name(String name) {
		System.out.println(name);
	}

	@Override
	public void print() {
		Vehicle.super.print();
		FourWheeler.super.print();
		TwoWheeler.super.print();
		System.out.println("VehicleShop.print()");
	}

}
