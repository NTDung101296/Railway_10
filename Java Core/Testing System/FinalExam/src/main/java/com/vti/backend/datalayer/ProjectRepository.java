package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.Project;
import com.vti.utils.JdbcUtils;

public class ProjectRepository implements IProjectRepository {
	private List<Project> projects;
	private ResultSet resultSet;
	private JdbcUtils jdbcUtils;
	private PreparedStatement preparedStatement;
	private ManagerRepository managerRepository;
	private EmployeeRepository employeeRepository;

	public ProjectRepository() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		jdbcUtils = new JdbcUtils();
		projects = new ArrayList<Project>();
		managerRepository = new ManagerRepository();
		employeeRepository = new EmployeeRepository();
	}

	public Project getProjectById(int id) throws Exception {
		if (!isProjectExistById(id)) {
			throw new Exception("Cannot find project which has id= " + id + ", please input again.");
		} else {
			// Get a database connection
			jdbcUtils.connect();
			// Create a statement object
			String sql = "SELECT * FROM project WHERE project_id = ?";
			preparedStatement = jdbcUtils.createPrepareStatement(sql);
			// Set parameter
			preparedStatement.setInt(1, id);
			// Execute SQL query
			resultSet = preparedStatement.executeQuery();
			// Handling Result Set
			if (resultSet.next()) {
				byte teamSize = resultSet.getByte("team_size");
				Manager manager = managerRepository.getManagerById(resultSet.getString("id_manager"));
				List<Employee> employees = employeeRepository.getEmployeesByProjectId(resultSet.getInt(id));
				Project project = new Project(id, teamSize, manager, employees);
				return project;
			} else {
				jdbcUtils.disconnect();
				return null;
			}
		}
	}

	public List<Project> getProjectsByEmployeeId(String employeeId) throws Exception {
		if (!employeeRepository.isEmployeeExistById(employeeId)) {
			throw new Exception("EmployeeId doesn't exists!");
		} else {
			// Get a database connection
			jdbcUtils.connect();
			// Create a statement object
			String sql = "SELECT project_id FROM project_and_employee WHERE employee_id = ?";
			preparedStatement = jdbcUtils.createPrepareStatement(sql);
			// Set parameter
			preparedStatement.setString(1, employeeId);
			// Execute SQL query
			resultSet = preparedStatement.executeQuery();
			// Handling Result Set
			while (resultSet.next()) {
				int id = resultSet.getInt("project_id");
				Project project = new Project(id);
				projects.add(project);
			}
			// Close connection
			jdbcUtils.disconnect();

			return projects;
		}
	}

	public boolean isProjectExistById(int id) throws ClassNotFoundException, SQLException {
		// Get a database connection
		jdbcUtils.connect();
		// Create a statement object
		String sql = "SELECT * FROM project WHERE project_id = ?";
		preparedStatement = jdbcUtils.createPrepareStatement(sql);
		// Set parameter
		preparedStatement.setInt(1, id);
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

}
