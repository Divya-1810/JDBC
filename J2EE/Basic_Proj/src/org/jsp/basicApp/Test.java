package org.jsp.basicApp;

import java.sql.*;

public class Test {
	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Load and Register the Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Establish the connection between the java application and the database server");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Closed all the costly resources");
		}
	}

}
