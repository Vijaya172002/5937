package jdbc;
import java.sql.*;
public class CreatingTableForMoreValuesInsert {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		PreparedStatement ps= con.prepareStatement("create table st(id int,name varchar(25),marks int)");
		ps.executeUpdate();
		con.close();
	}

}
