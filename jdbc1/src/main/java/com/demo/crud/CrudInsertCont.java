package com.demo.crud;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudInsertCont {
	@Autowired
	CrudInsertServ is;
	@PostMapping("insert2")
	public Map<String,String> insert1(@RequestBody Crud employ1){
		int data=is.insert1(employ1);
		Map<String,String>m=new HashMap<String,String>();
		if(data>0) {
			m.put("Success", "Data inserted");
		}
		else {
			m.put("Failed", "Data not inserted");
		}
		return m;
	}
	@PostMapping("update")
	public Map<String,String> update1(@RequestBody Crud employ1){
		int data=is.update1(employ1);
		Map<String,String>m=new HashMap<String,String>();
		if(data>0) {
			m.put("Success", "Data updated");
		}
		else {
			m.put("Failed", "Data not updated");
		}
		return m;
	}
	@PostMapping("delete")
	public Map<String,String> delete1(@RequestBody Crud employ1){
		int data=is.delete1(employ1);
		Map<String,String>m=new HashMap<String,String>();
		if(data>0) {
			m.put("Success", "Data deleted");
		}
		else {
			m.put("Failed", "Data not deleted");
		}
		return m;
	}
	@PostMapping("select")
	public List select1(@RequestBody Crud employ1) {
		return is.select(employ1);
	}
	@GetMapping("selectAll")
	public List selectAll() {
		return is.selectAll();
	}
	@PostMapping("select2")
	public List select2(@RequestBody Crud employ1) {
		return is.selects(employ1);
	}
}
