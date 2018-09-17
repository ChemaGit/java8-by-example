package com.exception.assertion;

public class Invariant {
	
	static void checkNum(int num) {
		int x = num;
		if(x > 0) {
			System.out.println("The number is positive: " + x);
		} else if(x == 0) {
			System.out.println("The number is zero: " + x);
		} else {
			assert(x > 0);//Internal invariant
		}
		 
	}
	
	static void checkSuit(Suit suit) {
		
		switch(suit) {
			case CLUBS: 
				break;
			case DIAMONDS:
				break;
			case HEARTS:
				break;
			case SPADES:
				break;
				default:
					assert false : "Unknown playing card suit.";			
		}
	}
	
	public static void main(String args[]) {
		checkNum(4);
		checkSuit(Suit.SHELLS);  
	}

}
