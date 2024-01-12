package com.demo.EmpTaskList;

public class EmpDataPojo {
	private String loginuname;
	private String loginpassword;
	private String Id;
	private String projid;
	private String taskid;
	private String pm;
	private String projstartdate;
	private String projenddate;
	private String status;
	private String taskcreatedby;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getProjid() {
		return projid;
	}
	public void setProjid(String projid) {
		this.projid = projid;
	}
	public String getTaskid() {
		return taskid;
	}
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
	public String getPm() {
		return pm;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
	public String getProjstartdate() {
		return projstartdate;
	}
	public void setProjstartdate(String projstartdate) {
		this.projstartdate = projstartdate;
	}
	public String getProjenddate() {
		return projenddate;
	}
	public void setProjenddate(String projenddate) {
		this.projenddate = projenddate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getTaskcreatedby() {
		return taskcreatedby;
	}
	public void setTaskcreatedby(String taskcreatedby) {
		this.taskcreatedby = taskcreatedby;
	}

}
