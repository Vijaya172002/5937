package com.demo.ProjectMeet;

import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class ProjMeetService {
	@Autowired
	JdbcTemplate jt;
	@Autowired
	JavaMailSender jms;
	@Value("${spring.mail.username}")
	String endtime,date;
	static String sender; 
	static String receiver;
	public String InsertM(ProjMeetPojo data) {
		String message="";
		try {
			String loginuname = data.getLoginuname();
			String loginpassword = data.getLoginpassword();
			String sql = "select role,id from Emp2 where Username=? and Password=?";

			List<Map<String,Object>> getrole = new ArrayList();
			getrole = jt.queryForList(sql,loginuname,loginpassword);
			String loginrole="";
			for(Map fetchdata : getrole) {
				loginrole=(String)fetchdata.get("Role");
			}
			if(loginrole.equals("P")||loginrole.equals("H")) {
				String meetname = data.getMeetname();
				String meetcontact = data.getMeetcontact();
				String[] contacts = meetcontact.split(",");
					Date presentdate = new Date();
					SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/YYYY");
					date = dateformat.format(presentdate);
				String projid = data.getProjid();
				String meetid = projid.substring(0,4)+date.substring(3,5);
				String starttime = data.getStarttime();
				String meetingdescription = data.getMeetingdescription();
				int duration = data.getDuration();
				DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");
				if(starttime==null||starttime=="") {
					LocalDateTime now = LocalDateTime.now();
					starttime = time.format(now);
				}
					LocalTime start = LocalTime.parse(starttime,time);
					LocalTime end = start.plusMinutes(duration);

					endtime = time.format(end);
				String CEmployee ="",WEmployee ="";                                   //CEmployee--correct employee, WEmployee--wrong employee
				String sql1 ="select id from ProjectEmpContact where Proj_id=? and AssignedBy=?";
				List l = new ArrayList();
				List<Map<String,Object>> m = jt.queryForList(sql1,projid,loginuname);
				for(Map emp:m) {
					l.add(emp.get("id"));
				}
				for(String employ:contacts) {
					if(l.contains(employ)) {
						CEmployee=CEmployee+""+employ+",";
					}
					else {
						WEmployee=WEmployee+""+employ+",";
					}
				}
				if(CEmployee.length()>0) {
					String sql2 = "insert into ProjectMeet values(?,?,?,?,?,?,?,?,?,?,?)";
					int i = jt.update(sql2,meetid,meetname,CEmployee,projid,starttime,endtime,duration,
							date,loginuname,"C",meetingdescription);
					if(i>0) {
						String Email[]=CEmployee.split(",");
						for(String email:Email) {
							String id=email;
							String sqlemail="select email from Emp2 where id=?";
							List<Map<String,Object>> empemail=jt.queryForList(sqlemail,id);
							for(Map fetchemail: empemail) {
								receiver=(String)fetchemail.get("email");
								
							}
							SimpleMailMessage mail=new SimpleMailMessage();
							mail.setFrom("vijayabattula2002@gmail.com");
							mail.setTo(receiver);
							mail.setText("Hello...Welcome to Team Meeting");
							jms.send(mail);
						}
						return "Mail Send Successfully...";
					}
					else {
						return "No data inserted";
					}
				}
				else {
					return ""+WEmployee+"are not belong to this project";
				}
			}
			else {
				return "Only Project Manager and HR have access to it";
			}
		}
		catch(Exception e) {
			return "Duplicate Values"+e;
		}
	}
} 



//@Service
//public class ProjMeetService {
//	@Autowired
//	JdbcTemplate jt;
//	int result;
//
//	public String InsertM(ProjMeetPojo data) {
//	try {
//	String loginuname=data.getLoginuname();
//	String loginpassword=data.getLoginpassword();
//		String sql="select  role,id from Emp2 where Username=? and Password=?";
//		
//		List<Map<String,Object>> roleData=new ArrayList<Map<String,Object>>();
//		roleData=jt.queryForList(sql,loginuname,loginpassword);
//		String loginrole="";
//		
//		if(!roleData.isEmpty()) {
//			for(Map fetchdata:roleData) {
//				loginrole=(String)fetchdata.get("role");	
//			}
//			if(loginrole.equals("P")|| loginrole.equals("H")) {
//				String meetname=data.getMeetname();
//
//
//				String meetcontact=data.getMeetcontact();
//				String[] contacts = meetcontact.split(",");
//
//				Date date=new Date();
//				SimpleDateFormat dateformat=new SimpleDateFormat("dd/MM/yyyy");
//				String Date=dateformat.format(date);
//				dateformat=new SimpleDateFormat("HH:mm");
//				
//				String starttime=dateformat.format(date);
//				int duration=data.getDuration();
//				Calendar Current_time=Calendar.getInstance();
//				Current_time.add(Calendar.MINUTE, duration);
//				SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
//				
//				String endtime=sdf.format(Current_time.getTime());
//				String meetingdescription = data.getMeetingdescription();
//				String meetid = meetname.substring(0,4)+Date.substring(3,5);
//
//				String projid=data.getProjid();
//				String sql1 ="select id from ProjectEmpContact where Proj_id=? and AssignedBy=?";
//				List<Map<String,Object>> roleData1=new ArrayList<Map<String,Object>>();
//				roleData1=jt.queryForList(sql1,projid,loginuname);
//				
//				String sql2 = "insert into ProjectMeet values(?,?,?,?,?,?,?,?,?,?,?)";
//				int i = jt.update(sql2,meetid,meetname,meetcontact,projid,starttime,endtime,duration,
//					date,loginuname,"C",meetingdescription);
//			
//
//			}
//			else {
//				return "Only Project Manager have access to it";
//			}
//			}
//		return "Inserted";
//		}
//		catch(Exception e) {
//			return "Duplicate values"+e;
//		}
//	}
//}
