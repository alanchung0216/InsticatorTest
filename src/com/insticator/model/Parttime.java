package com.insticator.model;

public class Parttime extends Employee {
	private long salary;
	private long workhours;
	public long getSalary() {
		   return salary;
	}
	public void setSalary( long salary ) {
		   this.salary = salary;
	}
	public long getWorkhours() {
		   return workhours;
	}
	public void setWorkhours( long workhours ) {
		   this.workhours = workhours;
	}	
}