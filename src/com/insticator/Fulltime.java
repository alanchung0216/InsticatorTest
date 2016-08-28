package com.insticator;

public class Fulltime extends Employee{
	private int salary;
	private int vacation;
	
	public Fulltime() {
		super();
	}
//	public Employee(String fname, String lname) {
//	   this.firstName = fname;
//	   this.lastName = lname;
//	}	
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