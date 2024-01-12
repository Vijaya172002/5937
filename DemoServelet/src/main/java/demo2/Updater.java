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
import javax.servlet.http.HttpSession;

@WebServlet("/Updater")
public class Updater extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter pw=response.getWriter();
			HttpSession hs= request.getSession();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
			int id=Integer.parseInt(request.getParameter("id"));
			String fdname=request.getParameter("fhname");
			String fdvalue=request.getParameter("fhvalue");
		    PreparedStatement p1=con.prepareStatement("select * from login where id=?");
			p1.setInt(1, id);
			ResultSet rs= p1.executeQuery();
			if(rs.next()) {
				hs.setAttribute("fname", rs.getString(1));
			}
			PreparedStatement ps1=con.prepareStatement("select * from login where id=?");
			ps1.setInt(1, id);
			ResultSet rs1=ps1.executeQuery();
			if(rs1.next()) {
				String role=rs1.getString(3);
				if(Loginr.role.equals("Hr")) {
			    if(fdname.equals("fname")||fdname.equals("email")||fdname.equals("salary")) {
				PreparedStatement ps=con.prepareStatement("update loginhr set "+fdname+"=? where id=?");
				ps.setString(1, fdvalue);
				ps.setInt(2, id);
				ps.executeUpdate();
				RequestDispatcher rd=request.getRequestDispatcher("HR.html");
				rd.include(request, response);
				pw.print(hs.getAttribute("fname")+" Details updated successfully");	
			}
			    else {
			    	RequestDispatcher rd=request.getRequestDispatcher("HR.html");
			    	rd.include(request,response);
			    	pw.print("You can't updated those fields");
			    }
				}
			else if(Loginr.role.equals("Trainer")) {
				if(role.equals("Hr")) {
					pw.print("You can't update HR details");
				}
				else {
					if(fdname.equals("fname")||fdname.equals("email")) {
					PreparedStatement ps=con.prepareStatement("update loginhr set " +fdname+"=? where id=? and (role='Trainer or role='Trainee') ");
					ps.setString(1, fdvalue);
					ps.setInt(2, id);
					ps.executeUpdate();
					RequestDispatcher rd=request.getRequestDispatcher("Trainer.html");
					rd.include(request, response);
					pw.print(hs.getAttribute("fname")+"Details Updated successfully");
				}
					else {
						RequestDispatcher rd=request.getRequestDispatcher("Trainer.html");
						rd.include(request, response);
						pw.print("You can't update those details");
					}
				}
					}
			else {
				if(role.equals("Hr")|| role.equals("Trainer")) {
					pw.print("You can't update HR and Trainer details");
				}else {
					if(Loginr.lid==id) {
						if(fdname.equals("fname")||fdname.equals("email")) {
							PreparedStatement ps=con.prepareStatement("update loginhr set "+fdname+"=? where id=? and role='Trainee'");
							ps.setString(1, fdvalue);
							ps.setInt(2,id);
							ps.executeUpdate();
							RequestDispatcher rd=request.getRequestDispatcher("Trainee.html");
							rd.include(request, response);
							pw.print(hs.getAttribute("fname")+"Details has been updated successfully");
						}
						else {
							RequestDispatcher rd=request.getRequestDispatcher("Trainee.html");
							rd.include(request, response);
							pw.print("You can't update those fields");
						}
					}
					else {
						RequestDispatcher rd=request.getRequestDispatcher("updater.html");
						rd.include(request, response);
						pw.print("<br><br>"+"You can update only your details");
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
