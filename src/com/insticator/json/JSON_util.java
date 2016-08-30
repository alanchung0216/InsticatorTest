package com.insticator.json;

import org.json.simple.JSONObject;

import com.insticator.model.Contracter;
import com.insticator.model.Employee;
import com.insticator.model.Fulltime;
import com.insticator.model.Intern;
import com.insticator.model.Parttime;

public class JSON_util {

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

	try {

		FileWriter file = new FileWriter("test.json");
		//file.write(obj.toJSONString());
		file.write(list.toJSONString());
		file.flush();
		file.close();

	} catch (IOException e) {
		e.printStackTrace();
	}

	System.out.print(list);
	System.out.println("\n I am  DONE");
}
*/
}