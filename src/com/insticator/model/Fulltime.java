package com.insticator.model;

public class Fulltime extends Employee{
	private long salary;
	private long vacation;
	
	public Fulltime() {
		super();
	}
//	public Employee(String fname, String lname) {
//	   this.firstName = fname;
//	   this.lastName = lname;
//	}	
	public long getSalary() {
		   return salary;
	}
	public void setSalary( long salary ) {
		   this.salary = salary;
	}
	public long getVacation() {
		   return vacation;
	}
	public void setVacation( long vacation ) {
		   this.vacation = vacation;
	}	
}