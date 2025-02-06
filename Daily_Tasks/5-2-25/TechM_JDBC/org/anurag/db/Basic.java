package org.anurag.db;
import java.sql.*;  // For SQL-related classes

public class Basic {
	public static void main(String arg[]) throws SQLException,Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techm?autoReconnect=true&useSSL=false","root","tiger");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from employee");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
	}
}