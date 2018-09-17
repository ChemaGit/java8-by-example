package com.animals.domain;

import com.animals.Animal;

public class Spider extends Animal{
	
	public Spider() {
		super(8);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("The Spider eats a fly.");		
	}

}
