package com.insticator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSON_Read {
     public static void main(String[] args) {

	JSONParser parser = new JSONParser();
	/*
    JSONArray list = new JSONArray();
    JSONObject obj = new JSONObject();
    obj.put("type", "emp");
	obj.put("fname", "Deb");
	obj.put("lname", "Kim");
	list.add(obj);
	
	file.write(list.toJSONString());
	*/
	try {

		Object obj = parser.parse(new FileReader("test.json"));
		JSONArray list = (JSONArray) obj;
		// loop array
		//JSONArray msg = (JSONArray) jsonObject.get("messages");
		Iterator<JSONObject> iterator = list.iterator();
		while (iterator.hasNext()) {
			//System.out.println(iterator.next());
			JSONObject jsonObject = (JSONObject) iterator.next();
			String type = (String) jsonObject.get("type");
			System.out.println(type);
		}		

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}

     }

}
