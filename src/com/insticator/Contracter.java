package com.insticator;

public class Contracter extends Employee {
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