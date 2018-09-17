package com.example;

import com.example.business.EmployeeStockPlan;
import com.example.domain.Admin;
import com.example.domain.Director;
import com.example.domain.Employee;
import com.example.domain.Engineer;
import com.example.domain.Gender;
import com.example.domain.Manager;

public class EmployeeTest {

	public static void main(String[] args) {
		
		EmployeeStockPlan esp = new EmployeeStockPlan();
		
		Employee e1 = new Engineer(101,"Jane Smith","012-34-5678",120_345.27,"Industry",Gender.FEMALE);
		
		Employee mgr = new Manager(207, "Barbara Johnson", "054-12-2367", 109_501.36, "US Marketing",Gender.FEMALE);
		
		Employee ad1 = new Admin(304, "Bill Munroe", "108-23-6509",75_002.34,"Juridic",Gender.MALE);
		
		Employee d1 = new Director(12,"Susan Wheeler","099-45-2340",120_567.36,"Global Marketing",1_000_000.00,Gender.FEMALE);
		
		System.out.println("\nTEST EMPLOYEE \n");
		
		EmployeeTest.printEmployee(e1,esp);
		EmployeeTest.printEmployee(mgr,esp);
		EmployeeTest.printEmployee(ad1,esp);
		EmployeeTest.printEmployee(d1,esp);		
		
		System.out.println("\nTEST EMPLOYEE 2\n");
		
		mgr.setName("Barbara Dare");
		mgr.raiseSalary(10_500.50);
		d1.setName("Susan Diamond");
		d1.raiseSalary(5_000.45);
		ad1.setName("Bill Crystal");
		ad1.raiseSalary(1_000.00);
		e1.setName("Jane Vette");
		e1.raiseSalary(23_000.90);
		
		EmployeeTest.printEmployee(e1,esp);
		EmployeeTest.printEmployee(mgr,esp);
		EmployeeTest.printEmployee(ad1,esp);
		EmployeeTest.printEmployee(d1,esp);		
		
		System.out.println("\nEND TEST EMPLOYEE \n");
		
		System.out.println("\nINNER CLASS 2\n");
		
		System.out.println(mgr.getName() + "'s bonus: " + mgr.getCalcBonus());
		System.out.println(mgr.getName() + "'s withholding: " + mgr.getCalcWithHolding());
		
		System.out.println("\nEND INNER CLASS 2\n");
		
	}
	
	public static void printEmployee(Employee emp) {
		System.out.print("\nEMPLOYEE TYPE: " + emp.getClass().getSimpleName() + "\n");
		System.out.print(emp);
	}
	
	public static void printEmployee(Employee emp, EmployeeStockPlan esp) {
		EmployeeTest.printEmployee(emp);
		System.out.print("Stock Options: " + esp.grantStock(emp) + "\n");
	}

}