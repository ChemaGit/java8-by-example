package com.animals;

public abstract class Animal {

	protected int legs;
	
	protected Animal(int legs) {
		this.legs = legs;
	}
	
	public void walks() {
		System.out.println("This animal walks on " + this.legs + " legs.");
	}
	
	public abstract void eat();
}
