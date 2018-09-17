package com.example.abstract_banking;

public class Customer {
	private Branch branch;
	private String firstName;
	private String lastName;
	private Account[] accounts;
	private int numberOfAccount;
	
	public Customer(String f, String l, Branch b) {
		this.firstName = f;
		this.lastName = l;
		this.accounts = new Account[10];
		this.numberOfAccount = 0;
		this.branch = b;
	}

	/**
	 * @return the branch
	 */
	public Branch getBranch() {
		return branch;
	}

	/**
	 * @param branch the branch to set
	 */
	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the accounts
	 */
	public Account[] getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	/**
	 * @return the numberOfAccount
	 */
	public int getNumberOfAccount() {
		return numberOfAccount;
	}

	/**
	 * @param numberOfAccount the numberOfAccount to set
	 */
	public void setNumberOfAccount(int numberOfAccount) {
		this.numberOfAccount = numberOfAccount;
	}
	
	
	
	
}
