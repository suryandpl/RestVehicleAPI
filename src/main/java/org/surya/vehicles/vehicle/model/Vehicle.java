package org.surya.vehicles.vehicle.model;


public interface Vehicle {
	default void vehicle() {
		System.out.println("I am a vehicle");
	}
}
