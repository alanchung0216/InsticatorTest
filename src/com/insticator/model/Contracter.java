package com.insticator.model;

public class Contracter extends Employee {
	private long wage;
	private long overtimehours;
	public Contracter() {}
	public Contracter(String fname, String lname, long wage, long overtimehours) {
		super(fname,lname);
		this.wage = wage;
		this.overtimehours = overtimehours;
	}			
	public long getWage() {
		   return wage;
	}
	public void setWage( long wage ) {
		   this.wage = wage;
	}
	public long getOvertimehours() {
		   return overtimehours;
	}
	public void setOvertimehours( long overtimehours ) {
		   this.overtimehours = overtimehours;
	}		
}