package com.demo.ProjectEmpDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProjectEmpDetailsController {
	@Autowired
	ProjectEmpDetailsService ps1;
	@PostMapping("ProjectEmpInsertion")
	public String insert1(@RequestBody ProjectEmpDetailsPojo employee) {
		return ps1.insert1(employee);

	}
}
