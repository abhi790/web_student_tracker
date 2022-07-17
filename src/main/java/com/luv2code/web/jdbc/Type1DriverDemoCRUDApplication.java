package com.luv2code.web.jdbc;

/**
 * 7 steps to connect to database using jdbc
 * 
 *  1.import java.sql.*;package
 *  2.load and register Driver ---- Translator
 *  3.Establish connection between java application and database --- Road
 *  4.create statement object -- vehicle
 *  5.send and execute sql query -- vehicle send to collect gold and return back with boxes
 *  6.process result from resultset --- open the boxes containing gold
 *  7.close the connection
 */

//Step 1 : importing the sql package
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;



//working properly
public class Type1DriverDemoCRUDApplication {
	
	//Create an entry --- C
	public static void createEntry(Statement st) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to be created : "); 
	    int id = sc.nextInt(); 
		String queryString = "insert into employee values (" + id + ", 'sonal','mandana','sonal.mandana@love.com')";
		int noofRow = st.executeUpdate(queryString);
		System.out.println("inserted successfully " + noofRow + " row affected");
		
	}
	
	//Read entire table --- R
	public static void readTable(Statement st) throws Exception{	
		Scanner sc = new Scanner(System.in);
		//all the connection and statement were made in main method
		ResultSet rs = st.executeQuery("select * from employee");
		System.out.println("Table contains :-- ");
		while(rs.next()) {
			System.out.println(rs.getInt(1) + " | " + rs.getString(2)+" | " + rs.getString(3)+ " | " + rs.getString(4));
		}
		
	}
	
	//Update the entry provided ---- U
	public static void updateEntry(Statement st) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to be updated : "); 
	    int id = sc.nextInt(); 
		String queryString = "update employee set email_add = 'abhimanyu.roy400@gmail.com' where id = "+id;
		int noofRow = st.executeUpdate(queryString);
		System.out.println("Update complete.. " + noofRow + " row affected");
		
	}
	
	//Delete an entry ---- D
	public static void deleteEntry(Statement st) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to be deleted : "); 
	    int id = sc.nextInt(); 
		String queryString = "delete from employee where id = " + id;
		int noofRow = st.executeUpdate(queryString);
		System.out.println("deleted successfully.. " + noofRow +" row affected");
		
	}
	
	public static void main(String[] args) throws Exception{
		//Step 2 : load and register driver optional
//		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Step 3 : establish connection between database and java application
		String url = "jdbc:mysql://localhost:3306/company";
		String userName = "root";
		String pass = "Abhimanyu@97";
		Connection con = DriverManager.getConnection(url,userName,pass);
		
		//Step 4 : create statement object
		Statement st = con.createStatement();
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		while(option != 5) {
			System.out.println("Select the operation to be performed :\n1-create an entry\n2-read the table\n3-update an entry\n4-delete an entry\n5-exit");
			option = scanner.nextInt();
			switch(option) {
			case 1 : createEntry(st);
				break;
				
			case 2 : readTable(st);
				break;
				
			case 3 :
				updateEntry(st);
				break;
				
			case 4 :
				deleteEntry(st);
				break;
				
			case 5 : return;
			
			default:System.out.println("Select a valid operation");
			}
			
		}
		
		//Step 7 : closing the connection
		con.close();
		
	}
}
