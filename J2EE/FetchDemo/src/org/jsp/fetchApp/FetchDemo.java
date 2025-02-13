package org.jsp.fetchApp;

import java.sql.*;
public class FetchDemo {
public static void main(String[] args) {
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		pstmt=con.prepareStatement("select * from btm.student");
		rs=pstmt.executeQuery();
		while(rs.next()) {
			int sid=rs.getInt(1);
			String sname=rs.getString(2);
			double sperc=rs.getDouble(3);
			System.out.println("ID is" + sid);
			System.out.println("Name is" + sname);
			System.out.println("Perc is" + sperc);
			System.out.println("------------------------------------------------------");
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
