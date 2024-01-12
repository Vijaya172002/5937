package demo2;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/Selectr")
public class Selectr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter pw=response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
			int id=Integer.parseInt(request.getParameter("id"));
		    PreparedStatement ps1=con.prepareStatement("Select * from login where id=?");
			ps1.setInt(1, id);
			ResultSet rs1= ps1.executeQuery();
			if(rs1.next()) {
				String role=rs1.getString(3);
			if(Loginr.role.equals("Hr")) {
				PreparedStatement ps=con.prepareStatement("select * from loginhr where id=?");
				ps.setInt(1, id);
				ResultSet rs= ps.executeQuery();
				ResultSetMetaData rm=rs.getMetaData();
				RequestDispatcher rd=request.getRequestDispatcher("HR.html");
				rd.include(request, response);
				if(rs.next()) {
					for(int i=1;i<=10;i++) {
						pw.print(rm.getColumnName(i)+" : ");
						pw.println(rs.getString(i));
						pw.println("\n");
					}
				}
			}
			else if(Loginr.role.equals("Trainer")) {
				if(role.equals("Hr")) {
					pw.print("You can't check HR details");
				}
				else {
					PreparedStatement ps=con.prepareStatement("select * from loginhr where id=? and role=?");
					ps.setInt(1, id);
					ps.setString(2, "Trainer");
					ps.setString(3, "Trainee");
					ResultSet rs=ps.executeQuery();
					ResultSetMetaData rm=rs.getMetaData();
					if(rs.next()) {
						for(int i=1;i<=5;i++) {
							pw.print(rm.getColumnName(i)+" : ");
							pw.println(rs.getString(i));
						}
					}
					
				}
			}
			else{
				if(role.equals("Hr")||role.equals("Trainer")) {
					pw.print("You can't check HR and Trainer details");
				}
				else {
					PreparedStatement ps=con.prepareStatement("select * from loginhr where id=? and role=?");
					ps.setInt(1, id);
					ps.setString(2, "Trainee");
					ResultSet rs=ps.executeQuery();
					ResultSetMetaData rm=rs.getMetaData();
					if(rs.next()) {
						for(int i=1;i<=5;i++) {
							pw.print(rm.getColumnName(i)+" : ");
							pw.println(rs.getString(i));
						}
					}
				}
			
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
