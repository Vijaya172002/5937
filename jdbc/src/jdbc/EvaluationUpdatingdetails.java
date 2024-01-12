package jdbc;
import java.sql.*;
import java.util.Scanner;
public class EvaluationUpdatingdetails {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		PreparedStatement ps=con.prepareStatement("Update employ set designation=?,phno=?,salary=? where id=? and firstname=? and lastname=?");
		ps.setString(1, "trainee");
		ps.setInt(2, 848571859);
		ps.setInt(3, 20000);
		ps.setInt(4, 1);
		ps.setString(5, "vijaya");
		ps.setString(6, "battula");
		ps.executeUpdate();
		System.out.println("Updated Successfully in sql employ table...");
		ps.close();
		con.close();

	}

}