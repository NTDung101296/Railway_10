package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.businesslayer.EmployeeService;
import com.vti.backend.businesslayer.IEmployeeService;
import com.vti.entity.Employee;

public class EmployeeController {

	private IEmployeeService employeeService;

	public EmployeeController() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		employeeService = new EmployeeService();
	}

	public Employee loginEmployee(String email, String password) throws Exception {
		return employeeService.loginEmployee(email, password);
	}

	public boolean isEmployeeExistByEmail(String email) throws ClassNotFoundException, SQLException {
		return employeeService.isEmployeeExistByEmail(email);
	}
	
	public boolean isEmployeeExistById(String employeeId) throws ClassNotFoundException, SQLException {
		return employeeService.isEmployeeExistById(employeeId);
	}

	public boolean isCorrectPassword(String password) throws ClassNotFoundException, SQLException {
		return employeeService.isCorrectPassword(password);
	}

	public Employee getEmployeeById(String employeeId) throws Exception {
		return employeeService.getEmployeeById(employeeId);
	}

	public List<Employee> getEmployeesByProjectId(int projectId) throws Exception {
		return employeeService.getEmployeesByProjectId(projectId);
	}
	
	public List<Employee> getListEmployees() throws ClassNotFoundException, SQLException {
		return employeeService.getListEmployees();
	}

}
