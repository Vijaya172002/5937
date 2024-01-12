package jdbc;
import java.sql.*;
public class Scroll {
	public static void main(String[] args)throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		PreparedStatement ps= con.prepareStatement("select * from st",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		//I gave table name as st.
		ResultSet rs=ps.executeQuery();
		rs.afterLast();       //it reverse the table
		while(rs.previous()) {   //checks the previous value
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			//System.out.println(rs.getInt(id)+" "+rs.getString(name)+" "+rs.getInt(marks));
		}
		con.close();
		
	}
}