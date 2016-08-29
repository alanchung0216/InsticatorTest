package com.insticator;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSON_Write {
//     public static void main(String[] args) {

//type | first_name | last_name | salary | vacation | workhours | wage | overtimehours
    	 
// create employee JSON file
	
    public void writeJSON() {	 
	    JSONArray list = new JSONArray();
	    JSONObject obj1 = new JSONObject();
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
}