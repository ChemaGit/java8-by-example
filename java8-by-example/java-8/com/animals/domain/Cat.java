package com.animals.domain;

import com.animals.Animal;
import com.animals.Pet;

public class Cat extends Animal implements Pet{
	
	private String name;
	
	public Cat(){
		this("Fluffy");
	}

	public Cat(String name) {
		// TODO Auto-generated constructor stub
		super(4);
		this.name = name;
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Cats like to eat spiders and fish.");
	}
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " likes to play with strings.");
	}
		

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}
	
}
