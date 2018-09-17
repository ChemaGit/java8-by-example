package com.animals.domain;

import com.animals.Animal;
import com.animals.Pet;

public class Fish extends Animal implements Pet {

	private String name;
	
	public Fish() {
		super(0);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void walks() {
		super.walks();
		System.out.println("Fish, of course, can't walk; They swim.");
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	@Override
	public void play() {
		// TODO Auto-generated method stub		
		System.out.println("Just keep swimming.");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Fish eat pond scum.");
	}


	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

}
