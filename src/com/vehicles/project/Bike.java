package com.vehicles.project;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	@Override
	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addWheel(frontWheels);
		addWheel(backWheels);
	}

	private void addWheel(List<Wheel> wheel) throws Exception {

		// Check that there is only one wheel
		if (wheel.size()!=1) throw new Exception();

		// Add the only wheel of the list
		this.wheels.add(wheel.get(0));
	}
}
