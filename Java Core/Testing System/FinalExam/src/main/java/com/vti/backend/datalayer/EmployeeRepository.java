package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.utils.JdbcUtils;

public class EmployeeRepository implements IEmployeeRepository {

	private List<Employee> employees;
	private JdbcUtils jdbcUtils;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	private CallableStatement callableStatement;

	public EmployeeRepository() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		employees = new ArrayList<Employee>();
		jdbcUtils = new JdbcUtils();
	}

	public Employee loginEmployee(String email, String password) throws Exception {
		if (!isEmployeeExistByEmail(email)) {
			throw new Exception("Email doesn't exists!");
		} else if (!isCorrectPassword(password)) {
			throw new Exception("Incorrect password!");
		} else {
			// Get a database connection
			jdbcUtils.connect();
			// Create a statement object
			String sql = "SELECT * FROM employee WHERE email = ?  AND `password`= ?";
			preparedStatement = jdbcUtils.createPrepareStatement(sql);
			// Set parameter
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			// Execute Query
			resultSet = preparedStatement.executeQuery();

			// Handling Result Set
			if (resultSet.next()) {
				String employeeId = resultSet.getString("employee_id");
				String fullName = resultSet.getString("full_name");
				String proSkill = resultSet.getString("pro_skill");
				Employee manager = new Employee(employeeId, fullName, email, password, proSkill);
				jdbcUtils.disconnect();
				return manager;
			} else {
				throw new Exception("Email or or password incorrect!");
			}
		}
	}

	public boolean isEmployeeExistByEmail(String email) throws ClassNotFoundException, SQLException {
		// Get a database connection
		jdbcUtils.connect();
		// Create a statement object
		String sql = "SELECT * FROM employee WHERE email = ?";
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

	public boolean isEmployeeExistById(String employeeId) throws ClassNotFoundException, SQLException {
		// Get a database connection
		jdbcUtils.connect();
		// Create a statement object
		String sql = "SELECT * FROM employee WHERE employee_id = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);
		// Set parameter
		preparedStatement.setString(1, employeeId);
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
		String sql = "SELECT * FROM employee WHERE password = ?";
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

	public Employee getEmployeeById(String employeeId) throws Exception {
		if (!isEmployeeExistById(employeeId)) {
			throw new Exception("Cannot find employee which has id= " + employeeId + ", please input again.");
		} else {
			// Get a database connection
			jdbcUtils.connect();
			// Create a statement object
			String sql = "CALL sp_get_employee_by_id(?)";
			callableStatement = jdbcUtils.createCallableStatement(sql);
			// Set parameter
			callableStatement.setString(1, employeeId);
			// Execute SQL query
			resultSet = callableStatement.executeQuery();
			// Handling Result Set
			if (resultSet.next()) {
				String fullName = resultSet.getString("full_name");
				String email = resultSet.getString("email");
				String proSkill = resultSet.getString("pro_skill");
				Employee employee = new Employee(employeeId, fullName, email, proSkill);
				jdbcUtils.disconnect();
				return employee;
			} else {
				jdbcUtils.disconnect();
				return null;
			}
		}
	}

	public List<Employee> getEmployeesByProjectId(int projectId) throws Exception {
		ProjectRepository projectRepository = new ProjectRepository();
		if (!projectRepository.isProjectExistById(projectId)) {
			throw new Exception("ProjectId doesn't exists! Please input again.");
		} else {
			// Get a database connection
			jdbcUtils.connect();
			// Create a statement object
			String sql = "CALL sp_get_employees_by_project_id(?)";
			callableStatement = jdbcUtils.createCallableStatement(sql);
			// Set parameter
			callableStatement.setInt(1, projectId);
			// Execute SQL query
			resultSet = callableStatement.executeQuery();
			// Handling Result Set
			while (resultSet.next()) {
				String employeeId = resultSet.getString("pe.employee_id");
				String fullName = resultSet.getString("e.full_name");
				String email = resultSet.getString("e.email");
				String proSkill = resultSet.getString("e.pro_skill");
				Employee employee = new Employee(employeeId, fullName, email, proSkill);
				employees.add(employee);
			}
			// Close connection
			jdbcUtils.disconnect();
			return employees;
		}
	}

	public List<Employee> getListEmployees() throws ClassNotFoundException, SQLException {
		// Get a database connection
		jdbcUtils.connect();
		// Create a statement object
		String sql = "SELECT * FROM employee";
		// Execute SQL query
		resultSet=jdbcUtils.executeQuery(sql);
		// Handling Result Set
		while (resultSet.next()) {
			String employeeId = resultSet.getString("employee_id");
			String fullName = resultSet.getString("full_name");
			String email = resultSet.getString("email");
			String proSkill = resultSet.getString("pro_skill");
			Employee employee = new Employee(employeeId, fullName, email, proSkill);
			employees.add(employee);
		}
		// Close connection
		jdbcUtils.disconnect();

		return employees;
	}
}
