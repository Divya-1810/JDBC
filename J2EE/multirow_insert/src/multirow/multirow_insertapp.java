package multirow;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class multirow_insertapp {
public static void main(String[] args) {
	Connection con=null;
	Statement stmt=null;
	String qry1="insert into btm.student values(101,'Nisha',83.43)";
	String qry2="insert into btm.student values(102,'sadeesh',93.43)";
	String qry3="insert into btm.student values(103,'mano',80.43)";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver class is loaded and registered");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		System.out.println("Connection established");
		stmt=con.createStatement();
		System.out.println("Platform created");
		stmt.executeUpdate(qry1);//compilation + execution
		stmt.executeUpdate(qry2);//compilation + execution
		stmt.executeUpdate(qry3);//compilation + execution
		System.out.println("Record is inserted");
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	finally {
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("close all the costly resources");
		
	}
}
}

