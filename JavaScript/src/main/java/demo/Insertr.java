package demo;

import java.io.IOException;


import java.io.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("Insertr")
public class Insertr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter pw=response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
			int id=Integer.parseInt(request.getParameter("id"));
			String fname=request.getParameter("fname");
			String email=request.getParameter("email");
            String role=request.getParameter("role");
		
			int salary=Integer.parseInt(request.getParameter("salary"));
			if(role.equals("Hr")) {
				PreparedStatement ps=con.prepareStatement("Insert into loginhr values(?,?,?,?,?)");
				PreparedStatement p=con.prepareStatement("insert into login values(?,?,?)");
				p.setInt(1, id);
				p.setString(2, "M1racle@123");
				p.setString(3, role);
				p.executeUpdate();
				ps.setInt(1, id);
				ps.setString(2, fname);
				ps.setString(3, email);
				ps.setString(4, role);
				ps.setInt(5, salary);
			    ps.executeUpdate();
			    pw.print("HR inserted Details Successfully");
			    
			}
			else {
				if(role.equals("Hr")) {
				    pw.print("You can't enter the Hr details");	
				}
				else {
					PreparedStatement ps=con.prepareStatement("Insert into loginhr values(?,?,?,?,?)");
					PreparedStatement p=con.prepareStatement("insert into login values(?,?,?)");
					p.setInt(1, id);
					p.setString(2, "M1racle@123");
					p.setString(3, role);
					p.executeUpdate();
					ps.setInt(1, id);
					ps.setString(2, fname);
					ps.setString(3, email);
					ps.setString(4, role);
					ps.setInt(5, salary);
				    ps.executeUpdate();
				    pw.print("Trainer inserted Details Successfully");
				 
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
