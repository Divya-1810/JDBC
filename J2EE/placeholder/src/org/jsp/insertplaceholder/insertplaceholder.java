package org.jsp.insertplaceholder;

import java.sql.*;

public class insertplaceholder {
public static void main(String[] args) {
	Connection con=null;
	PreparedStatement pstmt=null;
	String qry="insert into btm.student values(?,?,?)";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		pstmt=con.prepareStatement(qry);//compilation---->1
		//set the data for place holder
		pstmt.setInt(1,101);
		pstmt.setString(2,"Divya");
		pstmt.setDouble(3, 81.06);
		
		// Execute
		pstmt.executeUpdate();// Execution---->1
		
		//set the data for place holder
				pstmt.setInt(1,102);
				pstmt.setString(2,"Sadeesh");
				pstmt.setDouble(3, 81.06);
				
				// Execute
				pstmt.executeUpdate();// Execution---->2
				
				//set the data for place holder
				pstmt.setInt(1,103);
				pstmt.setString(2,"Nisha");
				pstmt.setDouble(3, 80.06);
				
				// Execute
				pstmt.executeUpdate();// Execution---->3
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	finally {
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
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

