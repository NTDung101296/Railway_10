package com.vti.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.vti.entity.Department;

public class DepartmentDao {
	private List<Department> departments;
	private Scanner scanner;
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;

	public DepartmentDao() {
		departments = new ArrayList<Department>();
		scanner = new Scanner(System.in);
	}

	public Connection connect() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/employees?autoReconnect=true&useSSL=false&characterEncoding=latin1";
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

	public List<Department> getDepartments() throws ClassNotFoundException, SQLException {
		// Get a database connection
		connect();

		// Create a statement object
		statement = connection.createStatement();

		// Execute SQL query
		String sql = "SELECT * FROM departments";
		resultSet = statement.executeQuery(sql);

		Department department;
		// Handing result set
		while (resultSet.next() == true) {
			department = new Department(resultSet.getString("dept_no"), resultSet.getString("dept_name"));
			departments.add(department);
		}

		// Close connection
		disconnect();

		return departments;
	}

	public Department getDepartmentByID(String id) throws ClassNotFoundException, SQLException {
		// Get a database connection
		connect();

		// Create a statement object
		String sql = "SELECT * FROM departments WHERE dept_no = ?";
		preparedStatement = connection.prepareStatement(sql);

		// Input using scanner, sd o frontend
		System.out.println("Moi ban nhap vap ma phong ban: ");
		id = scanner.nextLine();

		// Set parameter
		preparedStatement.setString(1, id);

		resultSet = preparedStatement.executeQuery();
		Department department;

		// Handing result set
		if (resultSet.next() == true) {
			department = new Department(resultSet.getString("dept_no"), resultSet.getString("dept_name"));
			return department;
		} else {
			System.out.println("Cannot find department which has id= " + id);
			disconnect();
			return null;
		}
	}

	public boolean isDepartmentNameExists(String name) throws ClassNotFoundException, SQLException {
		connect();

		String sql = "SELECT * FROM departments WHERE dept_name = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		resultSet = preparedStatement.executeQuery();

		if (resultSet.next() == true) {
			disconnect();
			return true;
		} else {
			disconnect();
			return false;
		}
	}

	public boolean isDepartmentIdExists(String id) throws ClassNotFoundException, SQLException {
		connect();

		String sql = "SELECT * FROM departments WHERE dept_no = ?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);
		resultSet = preparedStatement.executeQuery();

		if (resultSet.next() == true) {
			disconnect();
			return true;
		} else {
			disconnect();
			return false;
		}
	}

	public void createDepartment(String id, String name) throws ClassNotFoundException, SQLException, Exception {
		connect();

		if (isDepartmentNameExists(name) == true) {
			throw new Exception("Department Name is Exists!");
		} else {
			String sql = "INSERT INTO departments()\n" + "VALUE (? , ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, name);
			int effectedRecords = preparedStatement.executeUpdate();
			if (effectedRecords > 0) {
				System.out.println("Create " + effectedRecords + " Department complete");
			}
		}
		disconnect();
	}

	public void updateDepartmentName(String id, String newName) throws ClassNotFoundException, SQLException, Exception {
		connect();

		if (isDepartmentIdExists(id) == false) {// !isDepartmentIdExists(id)
			throw new Exception("Cannot find department which has id= " + id);
		} else if (isDepartmentNameExists(newName) == true) {
			throw new Exception("Department Name is Exists!");
		} else {
			String sql = "UPDATE departments\n" + "SET dept_name = ?\n" + "WHERE dept_no = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, id);
			int effectedRecords = preparedStatement.executeUpdate();
			if (effectedRecords > 0) {
				System.out.println("Update " + effectedRecords + " Department success");
			}
		}
		disconnect();
	}
	
	public void deleteDepartment(String id) throws ClassNotFoundException, SQLException, Exception {
		connect();

		if (isDepartmentIdExists(id) == false) {// !isDepartmentIdExists(id)
			throw new Exception("Cannot find department which has id= " + id);
		} else {
			String sql = "DELETE FROM departments\n" + "WHERE dept_no = ?";
			preparedStatement = connection.prepareStatement(sql);
			
			// Input using scanner, sd o frontend
			System.out.println("Moi ban nhap vao ma phong ban: ");
			id = scanner.nextLine();
			
			preparedStatement.setString(1, id);
			int effectedRecords = preparedStatement.executeUpdate();
			
			if (effectedRecords > 0) {
				System.out.println("Delete " + effectedRecords + " Department complete");
			}
		}
		disconnect();
	}

}
