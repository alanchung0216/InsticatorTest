package com.insticator.model;

public class Parttime extends Employee {
	private long salary;
	private long workhours;
	public Parttime() {}
	public Parttime(String fname, String lname, long salary, long workhours) {
		super(fname,lname);
		this.salary = salary;
		this.workhours = workhours;
	}	
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