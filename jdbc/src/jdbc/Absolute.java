package jdbc;
import java.sql.*;
public class Absolute {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		PreparedStatement ps = con.prepareStatement("select * from st",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs=ps.executeQuery();
		rs.absolute(2);
		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		con.close();
	}
}