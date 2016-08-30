package com.insticator.model;

import org.json.simple.JSONObject;

public class Fulltime extends Employee{
	private long salary;
	private long vacation;
	
	public Fulltime() {}
	public Fulltime(String fname, String lname, long salary, long vacation) {
		super(fname,lname);
		this.salary = salary;
		this.vacation = vacation;
	}	
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
/*
obj1.put("type", "emp");
obj1.put("fname", "Deborah");
obj1.put("lname", "Kim");
list.add(obj1);
JSONObject obj2 = new JSONObject();
obj2.put("type", "fulltime");
obj2.put("fname", "Johnny");
obj2.put("lname", "Smith");
obj2.put("vacation", 15);
obj2.put("salary", 80000);
list.add(obj2);
JSONObject obj3 = new JSONObject();
obj3.put("type", "parttime");
obj3.put("fname", "Tom");
obj3.put("lname", "Kite");
obj3.put("salary", 50000);
obj3.put("workhours", 5);
list.add(obj3);	
JSONObject obj4 = new JSONObject();
obj4.put("type", "intern");
obj4.put("fname", "Lisa");
obj4.put("lname", "Clark");
obj4.put("wage", 20);
list.add(obj4);
JSONObject obj5 = new JSONObject();
obj5.put("type", "contracter");
obj5.put("fname", "Doug");
obj5.put("lname", "Hill");
obj5.put("wage", 50);
obj5.put("overtimehours", 9);
list.add(obj5);	
*/
