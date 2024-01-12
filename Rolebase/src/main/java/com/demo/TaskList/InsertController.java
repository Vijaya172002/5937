package com.demo.TaskList;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsertController {
	@Autowired
	InsertService insserv;
	@PostMapping("Insert")
	public String Insert(@RequestBody InsertPojo task) {
			return insserv.Insert(task);
	}

	@Autowired
	UpdateService updserv;
	@PostMapping("Update")
	public String Update(@RequestBody InsertPojo task) {
			return updserv.Update(task);
	}
	
	@Autowired
	DeleteDataService delserv;
	@PostMapping("DeleteData")
	public String DeleteData(@RequestBody InsertPojo task) {
			return delserv.DeleteData(task);
	}
	@Autowired
	SelectDataService selserv;
	@PostMapping("SelectData")
	public List SelectData(@RequestBody InsertPojo task) {
			return selserv.SelectData(task);
	}
}

