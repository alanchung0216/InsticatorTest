package com.insticator.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.insticator.model.Contracter;
import com.insticator.model.Employee;
import com.insticator.model.Fulltime;
import com.insticator.model.Intern;
import com.insticator.model.Parttime;

public class JSON_Read {
	
    public Employee readJSON(String type) {

		JSONParser parser = new JSONParser();

		try {
	
			Object obj = parser.parse(new FileReader("test.json"));
			JSONArray list = (JSONArray) obj;
			// loop array
			Iterator<JSONObject> iterator = list.iterator();
			while (iterator.hasNext()) {
				//System.out.println(iterator.next());
				JSONObject jsonObject = (JSONObject) iterator.next();
				String em_type = (String) jsonObject.get("type");
				if (em_type != null){
					//System.out.println(" em_type "+em_type);
					if ("emp".equals(type) && type.equals(em_type)) {
						Employee em_obj = new Employee();
						em_obj.setFirstName((String) jsonObject.get("fname"));
						em_obj.setLastName((String) jsonObject.get("lname"));
						return em_obj;
					}
					if ("fulltime".equals(type) && type.equals(em_type)) {
						Fulltime em_obj = new Fulltime();
						em_obj.setFirstName((String) jsonObject.get("fname"));
						em_obj.setLastName((String) jsonObject.get("lname"));
						em_obj.setSalary((Long) jsonObject.get("salary"));
						em_obj.setVacation((Long) jsonObject.get("vacation"));
						return em_obj;
					}
					if ("parttime".equals(type) && type.equals(em_type)) {
						Parttime em_obj = new Parttime();
						em_obj.setFirstName((String) jsonObject.get("fname"));
						em_obj.setLastName((String) jsonObject.get("lname"));
						em_obj.setSalary((Long) jsonObject.get("salary"));
						em_obj.setWorkhours((Long) jsonObject.get("workhours"));
						return em_obj;
					}	
					if ("intern".equals(type) && type.equals(em_type)) {
						Intern em_obj = new Intern();
						em_obj.setFirstName((String) jsonObject.get("fname"));
						em_obj.setLastName((String) jsonObject.get("lname"));
						em_obj.setWage((Long) jsonObject.get("wage"));
						return em_obj;
					}	
					if ("contracter".equals(type) && type.equals(em_type)) {
						Contracter em_obj = new Contracter();
						em_obj.setFirstName((String) jsonObject.get("fname"));
						em_obj.setLastName((String) jsonObject.get("lname"));
						em_obj.setWage((Long) jsonObject.get("wage"));
						em_obj.setOvertimehours((Long) jsonObject.get("overtimehours"));
						return em_obj;
					}						
				}
			}		
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	
    }

}
