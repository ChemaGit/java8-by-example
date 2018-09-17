package com.exception;

import java.util.ArrayList;

public class EmployeeIml {
	private static ArrayList<Employee> pl;
	
	private EmployeeIml() {
		EmployeeIml.pl = new ArrayList<Employee>();
	}
	
	public static ArrayList<Employee>getEmployees() {
		if(EmployeeIml.pl == null) {
			new EmployeeIml();
		}
		return EmployeeIml.pl;
	}
	
	public static void add(Employee e)throws InvalidOperationException{		
		if(EmployeeIml.pl == null) {
			new EmployeeIml();
			EmployeeIml.pl.add(e);
			//System.out.println(e);			
		} else if(EmployeeIml.pl.contains(e)) {
			throw new InvalidOperationException("Error adding employee, employee id already exits " + e.getId());
		} else {
			try {
				EmployeeIml.pl.add(e);
				//System.out.println(e);		
			}catch(IndexOutOfBoundsException aio) {
				throw new InvalidOperationException("Error adding employee, it must be less than " + EmployeeIml.pl.size());
			}
		}			
	}
	
	public static void delete(Employee e) throws InvalidOperationException{
		if(EmployeeIml.pl == null) {
			new EmployeeIml();
			throw new InvalidOperationException("Error deleting employee, no such id: " + e.getId());
		} else if(EmployeeIml.pl.contains(e)) {
			EmployeeIml.pl.remove(e);
		} else {
			throw new InvalidOperationException("Error deleting employee, no such id: " + e.getId());
		}
	}
	
	public static Employee findBy(Employee e) throws InvalidOperationException{
		try {
			return EmployeeIml.pl.get(e.getId());
		}catch(IndexOutOfBoundsException aio){
			throw new InvalidOperationException("Error finding employee: " + e);
		}
	}
}
