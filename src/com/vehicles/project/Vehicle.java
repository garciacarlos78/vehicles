package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}

	// Fase3, added abstract method to add wheels
	public abstract void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception;

	@Override
	public String toString() {
		return "Vehicle{" +
				"plate='" + plate + '\'' +
				", brand='" + brand + '\'' +
				", color='" + color + '\'' +
				", wheels=" + wheels +
				'}';
	}
}
