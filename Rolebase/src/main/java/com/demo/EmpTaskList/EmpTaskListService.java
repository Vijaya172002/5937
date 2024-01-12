package com.demo.EmpTaskList;

import java.util.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmpTaskListService {
	@Autowired
	JdbcTemplate jt;
	String projid,status;
	int result;
	public String insert(EmpDataPojo data) {
		String loginuname=data.getLoginuname();
		String loginpassword=data.getLoginpassword();
		String sql="select  role,id from Emp2 where Username=? and Password=?";
		
		List<Map<String,Object>> roleData=new ArrayList<Map<String,Object>>();
		roleData=jt.queryForList(sql,loginuname,loginpassword);
		String loginrole="";
		
		if(!roleData.isEmpty()) {
			for(Map fetchdata:roleData) {
				loginrole=(String)fetchdata.get("role");	
			}
			if(loginrole.equals("P")) {
				String taskid=data.getTaskid();
				String id=data.getId();
				String projstartdate=data.getProjstartdate();
				String projenddate=data.getProjenddate();
				String status="A";
				String sql1="select * from TaskList where Task_id=?";
				List<Map<String, Object>> roleData1=new ArrayList<Map<String,Object>>();
				roleData1=jt.queryForList(sql1,taskid);
				for(Map fetchdata:roleData1) {
					projid=(String)fetchdata.get("Proj_id");
					String taskcreatedby = (String)fetchdata.get("loginuname");
				}
				if(roleData1.isEmpty()) {
					return "Failed, Invalid task id";
				}
				else {
				String sql2="select id from ProjectEmpContact where Proj_id=? and id=?";
				List<Map<String, Object>> idData=new ArrayList<Map<String,Object>>();
				idData=jt.queryForList(sql2,projid,id);
				
				if(idData.isEmpty()) {
					return "Failed, Invalid id";
				}else {
				String sql3="insert into EmpTaskList values(?,?,?,?,?,?,?)";
				result= jt.update(sql3,id,projid,taskid,loginuname,projstartdate,projenddate,status);
				String sql4="update TaskList set Task_status=? where Task_id=?";
				jt.update(sql4,status,taskid);
				if(result>0) {
					return "Data Inserted Successfully";
				}
				else {
					return "No Data Inserted";
				}
				}
			}
			}
			else {
				return "Failed, Project Manager not assigned to that project";
			}
		}
		else {
			return "Invalid Username or Password";
		}	
	}
}
