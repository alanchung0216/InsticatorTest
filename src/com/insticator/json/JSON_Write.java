package com.insticator.json;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.insticator.model.Contracter;
import com.insticator.model.Employee;
import com.insticator.model.Fulltime;
import com.insticator.model.Intern;
import com.insticator.model.Parttime;

public class JSON_Write {
//     public static void main(String[] args) {

//type | first_name | last_name | salary | vacation | workhours | wage | overtimehours
    	 
// create testing employee JSON file
	
    public void writeJSON() {	 
	    JSONArray list = new JSONArray();
	    JSONObject obj1 = new JSONObject();
	    JSON_util cp = new JSON_util();
	    
	    Employee emp = new Employee("Deborah","Kim");
	    //JSONObject copyEmployee(emp);
	    ///obj1.put("type", "emp");
		//obj1.put("fname", "Deborah");
		//obj1.put("lname", "Kim");
		list.add(cp.copyEmployee(emp));
		
		Fulltime ft = new Fulltime("Johnny","Smith",80000, 15);
		
	    //JSONObject obj2 = new JSONObject();
	    //obj2.put("type", "fulltime");
		//obj2.put("fname", "Johnny");
		//obj2.put("lname", "Smith");
		//obj2.put("vacation", 15);
		//obj2.put("salary", 80000);
		list.add(cp.copyFulltime(ft));
		
		Parttime pt = new Parttime("Tom","Kite",50000,5);
	    //JSONObject obj3 = new JSONObject();
	    //obj3.put("type", "parttime");
		//obj3.put("fname", "Tom");
		//obj3.put("lname", "Kite");
		//obj3.put("salary", 50000);
		//obj3.put("workhours", 5);
		list.add(cp.copyParttime(pt));
		
		Intern it = new Intern("Lisa","Clark",20);
	    //JSONObject obj4 = new JSONObject();
	    //obj4.put("type", "intern");
		//obj4.put("fname", "Lisa");
		//obj4.put("lname", "Clark");
		//obj4.put("wage", 20);
		list.add(cp.copyIntern(it));
		
		Contracter ct = new Contracter("Doug","Hill",50, 9);
		//JSONObject obj5 = new JSONObject();
	    //obj5.put("type", "contracter");
		//obj5.put("fname", "Doug");
		//obj5.put("lname", "Hill");
		//obj5.put("wage", 50);
		//obj5.put("overtimehours", 9);
		list.add(cp.copyContracter(ct));	
	
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