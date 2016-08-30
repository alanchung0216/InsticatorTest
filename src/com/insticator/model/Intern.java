package com.insticator.model;

public class Intern extends Employee {
	private long wage;
	public Intern() {}
	public Intern(String fname, String lname, long wage) {
		super(fname,lname);
		this.wage = wage;
	}		
	public long getWage() {
		   return wage;
	}
	public void setWage( long wage ) {
		   this.wage = wage;
	}
}