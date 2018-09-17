package com.example.domain;

public class Director extends Manager{

	private double budget;
	
	public Director(int empId, String name, String ssn, double salary, String dept, double budg,Gender gender) {
		super(empId, name, ssn, salary, dept,gender);
		this.budget = budg;
	}

	public double getBudget() {
		return budget;
	}

	/* (non-Javadoc)
	 * @see com.example.domain.Manager#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() +
				"BUDGET: " + this.budget + "\n";
	}
	
}
