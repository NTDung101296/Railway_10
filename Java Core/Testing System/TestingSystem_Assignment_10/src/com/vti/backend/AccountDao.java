package com.vti.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.PositionName;

public class AccountDao {
	private List<Account> accounts;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private Account account;

	public AccountDao() {
		accounts = new ArrayList<Account>();
	}

	public Connection connect() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/testing_system?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "2021P@ss";

		Class.forName("com.mysql.cj.jdbc.Driver");

		// Get a database connection
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connect success!");

		return connection;
	}

	public void disconnect() throws SQLException {
		connection.close();
	}

	public List<Account> getAccounts() throws ClassNotFoundException, SQLException {
		// Get a database connection
		connect();

		// Create a statement object
		statement = connection.createStatement();

		// Execute SQL query
		String sql = "SELECT * FROM `account`";
		resultSet = statement.executeQuery(sql);

		// Handing result set
		while (resultSet.next() == true) {
			Department department = getDepartmentByID(resultSet.getByte("department_id"));
			Position position = getPositionByID(resultSet.getByte("position_id"));

			account = new Account(resultSet.getShort("account_id"), resultSet.getString("email"),
					resultSet.getString("user_name"), resultSet.getString("full_name"), department, position,
					resultSet.getDate("create_date"));
			accounts.add(account);
		}

		// Close connection
		disconnect();

		return accounts;
	}

	public Department getDepartmentByID(byte id) throws ClassNotFoundException, SQLException {
		// Get a database connection
		connect();

		// Create a statement object
		String sql = "SELECT * FROM department WHERE department_id = ?";
		preparedStatement = connection.prepareStatement(sql);

		// Set parameter
		preparedStatement.setByte(1, id);

		resultSet = preparedStatement.executeQuery();
		Department department;

		// Handing result set
		if (resultSet.next() == true) {
			department = new Department(resultSet.getString("department_id"), resultSet.getString("department_name"));
			return department;
		} else {
			System.out.println("Cannot find department which has id= " + id);
			disconnect();
			return null;
		}
	}

	public Position getPositionByID(byte id) throws ClassNotFoundException, SQLException {
		// Get a database connection
		connect();

		// Create a statement object
		String sql = "SELECT * FROM position WHERE position_id = ?";
		preparedStatement = connection.prepareStatement(sql);

		// Set parameter
		preparedStatement.setByte(1, id);

		resultSet = preparedStatement.executeQuery();
		Position position;

		// Handing result set
		if (resultSet.next() == true) {
			position = new Position(resultSet.getByte("position_id"), PositionName.valueOf(resultSet.getString("position_name")));
			return position;
		} else {
			System.out.println("Cannot find department which has id= " + id);
			disconnect();
			return null;
		}
	}

}
