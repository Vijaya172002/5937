package com.demo.crud;
import java.util.*;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class InsertController {
	@Autowired
	InsertService is;
	@PostMapping("Insert-i")
	public Map<String,String> insert(@RequestBody Insert students){
		int data=is.insert(students);
		Map<String,String> m=new HashMap<String,String>();
		if(data>0) {
			m.put("Success", "Data is inserted");
		}
		else {
			m.put("Failed", "Data not inserted");
		}
		return m;
	}
	
	//Another way
	@Autowired
	InsertService is1;         //is1 is an object of InsertService
	@PostMapping("Insert1-i")
	public Map<String,String> insert1(@RequestBody Insert students){
		int data=is1.insert1(students);
		Map<String,String> m=new HashMap<String,String>();
		if(data>0) {
			m.put("Successfully", "Data inserted");                     //m.put(keys,values);
		}
		else {
			m.put("Failed", "Data is not inserted");
		}
		return m;
	}

}
