package task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginR")
public class LoginR extends HttpServlet throws Exception {

    
   // public LoginHr() {
     //   super();
        // TODO Auto-generated constructor stub
    //}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			PrintWriter p= response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
			int id=Integer.parseInt(request.getParameter("id"));
			String password=request.getParameter("pass");
			String role=request.getParameter("role");
		    PreparedStatement ps=con.prepareStatement("select * from login where id=?");
		    ps.setInt(1, id);
		    ResultSet rs= ps.executeQuery();
		    if(rs.next()) {
		    	role=rs.getString(3);
		    	if(rs.getInt(1)==id && rs.getString(2).equals(password)) {
		    		if(role.equals("Hr")) {
		    			RequestDispatcher rd=request.getRequestDispatcher("Hr.html");
		    			rd.forward(request, response);
		    		}
		    		else if(role.equals("Trainer")) {
		    			RequestDispatcher rd= request.getRequestDispatcher("Trainer.html");
		    			rd.forward(request, response);
		    		}
		    		else {
				    	RequestDispatcher rd=request.getRequestDispatcher("Trainee.html");
				    	rd.forward(request, response);
		    		}
		    	}
		    
		    else{
		    	RequestDispatcher rd=request.getRequestDispatcher("/Loginr.html");
		    	rd.include(request, response);
		    	p.print("Invalid");
		    }
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


