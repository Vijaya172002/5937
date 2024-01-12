package com.demo.TaskList;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class SelectDataService {
	@Autowired
	JdbcTemplate jt;
	List ls;
	public List SelectData(InsertPojo task) {
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
			String taskstatus=task.getTaskstatus();
			String duration=task.getDuration();
    		String taskid=task.getTaskid();
    		
    		String sql1="select * from TaskList where 1+1=2";
    			if(taskstatus!=null) {
    	    		sql1=sql1+" and Task_status like '"+taskstatus+"%'";
    	    	}
    			if(duration!=null) {
    	    		sql1=sql1+" and Duration like '"+duration+"%'";
    	    	}
    			if(taskid!=null) {
    	    		sql1=sql1+" and Task_id like '"+taskid+"%'";
    	    	}
    			ls=new ArrayList();
    			List<Map<String, Object>> getData=new ArrayList();
    			getData=jt.queryForList(sql1);
    	    	ls.add(getData);
    	    	
    	}
    	}
		return ls;
		}
	
}
