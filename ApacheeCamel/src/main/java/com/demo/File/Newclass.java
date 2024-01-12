package com.demo.File;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Newclass extends RouteBuilder{
	/*
	 * @Autowired private Tharun obj;
	 */
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("file:files/input")
	//	.transform().constant("time is"+LocalDateTime.now())
		//.bean("tharun")
		.log("${body}")
		.to("file:files/output");
	}
	
}
/*
 * @Component class Tharun{ public String time() { return
 * "time is"+LocalDateTime.now(); } }
 */
