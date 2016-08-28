package com.insticator;
/*
Java:
- There are multiple types of employee, include but not limit to full-time, part-time, intern.
- They are paid by year or hour.
- Add other fields you think should exist.
- Create model classes for all the employees.
- Utilize a backend MVC framework, e.g. Spring, Play
*/
class Full_time extends Employee{
	private int salary;
	private int vacation;
	public int getSalary() {
		   return salary;
	}
	public void setSalary( int salary ) {
		   this.salary = salary;
	}
	public int getVacation() {
		   return vacation;
	}
	public void setVacation( int vacation ) {
		   this.vacation = vacation;
	}	
}
class Part_time extends Employee {
	private int wage;
	private int workhours;
	public int getWage() {
		   return wage;
	}
	public void setWage( int wage ) {
		   this.wage = wage;
	}
	public int getWorkhours() {
		   return workhours;
	}
	public void setWorkhours( int workhours ) {
		   this.workhours = workhours;
	}	
}
class Intern extends Employee {
	private int wage;
	public int getWage() {
		   return wage;
	}
	public void setWage( int wage ) {
		   this.wage = wage;
	}
}
class Contracter extends Employee {
	private int wage;
	private int overtimehours;
	public int getWage() {
		   return wage;
	}
	public void setWage( int wage ) {
		   this.wage = wage;
	}
	public int getOvertimehours() {
		   return overtimehours;
	}
	public void setOvertimehours( int overtimehours ) {
		   this.overtimehours = overtimehours;
	}		
}
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
