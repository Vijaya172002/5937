package com.demo.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class Eval2SearchServ {
@Autowired
JdbcTemplate jt;
public int InsertEval2(Eval2Search data) {
	
	int id=data.getId();
	String name= data.getName();	
	String dept=data.getDept();
	int salary=data.getSalary();
	String work=data.getWork();
	String sql1="insert into student values(?,?,?,?,?)";
	return jt.update(sql1,id,name,dept,salary,work);
}
}
