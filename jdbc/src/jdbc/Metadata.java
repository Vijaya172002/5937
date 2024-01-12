package jdbc;
import java.sql.*;
public class Metadata {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		PreparedStatement ps=con.prepareStatement("select * from st");
		ResultSet rs=ps.executeQuery();    //table data stored in result set
		ResultSetMetaData rm=rs.getMetaData();
		System.out.println("The data type of the columns: "+rm.getColumnTypeName(1)+" "+ rm.getColumnTypeName(2)+" "+rm.getColumnTypeName(3));
		int i = rm.getColumnCount();
		System.out.println("The count of an column: "+i);
		for(int j=1;j<=i;j++) {      
			System.out.print(rm.getColumnName(j)+"   ");    //print the column name
		}
		System.out.println(" ");         //to get the table values in next line
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));   //prints the table data

		}

	}

}
