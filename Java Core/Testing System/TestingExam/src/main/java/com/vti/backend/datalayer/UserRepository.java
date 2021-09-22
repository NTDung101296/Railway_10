package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Fresher;
import com.vti.entity.Role;
import com.vti.entity.Senior;
import com.vti.entity.User;
import com.vti.utils.JdbcUtils;

public class UserRepository implements IUserRepository {

	private List<User> users;
	private ResultSet resultSet;
	private JdbcUtils jdbcUtils;
	private PreparedStatement preparedStatement;

	public UserRepository() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		users = new ArrayList<User>();
		jdbcUtils = new JdbcUtils();
	}

	public List<User> getListUsers() throws SQLException, ClassNotFoundException {
		// Get a database connection
		jdbcUtils.connect();

		// Execute SQL query
		String sql = "SELECT * FROM `user`";
		resultSet = jdbcUtils.executeQuery(sql);

		// Handing result set
		while (resultSet.next()) {
			if (Role.valueOf(resultSet.getString("is_senior").toString().toUpperCase()).equals(Role.SENIOR)) {
				User user = new Senior(resultSet.getShort("user_id"), resultSet.getString("full_name"),
						resultSet.getString("email"), resultSet.getByte("exp"), resultSet.getString("skill"));
				users.add(user);
			} else if (Role.valueOf(resultSet.getString("is_senior").toString().toUpperCase()).equals(Role.FRESHER)) {
				User user = new Fresher(resultSet.getShort("user_id"), resultSet.getString("full_name"),
						resultSet.getString("email"), resultSet.getByte("exp"), resultSet.getString("skill"));
				users.add(user);
			}
		}
		// Close connection
		jdbcUtils.disconnect();

		return users;
	}

	public User getUserById(short id) throws SQLException, ClassNotFoundException {
		// Get a database connection
		jdbcUtils.connect();

		// Create a statement object
		String sql = "SELECT * FROM `user` WHERE user_id = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);

		// Set parameter
		preparedStatement.setShort(1, id);

		resultSet = preparedStatement.executeQuery();

		// Handing result set
		if (resultSet.next()) {
			User user = null;
			if (Role.valueOf(resultSet.getString("is_senior").toString().toUpperCase()).equals(Role.SENIOR)) {
				user = new Senior(resultSet.getShort("user_id"), resultSet.getString("full_name"),
						resultSet.getString("email"), resultSet.getByte("exp"), resultSet.getString("skill"));
			} else if (Role.valueOf(resultSet.getString("is_senior").toString().toUpperCase()).equals(Role.FRESHER)) {
				user = new Fresher(resultSet.getShort("user_id"), resultSet.getString("full_name"),
						resultSet.getString("email"), resultSet.getByte("exp"), resultSet.getString("skill"));
			}
			return user;
		} else {
			System.out.println("Cannot find user which has id= " + id);
			jdbcUtils.disconnect();
			return null;
		}
	}

	public boolean isUserExistsByEmail(String email) throws SQLException, ClassNotFoundException {
		jdbcUtils.connect();

		String sql = "SELECT * FROM `user` WHERE email = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);
		preparedStatement.setString(1, email);
		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			jdbcUtils.disconnect();
			return true;
		} else {
			jdbcUtils.disconnect();
			return false;
		}
	}

	public boolean isUserExistsById(short id) throws SQLException, ClassNotFoundException {
		jdbcUtils.connect();

		String sql = "SELECT * FROM `user` WHERE user_id = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);
		preparedStatement.setShort(1, id);
		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			jdbcUtils.disconnect();
			return true;
		} else {
			jdbcUtils.disconnect();
			return false;
		}
	}

	public boolean isCorrectPassword(String password) throws SQLException, ClassNotFoundException {
		jdbcUtils.connect();

		String sql = "SELECT * FROM `user` WHERE `password` = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);
		preparedStatement.setString(1, password);
		resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			jdbcUtils.disconnect();
			return true;
		} else {
			jdbcUtils.disconnect();
			return false;
		}
	}

	public boolean deleteUser(short id) throws Exception {
		if (!isUserExistsById(id)) {
			throw new Exception("Cannot find user which has id= " + id);
		} else {
			jdbcUtils.connect();
			String sql = "DELETE FROM `user`" + "WHERE user_id = ?";
			preparedStatement = jdbcUtils.createPrepareStatement(sql);

			preparedStatement.setShort(1, id);
			int effectedRecords = preparedStatement.executeUpdate();

			if (effectedRecords > 0) {
				jdbcUtils.disconnect();
				return true;
			} else {
				jdbcUtils.disconnect();
				return false;
			}
		}
	}

	public User login(String email, String password) throws Exception {
		// Check email & password are correct or not?
		if (!isUserExistsByEmail(email)) {
			throw new Exception("Email doesn't exists!");
		} else if (!isCorrectPassword(password)) {
			throw new Exception("Incorrect password!");
		} else {

			// Get a database connection
			jdbcUtils.connect();

			// Create a statement object
			String sql = "SELECT * FROM `user` " + "WHERE email = ? AND password = ? ";
			preparedStatement = jdbcUtils.createPrepareStatement(sql);
			// Set parameter
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			// Execute Query
			resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result
			if (resultSet.next()) {
				short id = resultSet.getShort("user_id");
				String name = resultSet.getString("full_name");
				byte exp = resultSet.getByte("exp");
				String skill = resultSet.getString("skill");
				Role role = Role.valueOf(resultSet.getString("is_senior").toString().toUpperCase());

				User user = new User(id, name, email, password, exp, skill, role);
				jdbcUtils.disconnect();
				return user;
			} else {
				throw new Exception("Email or password incorrect!");
			}
		}
	}

	public boolean createUser(String fullName, String email, String password, byte exp, String skill) throws Exception {
		if (isUserExistsByEmail(email)) {
			throw new Exception("User is Exists!");
		} else {
			jdbcUtils.connect();
			String sql = "INSERT INTO `user`(full_name, email, password, exp, skill)\n" + "VALUE (?, ?, ?, ?, ?)";
			preparedStatement = jdbcUtils.createPrepareStatement(sql);
			preparedStatement.setString(1, fullName);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			preparedStatement.setByte(4, exp);
			preparedStatement.setString(5, skill);
			int effectedRecords = preparedStatement.executeUpdate();
			if (effectedRecords > 0) {
				jdbcUtils.disconnect();
				return true;
			} else {
				jdbcUtils.disconnect();
				return false;
			}
		}
	}

}
