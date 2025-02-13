package org.jsp.fetchApp;

import java.sql.*;
import java.util.Scanner;
public class FetchDemo1 {
public static void main(String[] args) {
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id?");
		int sid=sc.nextInt();
		
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		pstmt=con.prepareStatement("select * from btm.student where id=?");
		pstmt.setInt(1,sid);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			String sname=rs.getString(2);
			double sperc=rs.getDouble(3);
			
			System.out.println("Name is" + sname);
			System.out.println("Perc is" + sperc);
		}
		else {
			System.err.println("No Student info is found since id is invalid");
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
