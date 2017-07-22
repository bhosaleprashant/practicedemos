package com.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @author Prashant
 * a) During DeSerialization of SubClass ( Bike in this case ), the default constructor of Super class gets invoked first.
 * ( As super() is added by compiler during runtime )
 * b) If we have defined parameterized constructor of super class, we will get "Compile Time Error" 
 * as "Implicit super constructor Vehicle() is undefined. Must explicitly invoke another constructor"
 *	b1) So, it now becomes mandatory to define a default constructor of super class.
 * 	b2) During DeSerialization, readObject will try to get the default constructor of super class, if it did not find the 
 * 		default constructor of super class, we get "Runtime Exception"  no valid constructor.
 * 
 */

class Vehicle {
	public String startType;
	public String fuelType;
	
	public Vehicle() {
		super();
		System.out.println("Inside Vehicle");
	}
	
	/*public Vehicle(String strtTyp,String fuelTyp) {
		System.out.println("Vehicle parameterised");
		this.startType = strtTyp;
		this.fuelType = fuelTyp;
	}*/
	
	public Vehicle(String s) {
		System.out.println(s);
	}
}

class Bike extends Vehicle implements Serializable {

	private static final long serialVersionUID = 1L;
	public String bikeName;
	
	public Bike() {
		super();
		System.out.println("Inside Bike Class");
	}

	public Bike(String name) {
		super(name);
		this.bikeName = name;
	}

	@Override
	public String toString() {
		return "Bike [bikeName=" + bikeName + "]";
	}
	
}

public class SerializationDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		System.out.println("Start");
		Bike b1 = new Bike("Yamaha");
		System.out.println("Serialization");
		System.out.println(b1);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/tmp/Bike.ser"));
		oos.writeObject(b1);
		oos.close();
		
		System.out.println("Deserialization");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/tmp/Bike.ser"));
		Bike b2 = (Bike)ois.readObject();
		ois.close();
		System.out.println(b2);
		
	}
}
