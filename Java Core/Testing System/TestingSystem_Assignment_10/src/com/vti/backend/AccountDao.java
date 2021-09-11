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

public class AccountDao {
	private List<Account> accounts;
	private JdbcUtils jdbcUtils;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
//	private Account account;

	public AccountDao() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		accounts = new ArrayList<Account>();
		jdbcUtils = new JdbcUtils();
	}

	public List<Account> getAccounts() throws ClassNotFoundException, SQLException {
		// Get a database connection
		jdbcUtils.connect();

		// Execute SQL query
		String sql = "SELECT * FROM account";
		resultSet = jdbcUtils.executeQuery(sql);
		// Handing result set
		while (resultSet.next() == true) {
			Position position = getPositionByID(resultSet.getByte("position_id"));
			Department department = getDepartmentByID(resultSet.getByte("department_id"));

			Account account = new Account(resultSet.getShort("account_id"), resultSet.getString("email"),
					resultSet.getString("user_name"), resultSet.getString("full_name"),
					department, position, resultSet.getDate("create_date"));
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
		// Handing result set
		if (resultSet.next() == true) {
			Department department = new Department(resultSet.getByte("department_id"),
					resultSet.getString("department_name"));
			return department;
		} else {
			System.out.println("Cannot find department which has id= " + id);
			jdbcUtils.disconnect();
			return null;
		}
	}

	public Position getPositionByID(byte id) throws ClassNotFoundException, SQLException {
		// Get a database connection
		jdbcUtils.connect();
		// Create a statement object
		String sql = "SELECT * FROM position WHERE position_id =?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);

		// Set parameter
		preparedStatement.setByte(1, id);

		resultSet = preparedStatement.executeQuery();

		// Handing result set
		if (resultSet.next() == true) {
			Position position = new Position(resultSet.getByte("position_id"),
					PositionName.valueOf(resultSet.getString("position_name")));
			return position;
		} else {
			System.out.println("Cannot find position which has id= " + id);
			jdbcUtils.disconnect();
			return null;
		}
	}

	public Account getAccountById(short id) throws SQLException, ClassNotFoundException {
		// Get a database connection
		jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT * FROM `account` WHERE account_id = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);

		// Set parameter
		preparedStatement.setShort(1, id);

		resultSet = preparedStatement.executeQuery();

		// Handing result set
		if (resultSet.next() == true) {
			Department department = getDepartmentByID(resultSet.getByte("department_id"));
			Position position = getPositionByID(resultSet.getByte("position_id"));

			Account account = new Account(resultSet.getShort("account_id"), resultSet.getString("email"),
					resultSet.getString("user_name"), resultSet.getString("full_name"), department, position,
					resultSet.getDate("create_date"));
			return account;
		} else {
			System.out.println("Cannot find account which has id= " + id);
			jdbcUtils.disconnect();
			return null;
		}
	}

	public boolean isAccountNameExists(String userName) throws ClassNotFoundException, SQLException {
		// Get a database connection
		jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT * FROM `account` WHERE user_name = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);

		// Set parameter
		preparedStatement.setString(1, userName);
		resultSet = preparedStatement.executeQuery();

		if (resultSet.next() == true) {
			jdbcUtils.disconnect();
			return true;
		} else {
			jdbcUtils.disconnect();
			return false;
		}
	}

	public boolean isAccountIdExists(short id) throws ClassNotFoundException, SQLException {
		// Get a database connection
		jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT * FROM `account` WHERE account_id = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);

		// Set parameter
		preparedStatement.setShort(1, id);
		resultSet = preparedStatement.executeQuery();

		if (resultSet.next() == true) {
			jdbcUtils.disconnect();
			return true;
		} else {
			jdbcUtils.disconnect();
			return false;
		}
	}

	public void createAccount(Account account, byte idDep, byte idPos) throws ClassNotFoundException, Exception {
		jdbcUtils.connect();

		if (isAccountNameExists(account.getUserName()) == true) {
			throw new Exception("Account UserName is Exists!");
		} else {
			String sql = "INSERT INTO `account`(email, user_name, full_name, department_id, position_id)\n"
					+ "VALUE (? , ? , ? , ? , ?)";
			preparedStatement = jdbcUtils.createPrepareStatement(sql);

			preparedStatement.setString(1, account.getEmail());
			preparedStatement.setString(2, account.getUserName());
			preparedStatement.setString(3, account.getFullName());
			preparedStatement.setByte(4, idDep);
			preparedStatement.setByte(5, idPos);

			int effectedRecords = preparedStatement.executeUpdate();
			if (effectedRecords > 0) {
				System.out.println("Create " + effectedRecords + " Account complete");
			}
		}
		jdbcUtils.disconnect();
	}

	public void updateAccountByUserName(short id, String newUserName)
			throws ClassNotFoundException, SQLException, Exception {
		jdbcUtils.connect();

		if (isAccountIdExists(id) == false) {// !isAccountIdExists(id)
			throw new Exception("Cannot find account which has id= " + id);
		} else if (isAccountNameExists(newUserName) == true) {
			throw new Exception("User Name is Exists!");
		} else {
			String sql = "UPDATE `account`\n" + "SET user_name = ?\n" + "WHERE account_id = ?";
			preparedStatement = jdbcUtils.createPrepareStatement(sql);
			preparedStatement.setString(1, newUserName);
			preparedStatement.setShort(2, id);
			int effectedRecords = preparedStatement.executeUpdate();
			if (effectedRecords > 0) {
				System.out.println("Update " + effectedRecords + " Account success");
			}
		}
		jdbcUtils.disconnect();
	}

	public void deleteAccount(short id) throws ClassNotFoundException, SQLException, Exception {
		jdbcUtils.connect();

		if (isAccountIdExists(id) == false) {// !isAccountIdExists(id)
			throw new Exception("Cannot find account which has id= " + id);
		} else {
			String sql = "DELETE FROM `account`\n" + "WHERE account_id = ?";
			preparedStatement = jdbcUtils.createPrepareStatement(sql);

			preparedStatement.setShort(1, id);
			int effectedRecords = preparedStatement.executeUpdate();

			if (effectedRecords > 0) {
				System.out.println("Delete " + effectedRecords + " account complete");
			}
		}
		jdbcUtils.disconnect();
	}

}
