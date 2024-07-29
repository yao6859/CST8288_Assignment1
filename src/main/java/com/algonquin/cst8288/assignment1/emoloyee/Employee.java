package com.algonquin.cst8288.assignment1.emoloyee;

/**
 * The Employee class to represents an employee with basic data
 * 
 * @author yao yi
 * Course section: CST8288_033
 * Lab professor: Sazzad Hossain
 */
public class Employee {

        // Attributes
	private String name;
	private String email;
	private String address;
	private double salary;
	private int numberOfServiceYear;
	public double totalCompensation;

        // Default constructor
	public Employee() {
		
	}
        
        // The getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getNumberOfServiceYear() {
		return numberOfServiceYear;
	}

	public void setNumberOfServiceYear(int numberOfServiceYear) {
		this.numberOfServiceYear = numberOfServiceYear;
	}
        
        public double getTotalCompensation() {
            return totalCompensation;
	}  
        
        // Override the toString method
	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", address=" + address + ", salary=" + salary
				+ ", numberOfServiceYear=" + numberOfServiceYear + ", totalCompensation="
				+ totalCompensation + "]";
	}

}