package com.example.business;

import com.example.domain.Director;
import com.example.domain.Employee;
import com.example.domain.Manager;

public class EmployeeStockPlan {
	
	private final int employeeShares = 10;
	private final int managerShares = 100;
	private final int directorShares = 1000;
	
	public int grantStock(Employee e) {
		int stock = 0;
		
		if(e instanceof Director) {
			stock = this.directorShares;
		} else if(e instanceof Manager) {
			stock = this.managerShares;
		} else {
			stock = this.employeeShares;
		}
		
		return stock;
	}

}
