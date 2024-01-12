package com.demo.details;

import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan

public class DetailsPojo {
		private String roleid;
		private String rolename;
		private String Id; 
		private String fname;
		private String lname;
		private String email;
		private String dob;
		private String dept;
		private String role;
		private int phoneno;
		private String username;
		private String password;
		private String joindate,status;
		public String getjoindate() {
			return joindate;
		}
		public void setjoindate(String joindate) {
			this.joindate =joindate;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		private int salary;
		private String loginuname,loginpassword,loginRole;
		public String getRoleid() {
			return roleid;
		}
		public void setRoleid(String roleid) {
			this.roleid = roleid;
		}
		public String getRolename() {
			return rolename;
		}
		public void setRolename(String rolename) {
			this.rolename = rolename;
		}
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public int getPhoneno() {
			return phoneno;
		}
		public void setPhoneno(int phoneno) {
			this.phoneno = phoneno;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getSalary() {
			return salary;
		}
		public void setSalary(int salary) {
			this.salary = salary;
		}
		public String getLoginuname() {
			return loginuname;
		}
		public void setLoginuname(String loginuname) {
			this.loginuname = loginuname;
		}
		public String getLoginpassword() {
			return loginpassword;
		}
		public void setLoginpassword(String loginpassword) {
			this.loginpassword = loginpassword;
		}
		public String getLoginRole() {
			return loginRole;
		}
		public void setLoginRole(String loginRole) {
			this.loginRole = loginRole;
		}
		public String getid() {
			return Id;
		}
		public void setid(String Id) {
			this.Id = Id;
		}
	}

