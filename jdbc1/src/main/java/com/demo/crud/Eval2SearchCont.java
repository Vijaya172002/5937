package com.demo.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Eval2SearchCont {
	@Autowired
	Eval2SearchServ s1;
	@PostMapping("InsertEval2")
	String insert(@RequestBody Eval2Search data) {
		int b=s1.InsertEval2(data);
		if(b>0) {
			return "Data Inserted";
		}
		else {
			return "Data not Inserted";
		}
		
	}

}
