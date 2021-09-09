package com.vti.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	private static Connection connection;

	public static void isConnectedForTesting() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/employees?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "2021P@ss";

		Class.forName("com.mysql.cj.jdbc.Driver");

		// Get a database connection
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connect success!");
	}

	public static Connection connect() throws ClassNotFoundException, SQLException {
		// Kiem tra da connect toi database hay chua?
		if (connection == null || connection.isClosed()) {
			String url = "jdbc:mysql://localhost:3306/employees?autoReconnect=true&useSSL=false&characterEncoding=latin1";
			String username = "root";
			String password = "2021P@ss";

			Class.forName("com.mysql.cj.jdbc.Driver");

			// Get a database connection
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
	
	public void disconnect() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection.close();
		}
	}

}
