package com.example.domain;

public enum Gender {
	MALE("Male"), FEMALE("Female");
	
	private String type;
	
	private Gender(String type) {
		this.type = type;
	}
	
}