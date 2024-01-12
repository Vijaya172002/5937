package com.demo.crud;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class InsertService {
	@Autowired
	JdbcTemplate js;
	public int insert(Insert students) {
		int id=students.getId();
		String name=students.getName();
		String dept=students.getDept();
		String sql="insert into stud value(?,?,?)";
		return js.update(sql,id,name,dept);
	}
	@Autowired
	NamedParameterJdbcTemplate js1;
	public int insert1(Insert students) {
	    SqlParameterSource param=new MapSqlParameterSource().addValue("id",students.getId())
	    		.addValue("name",students.getName()).addValue("dept",students.getDept());
	    String sql="insert into stud value(:id,:name,:dept)";
		return js1.update(sql,param);
	}

}
