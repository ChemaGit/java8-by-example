package com.exception;

public class Employee {
	private int id;
	private String name;
	private String surname;
	private int age;
	
	public Employee(int id, String name, String surname, int age) {
		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
		this.setAge(age);
	}
	
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "ID: " + this.id + "\n" +
			   "NAME: " + this.name + "\n" +
			   "SURNAME: " + this.surname + "\n" +
			   "AGE: " + this.age;
	}
	
}
