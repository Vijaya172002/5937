package jdbc;
import java.sql.*;
public class JdbcPreparedStatement {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		//for complete columns of student table
		//PreparedStatement ps= con.prepareStatement("insert into student values (?,?,?,?,?)");
		PreparedStatement ps=con.prepareStatement("insert into student(id,name)values(?,?)");
		//ResultSet rs=ps.executeQuery("select * from student");
		ResultSet rs=ps.executeQuery("select id,name from student");
		rs.next();
		int id=rs.getInt("id");
		String name=rs.getString("name");
		//String department=rs.getString("department");

		//int salary=rs.getInt("salary");
		//String work=rs.getString("work");
		//System.out.println(id+" "+department+" "+name+" "+salary+" "+work);
		System.out.println(id+" "+name);
		System.out.println("Done");
		ps.close();
		con.close();
		

		// TODO Auto-generated method stub

	}

}
