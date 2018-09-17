package com.example.abstract_banking;

public class CheckingAccount extends Account{
	
	private final double overDraftLimit;
	private static double balance;
	
	public CheckingAccount(double balance, double overDraftLimit){
		super(balance);
		this.overDraftLimit = overDraftLimit;
	}
	
	public CheckingAccount(double overDraftLimit) {
		this(balance,0);
	}

	@Override
	public boolean withdraw(double amount) {
		if(amount <= this.overDraftLimit + balance) {
			balance -= amount;
			return true;
		}
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Checking Account";
	}

}
