package com.example.abstract_banking;

public abstract class Account { 
	
	private double balance;
	
	public Account(double balance) {
		this.balance = balance;
	}

	public abstract boolean withdraw(double amount);
	
	public abstract String getDescription();

}
