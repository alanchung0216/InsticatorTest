package com.insticator.json;

import org.json.simple.JSONObject;

import com.insticator.model.Contracter;
import com.insticator.model.Employee;
import com.insticator.model.Fulltime;
import com.insticator.model.Intern;
import com.insticator.model.Parttime;

public class JSON_Util {

	JSONObject copyEmployee(Employee emp){
		JSONObject obj = new JSONObject();
		obj.put("type", "emp");
		obj.put("fname", emp.getFirstName());
		obj.put("lname", emp.getLastName());		
		return obj;		
	}
	JSONObject copyFulltime(Fulltime ft){
	    JSONObject obj = new JSONObject();
		obj.put("type", "fulltime");
		obj.put("fname", ft.getFirstName());
		obj.put("lname", ft.getLastName());
		obj.put("salary", ft.getSalary());		
		obj.put("vacation", ft.getVacation());
		return obj;		
	}
	JSONObject copyParttime(Parttime pt){
	    JSONObject obj = new JSONObject();
		obj.put("type", "parttime");
		obj.put("fname", pt.getFirstName());
		obj.put("lname", pt.getLastName());
		obj.put("salary", pt.getSalary());		
		obj.put("workhours", pt.getWorkhours());
		return obj;				
	}
	JSONObject copyIntern(Intern it){
	    JSONObject obj = new JSONObject();
		obj.put("type", "intern");
		obj.put("fname", it.getFirstName());
		obj.put("lname", it.getLastName());
		obj.put("wage", it.getWage());		
		return obj;
	}
	JSONObject copyContracter(Contracter ct){
	    JSONObject obj = new JSONObject();
		obj.put("type", "contracter");
		obj.put("fname", ct.getFirstName());
		obj.put("lname", ct.getLastName());
		obj.put("wage", ct.getWage());		
		obj.put("overtimehours", ct.getOvertimehours());
		return obj;		
	}
}