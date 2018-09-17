package com.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Person {
	private String givenName;
	private String surName;
	private int age;
	private Gender gender;
	private String email;
	private String phone;
	private String address;
	private String city;
	private String state;
	private String code;
	
	public Person() {
		
	}
	
	public static List<Person> createShortList(){
		List<Person> pl = new ArrayList<Person>();
		
		return pl;
	}


	/**
	 * @return the givenName
	 */
	public String getGivenName() {
		return givenName;
	}


	/**
	 * @param givenName the givenName to set
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}


	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}


	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
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


	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}


	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}


	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}


	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}


	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
