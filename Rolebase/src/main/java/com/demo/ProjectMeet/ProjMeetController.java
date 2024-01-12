package com.demo.ProjectMeet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjMeetController {
	@Autowired
	ProjMeetService meetserv;
		@PostMapping("InsertM")
		public String InsertM(@RequestBody ProjMeetPojo data) {
					return meetserv.InsertM(data);
		}
}

