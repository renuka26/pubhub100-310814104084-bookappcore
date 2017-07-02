package com.pubhub.util;


	import java.sql.Connection;
	import java.sql.DriverManager;

	public class ConnectionUtil {

		public static Connection getconnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/bookapp_db";
			Connection connection=DriverManager.getConnection(url,"root","");
		return connection;
	}
	}


