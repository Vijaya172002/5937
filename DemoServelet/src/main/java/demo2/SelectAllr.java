package demo2;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SelectAllr")
public class SelectAllr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter pw=response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		    if(Loginr.role.equals("Hr")) {
				PreparedStatement ps=con.prepareStatement("select * from loginhr");
				ResultSet rs= ps.executeQuery();
				ResultSetMetaData rm=rs.getMetaData();
				while(rs.next()) {
					for(int i=1;i<=rm.getColumnCount();i++) {
						pw.print(rm.getColumnName(i)+" : ");
						pw.println(rs.getString(i));
					}
				}
			}
			else if(Loginr.role.equals("Trainer")) {
				PreparedStatement ps=con.prepareStatement("select * from loginhr where role=? or role=?");
				ps.setString(1, "Trainer");
				ps.setString(2, "Trainee");
				ResultSet rs=ps.executeQuery();
				ResultSetMetaData rm= rs.getMetaData();
				while(rs.next()) {
						for(int i=1;i<=rm.getColumnCount();i++) {
							pw.print(rm.getColumnName(i)+" : ");
							pw.println(rs.getString(i));
						}
					}
					
				}
			else {
				PreparedStatement ps=con.prepareStatement("select * from loginhr where role=?");
				ps.setString(1, "Trainee");
				ResultSet rs=ps.executeQuery();
				ResultSetMetaData rm= rs.getMetaData();
				while(rs.next()) {
						for(int i=1;i<=rm.getColumnCount();i++) {
							pw.print(rm.getColumnName(i)+" : ");
							pw.println(rs.getString(i));
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
