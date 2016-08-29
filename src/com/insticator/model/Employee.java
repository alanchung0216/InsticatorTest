package com.insticator.model;
/*
Java:
- There are multiple types of employee, include but not limit to full-time, part-time, intern.
- They are paid by year or hour.
- Add other fields you think should exist.
- Create model classes for all the employees.
- Utilize a backend MVC framework, e.g. Spring, Play
*/

public class Employee {

	private int id;
	private String firstName; 
	private String lastName;   
	
	public Employee() {}
	public Employee(String fname, String lname) {
	   this.firstName = fname;
	   this.lastName = lname;
	}
	public int getId() {
	   return id;
	}
	public void setId( int id ) {
	   this.id = id;
	}
	public String getFirstName() {
	   return firstName;
	}
	public void setFirstName( String first_name ) {
	   this.firstName = first_name;
	}
	public String getLastName() {
	   return lastName;
	}
	public void setLastName( String last_name ) {
	   this.lastName = last_name;
	}
}
