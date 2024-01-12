package jdbc;
import java.sql.*;
import java.util.Scanner;
public class delete {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name and id ");
		String name=sc.nextLine();
		int id=sc.nextInt();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		PreparedStatement ps = con.prepareStatement("delete from emp where id=? and name=?");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.executeUpdate();
		System.out.println("Deleted..");
		con.close();
		ps.close();
		
	}

}
