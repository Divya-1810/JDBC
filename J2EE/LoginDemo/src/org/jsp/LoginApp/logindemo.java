package org.jsp.LoginApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class logindemo {
public static void main(String[] args) {
	Connection con=null; 
	PreparedStatement pstmt=null;
	ResultSet rs=null;
try {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name??");
		String nm=sc.next();
		
		System.out.println("Enter password??");
		String pw=sc.next();
		
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		pstmt=con.prepareStatement("select username from btm.user where name=? and password=?");
		pstmt.setString(1,nm);
		pstmt.setString(2,pw);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			String un=rs.getString(1);
			System.out.println("Welcome" +  un);
			}
		else {
			System.err.println("Invalid Credentials");
		}
		
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	finally {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
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
	}
}
}

