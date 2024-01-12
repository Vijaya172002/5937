package jdbc;
import java.sql.*;

import java.util.Scanner;
public class InsertMoreValuesUsingForLoop {

	public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of fields: ");
		int n= sc.nextInt();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		for(int i=0;i<n;i++) {
			System.out.println("Enter the name,marks and id");
			String name=sc.next();
			int marks=sc.nextInt();
			int id=sc.nextInt();
		PreparedStatement ps=con.prepareStatement("insert into st values(?,?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, marks);
		ps.executeUpdate();
		ps.close();
		}
		System.out.println("Inserted...");
		con.close();
		
		// TODO Auto-generated method stub

	}

}
