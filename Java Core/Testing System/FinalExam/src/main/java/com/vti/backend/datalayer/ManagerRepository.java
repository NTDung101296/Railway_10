package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Manager;
import com.vti.utils.JdbcUtils;

public class ManagerRepository implements IManagerRepository {

	private List<Manager> managers;
	private JdbcUtils jdbcUtils;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private CallableStatement callableStatement;

	public ManagerRepository() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		managers = new ArrayList<Manager>();
		jdbcUtils = new JdbcUtils();
	}

	public Manager loginManager(String email, String password) throws Exception {
		if (!isManagerExistByEmail(email)) {
			throw new Exception("Email doesn't exists!");
		} else if (!isCorrectPassword(password)) {
			throw new Exception("Incorrect password!");
		} else {
			// Get a database connection
			jdbcUtils.connect();
			// Create a statement object
			String sql = "SELECT * FROM manager WHERE email = ?  AND `password`= ?";
			preparedStatement = jdbcUtils.createPrepareStatement(sql);
			// Set parameter
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			// Execute Query
			resultSet = preparedStatement.executeQuery();

			// Handling Result Set
			if (resultSet.next()) {
				String managerId = resultSet.getString("manager_id");
				String fullName = resultSet.getString("full_name");
				byte expInYear = resultSet.getByte("exp_in_year");
				Manager manager = new Manager(managerId, fullName, email, password, expInYear);
				return manager;
			} else {
				throw new Exception("Email or or password incorrect!");
			}
		}
	}

	public boolean isManagerExistByEmail(String email) throws ClassNotFoundException, SQLException {
		// Get a database connection
		jdbcUtils.connect();
		// Create a statement object
		String sql = "SELECT * FROM manager WHERE email = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);
		// Set parameter
		preparedStatement.setString(1, email);
		// Execute SQL query
		resultSet = preparedStatement.executeQuery();
		// Handling Result Set
		if (resultSet.next()) {
			jdbcUtils.disconnect();
			return true;
		} else {
			jdbcUtils.disconnect();
			return false;
		}
	}

	public boolean isManagerExistById(String managerId) throws ClassNotFoundException, SQLException {
		// Get a database connection
		jdbcUtils.connect();
		// Create a statement object
		String sql = "SELECT * FROM manager WHERE manager_id = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);
		// Set parameter
		preparedStatement.setString(1, managerId);
		// Execute SQL query
		resultSet = preparedStatement.executeQuery();
		// Handling Result Set
		if (resultSet.next()) {
			jdbcUtils.disconnect();
			return true;
		} else {
			jdbcUtils.disconnect();
			return false;
		}
	}

	public boolean isCorrectPassword(String password) throws ClassNotFoundException, SQLException {
		// Get a database connection
		jdbcUtils.connect();
		// Create a statement object
		String sql = "SELECT * FROM manager WHERE password = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);
		// Set parameter
		preparedStatement.setString(1, password);
		// Execute SQL query
		resultSet = preparedStatement.executeQuery();
		// Handling Result Set
		if (resultSet.next()) {
			jdbcUtils.disconnect();
			return true;
		} else {
			jdbcUtils.disconnect();
			return false;
		}
	}

	public List<Manager> getManagerOfAllProject() throws ClassNotFoundException, SQLException {
		// Get a database connection
		jdbcUtils.connect();
		// Create a statement object
		String sql = "CALL sp_get_manager_of_all_project()";
		callableStatement = jdbcUtils.createCallableStatement(sql);
		// Execute SQL query
		resultSet = callableStatement.executeQuery();
		// Handling Result Set
		while (resultSet.next()) {
			String managerId = resultSet.getString("p.id_manager");
			String fullName = resultSet.getString("m.full_name");
			String email = resultSet.getString("m.email");
			byte expInYear = resultSet.getByte("m.exp_in_year");
			int idProject = resultSet.getInt("p.project_id");
			Manager manager = new Manager(managerId, fullName, email, expInYear, idProject);
			managers.add(manager);
		}
		// Close connection
		jdbcUtils.disconnect();

		return managers;
	}

	public Manager getManagerById(String managerId) throws Exception {
		if (!isManagerExistById(managerId)) {
			throw new Exception("Cannot find manager which has id= " + managerId + ", please input again.");
		} else {
			// Get a database connection
			jdbcUtils.connect();
			// Create a statement object
			String sql = "CALL sp_get_manager_by_id(?)";
			callableStatement = jdbcUtils.createCallableStatement(sql);
			// Set parameter
			callableStatement.setString(1, managerId);
			// Execute SQL query
			resultSet = callableStatement.executeQuery();
			// Handling Result Set
			if (resultSet.next()) {
				String fullName = resultSet.getString("full_name");
				String email = resultSet.getString("email");
				byte expInYear = resultSet.getByte("exp_in_year");
				Manager manager = new Manager(managerId, fullName, email, expInYear);
				jdbcUtils.disconnect();
				return manager;
			} else {
				jdbcUtils.disconnect();
				return null;
			}
		}
	}

}
