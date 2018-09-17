package com.exception.assertion;

public enum Suit {
	CLUBS("Clubs"), DIAMONDS("Diamonds"), HEARTS("Hearts"), SPADES("Spades"), SHELLS("Shells");
	
	private String type;
	
	private Suit(String type) {
		this.type = type;
	}
}
