package com.demo.Project;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class ProjectCont{
	@Autowired
	ProjectCopyingServ pcs;
	@Autowired
	ProjectService ps;
	@PostMapping("insertion45")
	public String insert(@RequestBody Project employee) {
		return ps.insert(employee);
	}
@Autowired
ProjectEmpServ ps1;
@PostMapping("ins121")
public String inst(@RequestBody Project employee) {
	return ps1.inst(employee);
}
@PostMapping("Proj_Copy")
public String ProjectCopy1(@RequestBody Project employee) {
	System.out.println(employee.getNewProjname());
	return pcs.ProjectCopy(employee);
}
}
