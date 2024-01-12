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
import javax.servlet.http.HttpSession;
@WebServlet("/Loginr")

public class Loginr extends HttpServlet {
	static String role;
	static int lid;
//	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
   		try {
			PrintWriter pw= response.getWriter();
			HttpSession hs=request.getSession();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
			int id=Integer.parseInt(request.getParameter("id"));
			
			String password=request.getParameter("pass");
		    PreparedStatement ps=con.prepareStatement("select * from loginhr where id=?");
		    ps.setInt(1, id);
		    ResultSet rs= ps.executeQuery();
		    if(rs.next()) {
		    	hs.setAttribute("fname",rs.getString(2));
		    
		    PreparedStatement ps1=con.prepareStatement("select * from login where id=?");
		    ps1.setInt(1, id);
		    ResultSet r=ps1.executeQuery();
		    if(r.next()) {
		    	lid=r.getInt(1);
		    	role= r.getString(3);
		    	if(r.getInt(1)==id && r.getString(2).equals(password)) {
		    		if(role.equals("Hr"))
		    		{
//		    			pw.print("h2 Style='text-align:right'>"+"Welcome " +hs.getAttribute("fname")+"</h2>");
		    			RequestDispatcher rd=request.getRequestDispatcher("/HR.html");
		    			rd.forward(request, response);
		    		}
		    		else if(role.equals("Trainer")) {
		    			pw.print("h2 Style='text-align:right'>"+"Welcome " +hs.getAttribute("fname")+"</h2>");
		    			RequestDispatcher rd= request.getRequestDispatcher("Trainer.html");
		    			rd.forward(request, response);
		    		}
		    		else{
		    			pw.print("h2 Style='text-align:right'>"+"Welcome " +hs.getAttribute("fname")+"</h2>");
				    	RequestDispatcher rd=request.getRequestDispatcher("Trainee.html");
				    	rd.forward(request, response);
		    		}
		    	}
		    	else{
			    	RequestDispatcher rd=request.getRequestDispatcher("/Loginr.html");
			    	rd.include(request, response);
			    	pw.print("Invalid");
		    }
		    
		    }
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
}
        protected void dopost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
//        	doGet(request,response);
        }
	
}
