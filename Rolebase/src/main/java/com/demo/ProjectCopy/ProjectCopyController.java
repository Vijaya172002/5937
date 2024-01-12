package com.demo.ProjectCopy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProjectCopyController {
	@Autowired
	ProjectCopyService pcs;
	
	@PostMapping("Proj_Copy")
	public String ProjectCopy1(@RequestBody ProjectCopyPojo employee) {
		System.out.println(employee.getNewProjname());
		return pcs.ProjectCopy(employee);
	}


}
