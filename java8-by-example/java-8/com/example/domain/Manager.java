package com.example.domain;

public class Manager extends Employee{
	private String deptName;

	public Manager(int empId, String name, String ssn, double salary, String dept, Gender gender) {
		super(empId,name,ssn,salary,gender);
		this.deptName = dept;		
	}
	
	public String getDeptName() {
		return deptName;
	}

	/* (non-Javadoc)
	 * @see com.example.domain.Employee#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() +
				 "DEPARTMENT: " + this.deptName + "\n";
	}
	
	

}
