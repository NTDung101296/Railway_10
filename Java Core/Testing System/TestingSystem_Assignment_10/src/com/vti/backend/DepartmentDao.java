package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.utils.JdbcUtils;

public class DepartmentDao {
	private List<Department> departments;
	private JdbcUtils jdbcUtils;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;

	public DepartmentDao() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		departments = new ArrayList<Department>();
		jdbcUtils = new JdbcUtils();
	}

	public List<Department> getDepartments() throws ClassNotFoundException, SQLException {
		// Get a database connection
		jdbcUtils.connect();

		// Execute SQL query
		String sql = "SELECT * FROM department";
		resultSet = jdbcUtils.executeQuery(sql);

		Department department;
		// Handing result set
		while (resultSet.next() == true) {
			department = new Department(resultSet.getByte("department_id"), resultSet.getString("department_name"));
			departments.add(department);
		}

		// Close connection
		jdbcUtils.disconnect();

		return departments;
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
			department = new Department(resultSet.getByte("department_id"), resultSet.getString("department_name"));
			return department;
		} else {
			System.out.println("Cannot find department which has id= " + id);
			jdbcUtils.disconnect();
			return null;
		}
	}

	public boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException {
		jdbcUtils.connect();

		String sql = "SELECT * FROM department WHERE department_name = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);
		preparedStatement.setString(1, name);
		resultSet = preparedStatement.executeQuery();

		if (resultSet.next() == true) {
			jdbcUtils.disconnect();
			return true;
		} else {
			jdbcUtils.disconnect();
			return false;
		}
	}

	public boolean isDepartmentIdExists(byte id) throws ClassNotFoundException, SQLException {
		jdbcUtils.connect();

		String sql = "SELECT * FROM department WHERE department_id = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);
		preparedStatement.setByte(1, id);
		resultSet = preparedStatement.executeQuery();

		if (resultSet.next() == true) {
			jdbcUtils.disconnect();
			return true;
		} else {
			jdbcUtils.disconnect();
			return false;
		}
	}

	public void createDepartment(String name) throws ClassNotFoundException, SQLException, Exception {
		jdbcUtils.connect();

		if (isDepartmentNameExists(name) == true) {
			throw new Exception("Department Name is Exists!");
		} else {
			String sql = "INSERT INTO department(department_name)\n" + "VALUE (?)";
			preparedStatement = jdbcUtils.createPrepareStatement(sql);
			preparedStatement.setString(1, name);
			int effectedRecords = preparedStatement.executeUpdate();
			if (effectedRecords > 0) {
				System.out.println("Create " + effectedRecords + " Department complete");
			}
		}
	}

	public void updateDepartmentName(byte id, String newName) throws ClassNotFoundException, SQLException, Exception {
		jdbcUtils.connect();

		if (isDepartmentIdExists(id) == false) {// !isDepartmentIdExists(id)
			throw new Exception("Cannot find department which has id= " + id);
		} else if (isDepartmentNameExists(newName) == true) {
			throw new Exception("Department Name is Exists!");
		} else {
			String sql = "UPDATE department\n" + "SET department_name = ?\n" + "WHERE department_id = ?";
			preparedStatement = jdbcUtils.createPrepareStatement(sql);
			preparedStatement.setString(1, newName);
			preparedStatement.setByte(2, id);
			int effectedRecords = preparedStatement.executeUpdate();
			if (effectedRecords > 0) {
				System.out.println("Update " + effectedRecords + " Department success");
			}
		}
		jdbcUtils.disconnect();
	}

	public void deleteDepartment(byte id) throws ClassNotFoundException, SQLException, Exception {
		jdbcUtils.connect();

		if (isDepartmentIdExists(id) == false) {// !isDepartmentIdExists(id)
			throw new Exception("Cannot find department which has id= " + id);
		} else {
			String sql = "DELETE FROM department\n" + "WHERE department_id = ?";
			preparedStatement = jdbcUtils.createPrepareStatement(sql);

			preparedStatement.setByte(1, id);
			int effectedRecords = preparedStatement.executeUpdate();

			if (effectedRecords > 0) {
				System.out.println("Delete " + effectedRecords + " Department complete");
			}
		}
		jdbcUtils.disconnect();
	}

}
