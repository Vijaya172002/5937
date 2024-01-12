package com.demo.details;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("em")
public class DetailsController {
	@Autowired
	DetailsService ds;
		@PostMapping("emp")
		public Map<String,String>insert(@RequestBody DetailsPojo employee){
			Map<String, String> m=new HashMap<String, String>();
			try {
				int sql= ds.insert(employee);
			if(sql>0) {
				m.put("Successful","Data inserted");
			}
			else {
				m.put("Unsuccessful","Data not inserted");
			}
			}
			catch(Exception e) {
				m.put("Exception","incorrected"+e);
			}
			return m;
		}



}
