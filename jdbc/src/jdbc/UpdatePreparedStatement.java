package jdbc;
import java.sql.*;
import java.util.Scanner;
public class UpdatePreparedStatement {

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name,id: ");
		String name=sc.nextLine();
		int id=sc.nextInt();

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		PreparedStatement ps=con.prepareStatement("update emp set id=? where name=?");
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.executeUpdate();
		System.out.println("Updated...");
		ps.close();
		con.close();
	}
}