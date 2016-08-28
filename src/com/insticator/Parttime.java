package com.insticator;

public class Parttime extends Employee {
	private int salary;
	private int workhours;
	public int getSalary() {
		   return salary;
	}
	public void setSalary( int salary ) {
		   this.salary = salary;
	}
	public int getWorkhours() {
		   return workhours;
	}
	public void setWorkhours( int workhours ) {
		   this.workhours = workhours;
	}	
}