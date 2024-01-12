package jdbc;
import java.sql.*;
import java.util.Scanner;
public class BankTable {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		PreparedStatement ps=con.prepareStatement("select * from Bank Login");
		ps.close();
		con.close();
		System.out.println("Bank table selected...");
		
		// TODO Auto-generated method stub

	}

}
