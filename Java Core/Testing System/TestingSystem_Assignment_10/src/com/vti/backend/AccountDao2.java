package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.PositionName;
import com.vti.utils.JdbcUtils;

public class AccountDao2 {
	private List<Account> accounts;
	private JdbcUtils jdbcUtils;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private Account account;

	public AccountDao2() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		accounts = new ArrayList<Account>();
		jdbcUtils = new JdbcUtils();
	}

	public List<Account> getAccounts() throws ClassNotFoundException, SQLException {
		// Get a database connection
		jdbcUtils.connect();
		// Create a statement object

		// Execute SQL query
		String sql = "SELECT * FROM `account`";
		resultSet = jdbcUtils.executeQuery(sql);

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
		jdbcUtils.disconnect();

		return accounts;
	}

	public Department getDepartmentByID(byte id) throws ClassNotFoundException, SQLException {
		// Get a database connection
		jdbcUtils.connect();
		// Create a statement object
		String sql = "SELECT * FROM department WHERE department_id = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);

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
			jdbcUtils.disconnect();
			return null;
		}
	}

	public Position getPositionByID(byte id) throws ClassNotFoundException, SQLException {
		// Get a database connection

		// Create a statement object
		String sql = "SELECT * FROM position WHERE position_id = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);

		// Set parameter
		preparedStatement.setByte(1, id);

		resultSet = preparedStatement.executeQuery();
		Position position;

		// Handing result set
		if (resultSet.next() == true) {
			position = new Position(resultSet.getByte("position_id"),
					PositionName.valueOf(resultSet.getString("position_name")));
			return position;
		} else {
			System.out.println("Cannot find department which has id= " + id);
			jdbcUtils.disconnect();
			return null;
		}
	}

}
