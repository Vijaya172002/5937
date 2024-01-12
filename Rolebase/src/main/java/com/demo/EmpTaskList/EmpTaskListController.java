package com.demo.EmpTaskList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpTaskListController {
	@Autowired
	EmpTaskListService Empserv;
	@PostMapping("insert")
	public String insert(@RequestBody EmpDataPojo data) {
				return Empserv.insert(data);
		}


}
