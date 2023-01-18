package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

	private static Connection con;
	
	public static void openconnection() throws SQLException, ClassNotFoundException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");//reflection
		System.out.println("Driver Loaded....");
		
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3307/bank","root","root123");
		System.out.println("connected db");
		//return ;
	}
	public static Connection getCon() {
		return con;
	}
	public static void closeconnection() throws SQLException
	{if(con!=null)
		con.close();
	}
	
}
