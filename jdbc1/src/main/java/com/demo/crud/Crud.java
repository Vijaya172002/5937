package com.demo.crud;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Crud {
private int Id; 
private String fname;
private String lname;
private String email;
private int phoneno;
private String branch;
private String dob;
private String username;
private String password;
private int salary;
private String Role;
public int getid() {
	return Id;
}
public void setid(int Id) {
	this.Id=Id;
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
public int getPhoneno() {
	return phoneno;
}
public void setPhoneno(int phoneno) {
	this.phoneno= phoneno;
}

public String getBranch() {
	return branch;
}
public void setBranch(String branch) {
	this.branch = branch;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
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
public String getrole() {
	return Role;
}
public void setrole(String Role) {
	this.Role = Role;
}

}
