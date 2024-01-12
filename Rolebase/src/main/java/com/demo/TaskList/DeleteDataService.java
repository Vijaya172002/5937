 package com.demo.TaskList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DeleteDataService {
	@Autowired
	JdbcTemplate jt;
	int result;
	public String DeleteData(InsertPojo task) {
		String loginuname=task.getLoginuname();
		String loginpassword=task.getLoginpassword();
		String sql="select  role,id from Emp2 where Username=? and Password=?";

		List<Map<String, Object>> roleData=new ArrayList<Map<String,Object>>();
		roleData=jt.queryForList(sql,loginuname,loginpassword);
    	String loginrole="";
    	if(!roleData.isEmpty()) {
    	for(Map fetchdata:roleData) {
    		loginrole=(String)fetchdata.get("role");
    	}
    	if(loginrole.equals("P")) {
    		String id="";
    		String sql1="select Task_id from TaskList where Task_createdby=?";
    		List<Map<String, Object>> idData=new ArrayList<Map<String,Object>>();
    	    idData=jt.queryForList(sql1,loginuname);
    	    	for(Map fetchdata:idData) {
    	    		id=(String)fetchdata.get("Task_id");
    	    	}
    	    	String taskid=task.getTaskid();
    	    	if(taskid.equals(id)) {
    	    		String sql2="delete from TaskList where Task_id=?";
    	    		result=jt.update(sql2,taskid);
    	    	}
    	    	else {
    	    		return "You don't have an access to Delete the Task";
    	    	}
    	    	if(result>0) {
    	    		return "Deleted Successfully";
    	    	}
    	    	else {
    	    		return "No Data Deleted";
    	    	}
    	}
    	else {
    		return "Only Project Manager can Access";
    	}
    	
    }
    	else {
    		return "Enter a valid Username and Password";
    	}
	
	}

}
