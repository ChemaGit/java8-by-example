package com.exception;

import java.util.ArrayList;

public class EmployeeTest {

	public static void main(String[] args) throws InvalidOperationException{
		Employee e = new Employee(1,"Jose","Nacher",47);
		EmployeeIml.add(e);
		Employee e1 = new Employee(2,"Laura","Lion",24);
		EmployeeIml.add(e1);
		
		
		
		//EmployeeIml.add(e);
		Employee e2 = new Employee(3,"Victoria","Givens",47);
		EmployeeIml.add(e2);
		//EmployeeIml.delete(e3);
		
		ArrayList<Employee>pl = EmployeeIml.getEmployees();
		for(Employee emp : pl) {
			System.out.println(emp);
		}
		
		Employee e3 = new Employee(4,"Milton","Twins",22); 
		EmployeeIml.findBy(e3);
	}

}
