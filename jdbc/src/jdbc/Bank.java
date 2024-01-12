package jdbc;
import java.sql.*;
import java.util.Scanner;
class MyException extends Exception{
	MyException(String s){
		super(s);
	}
}
public class Bank{
	static int balance;
	static void withdraw(int w,String name,Connection c)throws Exception{
		if(w<balance) {
			balance=balance-w;
			PreparedStatement pw=c.prepareStatement("update Banklogin set amount=? where username=?");
			pw.setInt(1,balance);
			pw.setString(2,name);
			pw.executeUpdate();
			System.out.println(" Please collect your amount \n your account balance:  "+balance);
		}else {
			throw new MyException("Insufficient amount");
	    }
	}
	static void Deposit(int d,String name,Connection c )throws Exception{
		if(d>=500) {
			balance=balance+d;
			PreparedStatement pd=c.prepareStatement("update Banklogin set Amount=? where username=?");
			pd.setInt(1, balance);
			pd.setString(2, name);
			pd.executeUpdate();
			System.out.println("Credited Successdully \n Your acount balance: "+balance);
		}
		else {
			throw new MyException("please deposit more than 500");
	    }
    }
    static int Transaction(int n,int t1) {
	    if(n>=500 && n<balance ) {
		    t1=t1+n;
	    }
	    System.out.println("After Transfer Balance: "+t1);
	    return t1;
    }
	public static void main(String[] args) throws Exception {
		Scanner s=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/5937","root","M1racle@123");
		String name="";
		for(int i=1;i<4;i++) {
			System.out.println("Enter valid user name and password:");
		    String username=s.next();
		    String password=s.next();
			PreparedStatement ps=c.prepareStatement("select * from Banklogin where username=?");
            ps.setString(1,username);
            ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				balance=rs.getInt(4);
				if(rs.getString(3).equals(password)) {
					System.out.println("Enter the option \n 1.Check Balanec \n 2.Withdraw  \n 3.Deposit   \n 4.Transfer   \n 5.Exit");
					int n=s.nextInt();
					while(n!=0) {
						switch(n) {
						case 1:
							PreparedStatement pb=c.prepareStatement("select * from Banklogin where username=?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		                    pb.setString(1,name);
		                    ResultSet rsb=ps.executeQuery();
		                    while(rsb.next()) {
		                    	System.out.println("Current acount balance: "+rsb.getInt(4));
		                    }
		                    break;
		                case 2:
		            	    System.out.println("Enter withdraw amount: ");
		            	    int w=s.nextInt();
				            try{
				        	    withdraw(w,username,c);
				            }
				            catch(Exception e) {
				        	    e.printStackTrace();
				            }
				            break;
				       case 3:
				    	   System.out.println("Enter amount for deposit: ");
				           int d=s.nextInt();
				           try {
				        	   Deposit(d,username,c);	
				           }
				           catch(Exception e) {
				        	   e.printStackTrace();
				           }
				           break;
				       case 4: 
				    	   System.out.println("Enter amount to transfer: ");
				           int t=s.nextInt();
				           System.out.println("Enter user name Amount to be transfered");
				           String uname=s.next();
				           PreparedStatement pt=c.prepareStatement("select * from Banklogin where username=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
	                       pt.setString(1,uname);
	                       ResultSet rst=pt.executeQuery();
	                       rst.next();
				           int a=rst.getInt("amount");
				           System.out.println("Actual transferd acount balance: "+a);
				           try{
				        	   int b=Transaction(t,a);
					           balance=balance-t;
					           System.out.println("Amount transfer successfully \n "+"Remaining Balance amount in your acount:"+balance);
					           PreparedStatement pt1=c.prepareStatement("update Banklogin set amount=? where username=?");
					           pt1.setInt(1, b);
					           pt1.setString(2,uname);
					           pt1.executeUpdate();
					           PreparedStatement pt2=c.prepareStatement("update Banklogin set amount=? where username=?");
					           pt2.setInt(1,balance);
					           pt2.setString(2,username);
					           pt2.executeUpdate();
				           }
				           catch(Exception e) {
				        	   e.printStackTrace();
				           }
				           break;
				       case 5:
				    	   System.out.println("Thank you for visiting our bank...");
				           System.exit(0);
				           break;
			           default:
					       System.out.println("enter the valid option ");
					       break;
					   }
				       n=s.nextInt();
				   }
		     	}
		        else {
			         System.out.println("Invalid username or password");
		        }
			}
		}
		System.out.println("User name and password is incorrect/not found....!!");
		System.out.println("Thank you");
		c.close();
	}
}
		

