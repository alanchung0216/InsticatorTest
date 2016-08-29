package com.insticator;

public class Contracter extends Employee {
	private long wage;
	private long overtimehours;
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