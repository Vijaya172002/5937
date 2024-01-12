package com.demo.crud.Role;

import java.util.HashMap;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudRoleCont {
	@Autowired
	CrudRoleService cs;
	@PostMapping("Emp2")
	public Map<String,String>insert(@RequestBody CrudRole employee){
		Map<String, String> m=new HashMap<String, String>();
		try {
			int sql= cs.insert(employee);
		if(sql>0) {
			m.put("Successful","Data inserted");
		}
		else {
			m.put("Unsuccessful","Data not inserted");
		}
		}
		catch(Exception e) {
			m.put("Exception","incorrected"+e);
		}
		return m;
	}

}
