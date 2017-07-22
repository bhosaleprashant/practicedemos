package com.practice;

class Animal {
	public String animalSound;
	
	public Animal(String animalSound) {
		this.animalSound = animalSound;
	}
	
	public void sound() {
		System.out.println("I am a animal");
	}

	@Override
	public String toString() {
		return "Animal [animalSound=" + animalSound + "]";
	}
}

class Dog extends Animal {
	public String name;
	
	public Dog(String name) {
		super("pien");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}
	
	public void sound() {
		System.out.println("I am a "+name);
	}
	
}

public class InheritanceDemo {

	public static void main(String[] args) {
		Animal a = new Dog("pug");
		System.out.println(a);
		a.sound();
	}
}
