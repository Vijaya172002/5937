package com.demo.ProjectDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.ProjectDetails.ProjectDetailsPojo;

import com.demo.ProjectDetails.ProjectDetailsService;

@RestController
public class ProjectDetailsController {
	@Autowired
	ProjectDetailsService ps;
	@PostMapping("ProjectInsertion")
	public String insert(@RequestBody ProjectDetailsPojo employee) {
		return ps.insert(employee);
	
	}
}
