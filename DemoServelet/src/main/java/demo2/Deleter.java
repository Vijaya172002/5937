package demo2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Deleter")
public class Deleter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter pw=response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
			int id=Integer.parseInt(request.getParameter("id"));
		    PreparedStatement ps1=con.prepareStatement("Select * from login where id=?");
			ps1.setInt(1, id);
			ResultSet rs= ps1.executeQuery();
			if(rs.next()) {
				String role=rs.getString(3);
			if(Loginr.role.equals("Hr")) {
				PreparedStatement ps=con.prepareStatement("delete from loginhr where id=?");
				PreparedStatement p=con.prepareStatement("delete from login where id=?");
				ps.setInt(1, id);
				ps.executeUpdate();
				p.setInt(1, id);
				p.executeUpdate();
				RequestDispatcher rd=request.getRequestDispatcher("HR.html");
				rd.include(request, response);
				pw.print("HR deleted details successfully");
			}
			else if(Loginr.role.equals("Trainer")) {
				if(role.equals("Hr")) {
					pw.print("You can't Delete HR details");
				}
				else {
					PreparedStatement ps=con.prepareStatement("delete from loginhr where id=? and role=?");
					PreparedStatement p=con.prepareStatement("delete from login where id=? and role=? ");
					ps.setInt(1, id);
					ps.setString(2, "Trainer");
					ps.setString(3, "Trainee");
					ps.executeUpdate();
					p.setInt(1, id);
					p.setString(2, "Trainer");
					p.setString(3, "Trainee");
					p.executeUpdate();
					RequestDispatcher rd=request.getRequestDispatcher("Trainer.html");
					rd.include(request, response);
					pw.print("Trainer Deleted details successfully");
				}
				}
			else {
				if(role.equals("Hr")|| role.equals("Trainer")) {
					pw.print("You can't Delete HR and Trainer details");
				}
				else {
					PreparedStatement ps=con.prepareStatement("delete  from loginhr where id=? and role=? ");
					PreparedStatement p=con.prepareStatement("delete  from login where id=? and role=? ");
					ps.setInt(1, id);
					ps.setString(2, "Trainee");
					ps.executeUpdate();
					p.setInt(1, id);
					p.setString(2, "Trainee");
					p.executeUpdate();
					RequestDispatcher rd=request.getRequestDispatcher("Trainee.html");
					rd.include(request, response);
					pw.print("Trainee deleted details successfully");
				
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
