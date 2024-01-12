package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;
public class employee {
	static void insert(String s,Scanner sc,Connection con) throws SQLException{
		try {
			System.out.println("To insert enter(id,name,role and email");
		    int id=sc.nextInt();
		    String name=sc.next();
		    String role=sc.next();
		    String email=sc.next();
		    if(s.equals("Hr")) {
		    	PreparedStatement ps=con.prepareStatement("insert into employee(id,name,role,email)values(?,?,?,?)");
			    PreparedStatement p=con.prepareStatement("insert into role values(?,?,?)");
			    p.setInt(1, id);
			    p.setString(2, name);
			    p.setString(3, role);
			    p.setString(4, email);
			    p.executeUpdate();
			    ps.setInt(1, id);
			    ps.setString(2, name);
			    ps.setString(3, role);
			    ps.setString(4, email);
			    ps.executeUpdate();
		    }
		    else if(s.equals("Trainer")) {
		    	if(role.equals("Trainer")||(role.equals("Trainee"))) {
		    		PreparedStatement ps=con.prepareStatement("insert into employee(id,name,role,email)values(?,?,?,?)");
				    PreparedStatement p=con.prepareStatement("insert into role values(?,?,?)");
				    p.setInt(1, id);
				    p.setString(2, "Vijaya@1");
				    p.setString(3, role);
				    p.executeUpdate();
				    ps.setInt(1, id);
				    ps.setString(2, name);
				    ps.setString(3, role);
				    ps.setString(4, email);
				    ps.executeUpdate();
				}else {
				System.out.println("No acess to Hr details");
				}
			}
		    else {
		    	if(role.equals("Trainee")) {
		    		PreparedStatement ps=con.prepareStatement("insert into employee(id,name,role,email)values(?,?,?,?)");
				    PreparedStatement p=con.prepareStatement("insert into role values(?,?,?)");
				    p.setInt(1, id);
				    p.setString(2, "Vijaya@1");
				    p.setString(3, role);
				    p.executeUpdate();
				    ps.setInt(1, id);
				    ps.setString(2, name);
				    ps.setString(3, role);
				    ps.setString(4, email);
				    ps.executeUpdate();
				}else {
					System.out.println("You cannot insert Hr details");
				}
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	static void Update(String su, Scanner sc,Connection con) throws Exception{
		try {
			System.out.println("Enter id,role to update: ");
		    int id=sc.nextInt();
		    String name=sc.next();
		    String role=sc.next();
		    
		    if(su.equals("Hr")) {
		    	PreparedStatement p=con.prepareStatement("Update employee set role=? where id=?");
		    	PreparedStatement ps=con.prepareStatement("Update employee set role=? where id=?");
		    	p.setString(1, role);
			    p.setInt(2, id);
			    p.executeUpdate();
		    	ps.setString(1, role);
			    ps.setInt(2, id);
			    ps.executeUpdate();
		   }
		   else if(su.equals("Trainer")) {
			   if(role.equals("Trainer")|| role.equals("Trainee")) {
			    	PreparedStatement p=con.prepareStatement("Update employee set role=? where id=?");
			   	   PreparedStatement ps=con.prepareStatement("Update employee set role=? where id=?");
				    p.setString(1, role);
				    p.setInt(2, id);
				    p.executeUpdate(); 
				    ps.setString(1, role);
				    ps.setInt(2, id);
				    ps.executeUpdate();
			   }
			   else {
				   System.out.println("you cannot update Hr details");
			   }
		   }
		   else {
			   if(role.equals("Trainee")) {
			    	PreparedStatement p=con.prepareStatement("Update employee set role=? where id=?");
				    PreparedStatement ps=con.prepareStatement("Update employee set role=? where id=?");
				    p.setString(1, role);
				    p.setInt(2, id);
				    p.executeUpdate();
				    ps.setString(1, role);
				    ps.setInt(2, id);
				    ps.executeUpdate();
			   }
			   else {
				   System.out.println("you cannot update Hr and Trainer details");
			   }
		   
		
		}
	
	if(su.equals("name")) {
		System.out.println("Enter the id and update the name to: ");
		int id1=sc.nextInt();
		String name1=sc.next();
		PreparedStatement p=con.prepareStatement("Select role from employee where id=?");
		p.setInt(1, id);
		ResultSet rs=p.executeQuery();
		if(su.equals("Hr")) {
			PreparedStatement ps=con.prepareStatement("Update employee set name=? where id=?");
			ps.setInt(2,id);
			ps.setString(1,name);
			ps.executeUpdate();
		}
	
		else if(su.equals("Trainer")) {
			if(rs.getString(1).equals("Trainer")|| rs.getString(1).equals("Trainee")){
				PreparedStatement ps=con.prepareStatement("Update employee set name=? where id=?");
				ps.setInt(2, id);
				ps.setString(1, name);
				ps.executeUpdate();
			}else {
				System.out.println("You cannot update Hr details..");
			}
				
			}
		else {
			if(rs.getString(1).equals("Trainee")){
				PreparedStatement ps=con.prepareStatement("Update employee set name=? where id=?");
				ps.setInt(2, id);
				ps.setString(1, name);
				ps.executeUpdate();
			}else {
				System.out.println("You cannot Hr and Trainer details: ");
			}
		}
	}
	if(su.equals("email")) {
		System.out.println("Enter the id and update the email to:");
		int id1=sc.nextInt();
		String email=sc.next();
		PreparedStatement p=con.prepareStatement("select role from employee where id=?");
		p.setInt(1, id);
		ResultSet rs=p.executeQuery();
		if(su.equals("Hr")) {
			PreparedStatement ps=con.prepareStatement("Update employee set email=? where id=?");
			ps.setString(1, email);
			ps.setInt(2,id);
			ps.executeUpdate();
		}
		else if(su.equals("Trainer")) {
			if(rs.getString(1).equals("Trainer")||rs.getString(1).equals("Trainee")) {
				PreparedStatement ps=con.prepareStatement("Update employee set email=? where id=?");
				ps.setString(1, email);
				ps.setInt(2, id);
				ps.executeUpdate();
			}else {
				System.out.println("You cannot update Hr details: ");
			}
		}else {
			if(rs.getString(1).equals("Trainee")) {
				PreparedStatement ps=con.prepareStatement("Update employee set email=? where id=?");
				ps.setString(1, email);
				ps.setInt(2, id);
				ps.executeUpdate();
			}else {
				System.out.println("You cannot update Hr details: ");
			}
			}
	}}
	catch(Exception e) {
			e.printStackTrace();
	}
	}

     static void Delete(String sd,Scanner sc, Connection con) {
		try {
			System.out.println("Enter id,role to delete: ");
		    int id=sc.nextInt();
		    if(sd.equals("Hr")) {
		    	PreparedStatement ps=con.prepareStatement("delete from employee set where id=?");
		    	PreparedStatement p=con.prepareStatement("delete from role where id=?");
			    ps.setInt(1, id);
			    ps.executeUpdate();
			    ps.setInt(2, id);
			    ps.executeUpdate();
		    }
		    else if(sd.equals("Trainer")) {
		    	PreparedStatement ps=con.prepareStatement("delete from employee set where id=? and role=? or role=?");
		    	PreparedStatement p=con.prepareStatement("delete from role where id=? and role=? or role=?");
			    ps.setInt(1, id);
			    ps.setString(2, "Trainer");
			    ps.setString(3, "Trainee");
			    ps.executeUpdate();
			    p.setInt(1, id);
			    p.setString(2, "Trainer");
			    p.setString(3, "Trainee");
			    p.executeUpdate();
		    }
		    else {
		    	PreparedStatement ps=con.prepareStatement("delete from employee set where id=? and role=?");
		    	PreparedStatement p=con.prepareStatement("delete from role where id=? and role=?");
			    ps.setInt(1, id);
			    ps.setString(2, "Trainee");
			    ps.executeUpdate();
			    p.setInt(1, id);
			    p.setString(2, "Trainee");
			    p.executeUpdate();
		    }
		}
		catch(Exception e) {
			e.printStackTrace();	
		    }
	}
	static void select(String ss,Scanner sc, Connection con) throws Exception{
		try {
			System.out.println("Enter id,role to select: ");
		    if(ss.equals("Hr")) {
		    	PreparedStatement ps=con.prepareStatement("select from employee ");
		    	ResultSet rs=ps.executeQuery();
		    	while(rs.next()) {
		    		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
		    	}
		    }
		    else if(ss.equals("Trainer")) {
		    	PreparedStatement ps=con.prepareStatement("select * from employee set where role=? or role=?");
			    ps.setString(1, "Trainer");
			    ps.setString(2, "Trainee");
			    ResultSet rs=ps.executeQuery();
			    while(rs.next()) {
			    	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			    }
		    }
		    else {
		    	PreparedStatement ps=con.prepareStatement("select *  from employee set where role=?");
			    ps.setString(1, "Trainee");
			    ResultSet rs=ps.executeQuery();
			    while(rs.next()) {
			    	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			    }
		    }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}  
	public static void main(String[] args) throws Exception{
		try {
			Scanner sc=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
			for(int i=1;i<=3;i++) {
				System.out.println("Enter login id: ");
				int id=sc.nextInt();
				System.out.println("Enter password:");
				String s1=sc.next();
				PreparedStatement ps=con.prepareStatement("select * from role");
				ResultSet rs=ps.executeQuery();
				int n,count=0;
				while(rs.next()) {
					if(id==rs.getInt(1) && s1.equals(rs.getString(2))) {
						System.out.println("Login Successfully...");
						count++;
						System.out.println("select 1.select \n  2.Insert  \n  3.Update  \n  4.Delete  \n  5.Exit");
						n=sc.nextInt();
						while(n!=0) {
							switch(n) {
							case 1:
								select(rs.getString(3),sc,con);
								break;
							case 2:
								insert(rs.getString(3),sc,con);
								break;
							case 3:
								Update(rs.getString(3),sc,con);
								break;
							case 4:
								Delete(rs.getString(3),sc,con);
								break;
							case 5:
								System.out.println("Thank you");
								System.exit(0);
							default:
								System.out.println("Invalid");
								break;
							}
							System.out.println("Select the option \n 1.select \n 2.Insert  \n  3.Update  \n 4. Delete  \n 5.Exit");
							n=sc.nextInt();
						}
					}
				}
				if(count==0) {
					System.out.println("Enter valid details");
				}
			}}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		}
}
	
		
	
