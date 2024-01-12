package demo2;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
@WebServlet("/Demo")
public class Demo extends HttpServlet {
	static String username="";
	static String email="";
	static String password="";
	static void usernamegenerate(String first, String last,String dob) {
		String s="";
		for(int i=0;i<dob.length();i++) {
			if(i==4 || i==5) {
				continue;
			}s=s+dob.charAt(i);
		}
		username=first.charAt(0)+last+s;
	}
	static void email(String first,String last) {
		email=first.charAt(0)+last+"@miraclesoft.com";
	}
	static void password(String first,String last) {
		LocalTime pas=java.time.LocalTime.now();
		password=first.substring(0,4)+last.substring(0,4)+pas;
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		//INSERT
		//try {
		//	PrintWriter c=response.getWriter();
		//  String fname=request.getParametfalseer("fname");
		//	String lname=request.getParameter("lname");
		//	String dob=request.getParameter("dob");
		//	String ph=request.getParameter("ph");
		//	String pin=request.getParameter("pin");
		//  String branch=request.getParameter("branch");
		//  String dep=request.getParameter("dep");
		//	String salary=request.getParameter("salary");
		//	usernamegenerate(fname,lname,dob);
		//	email(fname,lname);
		//	password(fname,lname);
		//	Class.forName("com.mysql.cj.jdbc.Driver");
		// con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		// PreparedStatement p=con.prepareStatement("insert into demo2 values(?,?,?,?,?,?,?,?,?,?,?)");
		//	p.setString(1, fname);
		//	p.setString(2, lname);
		//  p.setString(3, ph);
		//	p.setString(4, email);
		//	p.setString(5, pin);
		//	p.setString(6, branch);
		//  p.setString(7, dep);
		//	p.setString(8, username);
		//  p.setString(9, password);
		//	p.setString(10, dob);
		//	p.setString(11, salary);
		//	int s=p.executeUpdate();
		//	c.print("Successfully inserted"+s);
         //   c.close();
		//}
		//catch(Exception e) {
		//	e.printStackTrace();
		//}
	//}
	//UPDATE
		//try {
			//PrintWriter c=response.getWriter();
			//String fname=request.getParameter("fname");
			//String lname=request.getParameter("lname");
			//String fieldname=request.getParameter("fieldname");
			//String fieldvalue=request.getParameter("fieldvalue");
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		//	PreparedStatement p=con.prepareStatement("Update demo2 set "+fieldname+"=? where fname=? and lname=?");
			//p.setString(2, fname);
			//p.setString(3, lname);
			//p.setString(1,fieldvalue);
			//int u=p.executeUpdate();
			//c.print("Updated...!"+u);
			//c.close();
		//}
		//catch(Exception e) {
			
		//}
		//DELETE//
		//try {
			//PrintWriter c=response.getWriter();
			//String fname=request.getParameter("fname");
			//String lname=request.getParameter("lname");
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
			//PreparedStatement p=con.prepareStatement("delete from demo2 where fname=? and lname=?");
			//p.setString(1, fname);
			//p.setString(2, lname);
			//int d=p.executeUpdate();
			//c.print("Deleted...!");
			//c.close();
		//}
		//catch(Exception e) {
			//e.printStackTrace();
		//}

		//SELECT//
		try {
			PrintWriter c=response.getWriter();
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
			PreparedStatement p=con.prepareStatement("select * from demo2 where fname=? and lname=?");
			p.setString(1,  fname);
			p.setString(2, lname);
			ResultSet rs= p.executeQuery();
			ResultSetMetaData rm= rs.getMetaData();
			while(rs.next()) {
				for(int i=1;i<=11;i++) {
					System.out.println(rs.getString(i));
					c.print(rm.getColumnName(i)+" : ");
					c.println(rs.getString(i));
				}
			}
			p.executeUpdate();
			c.print("Successfully");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ////String name=request.getParameter("name");
		////PrintWriter out=response.getWriter();
		////out.print(name);
		doGet(request,response);
	}
}
