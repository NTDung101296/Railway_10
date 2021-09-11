package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	private Connection connection;
	private Properties properties;

	public JdbcUtils() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		properties = new Properties();
		properties.load(new FileInputStream("scr/main/resource/database.properties"));

	}

	public void isConnectForTesting() throws ClassNotFoundException, SQLException {
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");

		// Register the driver class with DriverManager
		Class.forName(driver);

		// Get a database connection
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connect success!");
	}

	public Connection connect() throws ClassNotFoundException, SQLException {
		// Kiem tra da connect toi database hay chua?
		if (connection != null && !connection.isClosed()) {
			return connection;
		}

		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String driver = properties.getProperty("driver");

		// Register the driver class with DriverManager
		Class.forName(driver);

		// Get a database connection
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

	public void disconnect() throws SQLException {
		connection.close();
	}

	public ResultSet executeQuery(String sql) throws ClassNotFoundException, SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		return resultSet;
	}

	public PreparedStatement createPrepareStatement(String sql) throws ClassNotFoundException, SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		return preparedStatement;
	}

	public CallableStatement createCallableStatement(String sql) throws SQLException {
		CallableStatement callableStatement = connection.prepareCall(sql);
		return callableStatement;
	}

}
