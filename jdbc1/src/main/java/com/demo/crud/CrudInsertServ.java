package com.demo.crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CrudInsertServ {
	@Autowired
	JdbcTemplate jt;
	
	public int insert1(Crud employ1) {
		int Id=employ1.getid();
		String fname=employ1.getFname();
		String lname=employ1.getLname();
		String email=employ1.getFname().charAt(0)+employ1.getLname()+"@miraclesoft.com";
		int phoneno=employ1.getPhoneno();
		String branch=employ1.getBranch();
		String dob=employ1.getDob();
		String uname=employ1.getFname().charAt(0)+employ1.getLname();
		String pswd=employ1.getFname().substring(0,4)+employ1.getLname().substring(0,4);
		int salary=employ1.getSalary();
		String Role=employ1.getrole();
		String sql="insert into Emp1 values(?,?,?,?,?,?,?,?,?,?,?)";
		return jt.update(sql,Id,fname,lname,email,phoneno,branch,dob,uname,pswd,salary,Role);
	}
	public int update1(Crud employ1) {
		String sql="update Emp1 set Salary=? where Username=?";
		return jt.update(sql,employ1.getSalary(),employ1.getUsername());
	}
	public int delete1(Crud employ1) {
		String sql="delete from Emp1 where Username=?";
		return jt.update(sql,employ1.getUsername());
	}
	public List select(Crud employ1) {
		String sql="select * from Emp1 where Fname=?";
		List getData =new ArrayList<>();
		List<Map<String,Object>> tabledata=new ArrayList<Map<String,Object>>();
		tabledata=jt.queryForList(sql,employ1.getFname());
		Map mapdata;
		for(Map fetchdata: tabledata) {
			mapdata=new HashMap<String,Object>();
			mapdata.put("Id",fetchdata.get("id"));
			mapdata.put("fname",fetchdata.get("Fname"));
			mapdata.put("lname",fetchdata.get("Lname"));
			mapdata.put("email",fetchdata.get("Email"));
			mapdata.put("phoneno", fetchdata.get("Phoneno"));
			mapdata.put("branch",fetchdata.get("Branch"));
			mapdata.put("dob",fetchdata.get("Dob"));
			mapdata.put("username",fetchdata.get("Username"));
			mapdata.put("password",fetchdata.get("Password"));
			mapdata.put("salary",fetchdata.get("Salary"));
			mapdata.put("Role",fetchdata.get("role"));
            getData.add(mapdata);
		}
		return getData;
	}
	public List selectAll() {
		String sql="select * from Emp1";
		List getData =new ArrayList<>();
		List<Map<String,Object>> tabledata=new ArrayList<Map<String,Object>>();
		tabledata=jt.queryForList(sql);
		Map mapdata;
		for(Map fetchdata: tabledata) {
			mapdata=new HashMap<String,Object>();
			mapdata.put("Id",fetchdata.get("id"));
			mapdata.put("fname",fetchdata.get("Fname"));
			mapdata.put("lname",fetchdata.get("Lname"));
			mapdata.put("email",fetchdata.get("Email"));
			mapdata.put("phoneno",fetchdata.get("Phoneno"));
			mapdata.put("branch",fetchdata.get("Branch"));
			mapdata.put("dob",fetchdata.get("Dob"));
			mapdata.put("username",fetchdata.get("Username"));
			mapdata.put("password",fetchdata.get("Password"));
			mapdata.put("salary",fetchdata.get("Salary"));
			mapdata.put("Role",fetchdata.get("role"));

            getData.add(mapdata);
		}
		return getData;
	}
public List selects(Crud employ1) {
	String uname=employ1.getUsername();
	String email=employ1.getEmail();
	int phoneno=employ1.getPhoneno();
	String s="";
	String sql="select * from Emp1 where 2+3=5";
	if(uname!=null) {
		sql=sql+" and Username like '"+uname+"%'";
	}
	if(email!=null) {
		sql=sql+" and Email like '"+email+"%'";
	}
	if(phoneno != 0) {
		sql=sql+" and Phoneno like '"+phoneno+"%'";
	}
	List getData=new ArrayList<>();
	List<Map<String,Object>> tabledata=new ArrayList<Map<String,Object>>();
	tabledata=jt.queryForList(sql);
	Map mapdata;
	for(Map fetchdata:tabledata) {
		mapdata=new HashMap<String,Object>();
		mapdata.put("Id",fetchdata.get("id"));
		mapdata.put("fname",fetchdata.get("Fname"));
		mapdata.put("lname",fetchdata.get("Lname"));
		mapdata.put("email",fetchdata.get("Email"));
		mapdata.put("phoneno",fetchdata.get("Phoneno"));
		mapdata.put("branch",fetchdata.get("Branch"));
		mapdata.put("dob",fetchdata.get("Dob"));
		mapdata.put("username",fetchdata.get("Username"));
		mapdata.put("password",fetchdata.get("Password"));
		mapdata.put("salary",fetchdata.get("Salary"));
		mapdata.put("Role",fetchdata.get("role"));

        getData.add(mapdata);

	}
	return getData;
}

}
