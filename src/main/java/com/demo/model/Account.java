package com.demo.model;

import javax.validation.constraints.*;

public class Account {
	
	@Size(min=3, max=10)
	private String firstName;
	
	@Size(min=3, max=10)
	private String lastName;
	
	@NotNull @Min(15)
	private int age = 15;
	
	@Size(min=3, max=100)
	private String address;
	
	@Email
	private String email;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
