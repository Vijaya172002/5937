package com.demo.TaskList;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class InsertService {
	@Autowired
	JdbcTemplate jt;
	String loginuname,loginpassword, loginrole, username, password; 
	int result;
	public String Insert(InsertPojo task) {
		try {
			String loginuname=task.getLoginuname();
			String loginpassword=task.getLoginpassword();
			String sql="select  role,id from Emp2 where Username=? and Password=?";
			
			List<Map<String, Object>> roleData=new ArrayList<Map<String,Object>>();
			roleData=jt.queryForList(sql,loginuname,loginpassword);
			String loginrole="";
			//System.out.print("Hii");

			if(!roleData.isEmpty()) {
				for(Map fetchdata:roleData) {
					loginrole=(String)fetchdata.get("role");
					
				}
				if(loginrole.equals("P")) {
					String projid=task.getProjid();
		         	String taskname=task.getTaskname();
					String taskdescription=task.getTaskdescription();
					String duration=task.getDuration();
					Date currentDate=new Date();
					SimpleDateFormat DateFormat=new SimpleDateFormat("MM-dd-yyyy");
					String Date=DateFormat.format(currentDate);
					String taskid=taskname.substring(0,4)+Date.substring(0,2);
					String taskstatus=task.getTaskstatus();
					//System.out.print("Hii");

				    String sql1="select Proj_id from ProjectEmpContact where AssignedBy=? and Proj_id=?";
				    List<Map<String, Object>> roleData1=new ArrayList();
					roleData1=jt.queryForList(sql1,loginuname,projid);
					String getProjId="";
					for(Map fetchdata:roleData1) {
						getProjId=(String)fetchdata.get("Proj_id");
						if(getProjId.equals(projid)) {
							System.out.print("Hii");
							String sql2="insert into TaskList values(?,?,?,?,?,?,?)";
							result=jt.update(sql2,projid,taskid,taskname,taskdescription,duration,taskstatus,loginuname);
						}
						else {
							return "Invalid project id";
						}
						if(result>0) {
							return "Task Inserted";
						}
						else {
							return "No task inserted";
						}
					}	
				}
				else {
					return "Only Project Manager can access";
				}
			}
			return "You can't have access";
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return "Task already Assigned";
		}
	}
}



