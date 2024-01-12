package com.demo.TaskList;

import java.util.*;


import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {
	@Autowired
	JdbcTemplate jt;
	String taskdescription,duration,taskstatus,taskname,projid; 
	int result;
	public String Update(InsertPojo task) {
		
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
            		String taskid=task.getTaskid();
            		String sql1= "update TaskList set Task_description=? ,Duration=?, Task_status=? where Task_createdby=?";
            		result=jt.update(sql1,task.getTaskdescription(),task.getDuration(),task.getTaskstatus(),taskid,loginuname);
            		if(result>0) {
            			return "Data Updated Successfully";
            		}
            		else {
            			return "No Data Updated";
            		}
            	
             }
            	else {
            		return "Only Project Manager can have access"; 
            	}
}
			return "Updated";
		}

}
