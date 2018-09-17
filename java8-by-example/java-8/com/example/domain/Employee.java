package com.example.domain;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.example.domain.Gender;

public class Employee implements Comparator{
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */

	private int id;
	private String name;
	private String surName;
	private int age;
	private Gender gender;
	private String email;
	private String phone;
	private String address;
	private String city;
	private String state;
	private String code;
	private String essn;
	private double employeeSalary;
	private BenefitsHelper helper;
	
	private static List<Employee> listPeople = new ArrayList<Employee>();
	private static Employee emp;
	
	public Employee(int empId, String name2, String surName,int age,Gender gender, String email,
			 String phone, String address, String city, String state, String code,String ssn, double salary) {
		this.id = empId;
		this.name = name2;
		this.surName = surName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.code = code;
		this.essn = ssn;
		this.employeeSalary = salary;
		helper = new BenefitsHelper();		
	}

	public Employee(int empId, String name2, String ssn, double salary) {
		this.id = empId;
		this.name = name2;
		this.essn = ssn;
		this.employeeSalary = salary;
		helper = new BenefitsHelper();
		Employee.listPeople.add(this);
		Employee.emp = this;
	}
	
	public Employee(int empId, String name2, String ssn, double salary, Gender gender) {
		this.id = empId;
		this.name = name2;
		this.essn = ssn;
		this.employeeSalary = salary;
		this.gender = gender;
		helper = new BenefitsHelper();
		Employee.listPeople.add(this);
	}	
	
	public static List<Employee> createShortList() {
		return Employee.listPeople;
	}
	
	public void raiseSalary(double inc) {
		if(inc >= 0.0) {
			this.employeeSalary += inc;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "ID: " + this.id + "\n" + 
				"NAME: " + this.name + "\n" + 
				"EMPLOYEE SOCIAL SECURITY NUMBER #: " + this.essn + "\n" +
				"SALARY: " + NumberFormat.getCurrencyInstance().format((double)this.getEmployeeSalary()) + "\n" +
				"GENDER: " + this.getGender() + "\n";
	}
	
	public void printSummary() {
		System.out.println(this);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name != null && !name.equalsIgnoreCase("")) {
			this.name = name;
		}
	}

	public String getEssn() {
		return essn;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
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

	/**
	 * @return the helper
	 */
	public BenefitsHelper getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(BenefitsHelper helper) {
		this.helper = helper;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param essn the essn to set
	 */
	public void setEssn(String essn) {
		this.essn = essn;
	}

	/**
	 * @param employeeSalary the employeeSalary to set
	 */
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public double getCalcBonus() {
		return this.helper.calcBonus(employeeSalary);
	}
	
	public double getCalcWithHolding() {
		return this.helper.calcWithHolding(employeeSalary);
	}
	
	/**
	 * Inner class
	 * @author jnacherf
	 *
	 */
	private class BenefitsHelper{
		private final double bonusRate = 0.02;
		private final double withholdingRate = 0.07;
		
		public double calcBonus(double salary) {
			return salary * bonusRate;
		}
		
		public double calcWithHolding(double salary) {
			return salary * withholdingRate;
		}
	}
	
	public static int sortBySalary(Employee arg0, Employee arg1) {
		int result = 0;
		if(arg0.employeeSalary > arg1.employeeSalary) {
			result = 1;
		} else {
			result = -1;
		}			
		return result;
	}
	
	public static int lowestSalary(Employee arg0, Employee arg1) {
		int result = 0;
		if(arg0.employeeSalary > arg1.employeeSalary) {
			result = 1;
		} else {
			result = -1;
		}			
		return result;
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		long temp;
		temp = Double.doubleToLongBits(employeeSalary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((essn == null) ? 0 : essn.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((helper == null) ? 0 : helper.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null) {
				return false;
			}
		} else if (!address.equals(other.address)) {
			return false;
		}
		if (age != other.age) {
			return false;
		}
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (Double.doubleToLongBits(employeeSalary) != Double.doubleToLongBits(other.employeeSalary)) {
			return false;
		}
		if (essn == null) {
			if (other.essn != null) {
				return false;
			}
		} else if (!essn.equals(other.essn)) {
			return false;
		}
		if (gender != other.gender) {
			return false;
		}
		if (helper == null) {
			if (other.helper != null) {
				return false;
			}
		} else if (!helper.equals(other.helper)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!phone.equals(other.phone)) {
			return false;
		}
		if (state == null) {
			if (other.state != null) {
				return false;
			}
		} else if (!state.equals(other.state)) {
			return false;
		}
		if (surName == null) {
			if (other.surName != null) {
				return false;
			}
		} else if (!surName.equals(other.surName)) {
			return false;
		}
		return true;
	}
	
	
}
