package com.demo.ProjectDetails;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.demo.ProjectDetails.ProjectDetailsPojo;

@Service
public class ProjectDetailsService {
	@Autowired
	JdbcTemplate jt;
	
	public String insert(ProjectDetailsPojo employee) {
		String loginuname=employee.getLoginuname();
		String loginpassword=employee.getLoginpassword();
		String sql="Select role from Emp2 where username=? and password=? ";
		String result="";
		List<Map<String,Object>> tabledata=new ArrayList();
		tabledata=jt.queryForList(sql,loginuname,loginpassword);
		String loginrole="";
		if(!tabledata.isEmpty()) {                       //to check the username and password and to get invalid message if username is incorrect
		for(Map fetchdata:tabledata) {                   //tabledata is to get the role data...we fetch role into loginrole
			loginrole=(String)fetchdata.get("role");
		}
		if(loginrole.equals("A")) {			
			String pm=employee.getPm();
			String hr=employee.getHr();
			
			//Project Manager role
            String sql1="select role from Emp2 where Username=? and role='P' ";            //project manager username
            List<Map<String,Object>> roledata1=new ArrayList();
            roledata1=jt.queryForList(sql1,pm);
            String pmrole="";
           // String pmStatus="";
            if(!roledata1.isEmpty()) {                                     //to get a invalid message if project manager username is incorrect 
            for(Map fetchdata:roledata1) {
            	pmrole=(String)fetchdata.get("role");
            }
            
            //Hr Manager role
            String sql2="select role,Status from Emp2 where Username=? and role='H'";               //hr manager username
            List<Map<String,Object>> roledata2=new ArrayList();
            roledata2=jt.queryForList(sql2,hr);
            String hrrole="";
           // String hrStatus="";
            if(!roledata2.isEmpty()) {
            for(Map fetchdata:roledata2) {
            	hrrole=(String)fetchdata.get("role");

            }
                if(pmrole.equals("P") && hrrole.equals("H")) {
                	try {
            	String projname=employee.getProjname();
            	Date currentDate=new Date();
    			SimpleDateFormat DateFormat=new SimpleDateFormat("MM-dd-yyyy");
    			String projstartdate=DateFormat.format(currentDate);
    			String projid=projname.substring(0,4)+projstartdate.substring(0,2);

                String description=employee.getDescription();
    			String projenddate=employee.getProjenddate();
    			String totalemp=employee.getTotalemp();
    			String assignedby=employee.getAssignedby();    		    
    			String sql4="insert into ProjectData values(?,?,?,?,?,?,?,?,?)";

    			jt.update(sql4,projid,projname,description,projstartdate,projenddate,totalemp,employee.getPm(),employee.getHr(),employee.getAssignedby());
    			result="Inserted Successfully ";
            
                }catch(Exception e) {
                	result="DUPLICATE ENTRY.IT IS ALREADY ASSIGNED"+e;
                }
                }
                }else {
                	result="Invalid Hr username";
                }
            }   
            else {
                	result="Invalid Project Manager Username";
                }
            }else {
            	result="You didn't have an access to insert data ";
            }
		}
		else {
			result="Invalid username or password";
		}
		return result;
	}
}
