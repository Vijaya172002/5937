package jdbc;
import java.sql.*;
public class JdbcStatement {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from student");
		//ResultSet rs=st.executeQuery("select id,name from student");
		rs.next();
		int id=rs.getInt("id");
		String name=rs.getString("name");
		String dept=rs.getString("dept");
		int salary=rs.getInt("salary");
		String work=rs.getString("work");
		System.out.println(id+" "+name+" "+dept+" "+salary+" "+work);
		System.out.println("Done");
		st.close();
		con.close();
	}

}
