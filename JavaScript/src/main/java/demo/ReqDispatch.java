package demo;

import java.io.*;

import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ReqDispatch")
public class ReqDispatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			PrintWriter pw= response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
			String fname=request.getParameter("fname");
			PreparedStatement p= con.prepareStatement("select * from demo2 where fname=?");
			p.setString(1, fname);
			ResultSet rs= p.executeQuery();
			if(rs.next()) {
				RequestDispatcher rd= request.getRequestDispatcher("ReqDispatch2");
				rd.forward(request,response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("disp.html");
				rd.include(request,response);
				pw.print("Invalid data");
			}
	
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	//private void include(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	//}

	//private void forward(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	//}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
