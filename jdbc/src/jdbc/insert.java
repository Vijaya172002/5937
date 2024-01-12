package jdbc;
import java.sql.*;
import java.util.Scanner;
public class insert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name,id: ");
		String name=sc.nextLine();
		int id=sc.nextInt();   //we give name,dept etc first, because if we give id first then it will take id only along with one of the field.
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		PreparedStatement ps=con.prepareStatement("insert into emp values(?,?)");
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.executeUpdate();
		System.out.println("Inserted");
		
	}

}
