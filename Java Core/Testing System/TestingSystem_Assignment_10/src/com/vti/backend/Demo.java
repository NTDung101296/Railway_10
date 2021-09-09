package com.vti.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;

public class Demo {
	private List<Department> departments;

	public Demo() {
		departments = new ArrayList<Department>();
	}

	public List<Department> getDepartments() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/employees?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username = "root";
		String password = "2021P@ss";

		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Get a database connection
		Connection connection = DriverManager.getConnection(url, username, password);

		// Step 3: Create a statement object
		Statement statement = connection.createStatement();

		// Step 4: Execute SQL query
		String sql = "SELECT * FROM departments";
		ResultSet resultSet = statement.executeQuery(sql);

		Department department;
		// Step 5: Handing result set
		while (resultSet.next() == true) {
			department = new Department(resultSet.getString("dept_no"), resultSet.getString("dept_name"));
			departments.add(department);
		}

		// Step 6: Close connection
		connection.close();
		return departments;

	}

}
