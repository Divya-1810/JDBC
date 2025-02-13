package org.jsp.deleteApp;
import java.sql.*;
	public class DeleteDemo1 {
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class is loaded and registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection established");
			stmt=con.createStatement();
			System.out.println("Platform created");
			stmt.executeUpdate("delete from btm.student where id=101");
			System.out.println("Record is deleted");
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

