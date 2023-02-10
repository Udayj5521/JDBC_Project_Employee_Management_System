package com.emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static String url = "jdbc:mysql://localhost:3306/employee";
	static String username = "root";
	static String password = "root";
	static Connection con;

	public static Connection createDBConnetion() {
		
		try 
		{
			//Load and Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establish Connection
			con = DriverManager.getConnection(url, username, password);

		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
