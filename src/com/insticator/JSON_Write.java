package com.insticator;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSON_Write {
//     public static void main(String[] args) {

//type | first_name | last_name | salary | vacation | workhours | wage | overtimehours
    	 
// create employee JSON file
	
    public void createJSON() {	 
	    JSONArray list = new JSONArray();
	    JSONObject obj = new JSONObject();
	    obj.put("type", "emp");
		obj.put("fname", "Deb");
		obj.put("lname", "Kim");
		list.add(obj);
	    JSONObject obj1 = new JSONObject();
	    obj1.put("type", "fulltime");
		obj1.put("fname", "John");
		obj1.put("lname", "Smith");
		obj1.put("vacation", 15);
		obj1.put("salary", 80000);
		list.add(obj1);
	    JSONObject obj2 = new JSONObject();
	    obj2.put("type", "partime");
		obj2.put("fname", "Tom");
		obj2.put("lname", "Kite");
		obj2.put("salary", 50000);
		obj2.put("workhours", 5);
		list.add(obj2);	
	    JSONObject obj3 = new JSONObject();
	    obj3.put("type", "intern");
		obj3.put("fname", "Lisa");
		obj3.put("lname", "Clark");
		obj3.put("wage", 20);
		list.add(obj3);
		JSONObject obj4 = new JSONObject();
	    obj4.put("type", "contracter");
		obj4.put("fname", "Doug");
		obj4.put("lname", "Hill");
		obj4.put("wage", 50);
		obj4.put("overtimehours", 9);
		list.add(obj4);	
	
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
}