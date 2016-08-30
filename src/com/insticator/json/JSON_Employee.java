package com.insticator.json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.insticator.model.*;

public class JSON_Employee {
//     public static void main(String[] args) {

//type | first_name | last_name | salary | vacation | workhours | wage | overtimehours
    	 
// create employee JSON file
	
    public void employeeJSON(List<Employee> employees) {	
    	JSONArray list = new JSONArray();
    	for (int i=0; i < employees.size(); i++){
    		JSONObject obj = new JSONObject();
    		Employee employee = employees.get(i);
    		JSON_util cp = new JSON_util();
            if (employee instanceof Fulltime){
	           	 Fulltime ft = (Fulltime) employee;
	           	 list.add(cp.copyFulltime(ft));
            } else if (employee instanceof Parttime){
	           	 Parttime pt = (Parttime) employee;
	           	 list.add(cp.copyParttime(pt));
            } else if (employee instanceof Intern) {
	           	 Intern it = (Intern) employee;
	           	 list.add(cp.copyIntern(it));
            } else if (employee instanceof Contracter) {
	           	 Contracter ct = (Contracter) employee;
	           	 list.add(cp.copyContracter(ct));
            } else {
            	 list.add(cp.copyEmployee(employee));
            }     		
    	}
		try {
			
			FileWriter file = new FileWriter("employees.json");
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