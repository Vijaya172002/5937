package com.demo.details;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service

public class DetailsService {
	@Autowired
	JdbcTemplate jt;
public int insert(DetailsPojo employee) {
	String loginuname=employee.getLoginuname();
	String loginpassword=employee.getLoginpassword();
	String sql="select * from Emp2 where Username=? and Password=?";
	List<Map<String,Object>> roledata=new ArrayList();
	roledata = jt.queryForList(sql,loginuname,loginpassword);
	String loginrole="";
	for(Map fetchdata:roledata) {
		loginrole=(String)fetchdata.get("role");
	}
	if((loginrole.equals("H"))||loginrole.equals("A")){
		String rolename=employee.getRolename();
		String sql1="select role_id from Role2 where role_name=?";
		List<Map<String,Object>> tabledata=new ArrayList<>();
		tabledata=jt.queryForList(sql1,rolename);
		String emprole="";
		for(Map fetchdata:tabledata) {
			emprole=(String)fetchdata.get("role_id");
		}
		System.out.println(emprole);
		if(emprole!="") {
			String Id=employee.getid();
			String fname=employee.getFname();
			String lname=employee.getLname();
			String email=fname.charAt(0)+lname+"@miraclesoft.com";
			String dob=employee.getDob();
			String dept=employee.getDept();
			String Role=employee.getRole();
			int phoneno=employee.getPhoneno();
			String uname=fname.charAt(0)+lname+dob.substring(0,2)+dob.substring(3,5)+dob.substring(8,10);
			DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HHmm");
			LocalDateTime ldf=LocalDateTime.now();
			String time=dtf.format(ldf);
			String password=fname.charAt(0)+lname+time;
			String joindate=employee.getjoindate();
			String status=employee.getStatus();
			int salary=employee.getSalary();
			String sql2="insert into Emp2 values(?,?,?,?,?,?,?,?,?,?,?,?,?)";    
			return jt.update(sql2,employee.getid(),employee.getFname(),employee.getLname(),email,employee.getDob(),employee.getDept(),emprole,employee.getPhoneno(),uname,password,status,joindate,employee.getSalary());
		}
		
	}
	return 0;
}


}
