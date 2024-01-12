package com.demo.ProjectCopy;

import java.text.SimpleDateFormat;

import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.demo.ProjectCopy.ProjectCopyPojo;

@Service
public class ProjectCopyService {
	@Autowired
	JdbcTemplate jt;                
	String Id,oldprojid,newprojname;
	String description, projstartdate,projenddate,pm,hr,assignedby,projname;
	int totalemp;
	String fname,email,empjoindate,projassigneddate;
	int phoneno=0;
	String message="";
	public String ProjectCopy(ProjectCopyPojo employee){
	
		
			
			String loginuname=employee.getLoginuname();
			String loginpassword=employee.getLoginpassword();
			String sql="select  role,id from Emp2 where Username=? and Password=? and role='A' ";
			
			List<Map<String, Object>> roleData=new ArrayList<Map<String,Object>>();
			roleData=jt.queryForList(sql,loginuname,loginpassword);
			String loginrole="";
			if(!roleData.isEmpty()) {
			for(Map fetchdata:roleData) {
				loginrole=(String)fetchdata.get("role");
				
			}
			if(loginrole.equals("A")) {
			
				oldprojid=employee.getProjid();
				newprojname=employee.getNewProjname();
			//	System.out.println(a.getNewProjName());
				String sql1="select * from ProjectData where Proj_id=? ";
				
				List<Map<String, Object>> ProjectData=new ArrayList<Map<String,Object>>();
				ProjectData=jt.queryForList(sql1,oldprojid);
				
				if(!ProjectData.isEmpty()) {
					for(Map fetchdata:ProjectData) {
						description=(String)fetchdata.get("Description");
						projstartdate=(String)fetchdata.get("Proj_StartDate");
						projenddate=(String)fetchdata.get("Proj_enddate");
						totalemp = (int)fetchdata.get("Total_emp");
						pm=(String)fetchdata.get("PM");
						hr=(String)fetchdata.get("Hr");
						assignedby=loginuname;
					}
					String projid=newprojname.substring(0,4)+projstartdate.substring(0,2);
					String sql2="insert into ProjectData values(?,?,?,?,?,?,?,?,?)";
					int result=jt.update(sql2,projid,newprojname,description,projstartdate,projenddate,totalemp,pm,hr,assignedby);

					String sql3="select * from ProjectEmpContact where Proj_id=? ";
					
					List<Map<String, Object>> roleData2=new ArrayList<Map<String,Object>>();
					roleData2=jt.queryForList(sql3,oldprojid);
					
					for(Map fetchdata:roleData2) {
						fname=(String)fetchdata.get("Fname")+(String)fetchdata.get("Lname");
						email=(String)fetchdata.get("Email");
						phoneno=(int)fetchdata.get("Phoneno");
						empjoindate=(String)fetchdata.get("Emp_JoinDate");
						assignedby = (String)fetchdata.get("AssignedBy");
						Id=(String)fetchdata.get("id");
					}
	            	Date currentDate=new Date();
					SimpleDateFormat dateFormat=new SimpleDateFormat("MM-dd-yyyy");
					String projstartdate=dateFormat.format(currentDate);
					String sql4="insert into ProjectEmpContact values(?,?,?,?,?,?,?,?)";
					jt.update(sql4,Id,fname,email,phoneno,projid,assignedby,empjoindate,projstartdate);
					message="Successfully Project details are inserted";
					
				}else
					message="No Project Found with this project id";
				}else {
					message="Old Project doesnot Exist";
				}
				
			}
			else {
				message="Invalid Username and Password";
			}
			return message;		
	}

}
