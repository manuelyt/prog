package util.java.object;
//package com.manu.grind75;

import java.io.*;
import java.util.*;
import java.lang.*;

// Abstract Vehicle class with functional dependency
abstract class Vehicle {
	protected String model;

	private static final Map<String, Tuple> vehicleProperties = new HashMap<>();

	static {
		vehicleProperties.put("Car", new Tuple(4, 5));
		vehicleProperties.put("Motorcycle", new Tuple(2, 2));
		vehicleProperties.put("Bicycle", new Tuple(2, 1));
	}

	public Vehicle(String model) {
		this.model = model;
	}

	protected int getNumWheels(String vehicleType) {
		return vehicleProperties.get(vehicleType).numWheels;
	}

	protected int getCapacity(String vehicleType) {
		return vehicleProperties.get(vehicleType).capacity;
	}

	public abstract String transport(int numPeople);
}

// Tuple class to store the number of wheels and capacity
class Tuple {
	int numWheels;
	int capacity;

	public Tuple(int numWheels, int capacity) {
		this.numWheels = numWheels;
		this.capacity = capacity;
	}
}

class Car extends Vehicle {
	int numWheels = 4;
	int capacity = 5;

	public Car(String name) {
		super(name);
	}

	@Override
	public String transport(int numPeople) {
		if (numPeople > capacity) {
			return ("The " + model + " " + this.getClass().getSimpleName().toLowerCase() + " can only transport up to "
					+ capacity + " people.");
		} else {
			return ("Transporting " + numPeople + " people using the " + model + " "
					+ this.getClass().getSimpleName().toLowerCase() + ".");
		}
	}
}

class Motorcycle extends Vehicle {
	int numWheels = 2;
	int capacity = 2;

	public Motorcycle(String name) {
		super(name);
	}

	@Override
	public String transport(int numPeople) {
		if (numPeople > capacity) {
			return ("The " + model + " " + this.getClass().getSimpleName().toLowerCase() + " can only transport up to "
					+ capacity + " people.");
		} else {
			return ("Transporting " + numPeople + " people using the " + model + " "
					+ this.getClass().getSimpleName().toLowerCase() + ".");
		}
	}
}

class Bicycle extends Vehicle {
	int numWheels = 4;
	int capacity = 1;

	public Bicycle(String name) {
		super(name);
	}

	@Override
	public String transport(int numPeople) {
		if (numPeople > capacity) {
			return ("The " + model + " " + this.getClass().getSimpleName().toLowerCase() + " can only transport up to "
					+ capacity + " person.");
		} else {
			return ("Transporting " + numPeople + " people using the " + model + " "
					+ this.getClass().getSimpleName().toLowerCase() + ".");
		}
	}

//public static void Main {
	public static void main(String[] args) throws IOException {

//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String kk22 = "3\r\n" + "car,Toyota,4,5,3\r\n" + "motorcycle,Honda,2,2,2\r\n" + "bicycle,Trek,2,1,1";
		InputStream is = new ByteArrayInputStream(kk22.getBytes());
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
//		PrintWriter out = new PrintWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		int num = Integer.parseInt(br.readLine().trim());

		for (int i = 1; i <= num; i++) {
			String[] arr = br.readLine().trim().split(",");
			switch (arr[0]) {
			case "car":
				Car car = new Car(arr[1]);
				System.out.println(car.transport(Integer.parseInt(arr[4])));
				break;
			case "motorcycle":
				Motorcycle motorcycle = new Motorcycle(arr[1]);
				System.out.println(motorcycle.transport(Integer.parseInt(arr[4])));
				break;
			case "bicycle":
				Bicycle bicycle = new Bicycle(arr[1]);
				System.out.println(bicycle.transport(Integer.parseInt(arr[4])));
				break;
			}
		}
//		out.flush();
//		out.close();
	}
}
