package com.vti.backend.businesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.EmployeeRepository;
import com.vti.backend.datalayer.IEmployeeRepository;
import com.vti.entity.Employee;

public class EmployeeService implements IEmployeeService {

	private IEmployeeRepository employeeRepository;

	public EmployeeService() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		employeeRepository = new EmployeeRepository();
	}

	public Employee loginEmployee(String email, String password) throws Exception {
		return employeeRepository.loginEmployee(email, password);
	}

	public boolean isEmployeeExistByEmail(String email) throws ClassNotFoundException, SQLException {
		return employeeRepository.isEmployeeExistByEmail(email);
	}
	
	public boolean isEmployeeExistById(String employeeId) throws ClassNotFoundException, SQLException {
		return employeeRepository.isEmployeeExistById(employeeId);
	}

	public boolean isCorrectPassword(String password) throws ClassNotFoundException, SQLException {
		return employeeRepository.isCorrectPassword(password);
	}

	public Employee getEmployeeById(String employeeId) throws Exception {
		return employeeRepository.getEmployeeById(employeeId);
	}

	public List<Employee> getEmployeesByProjectId(int projectId) throws Exception {
		return employeeRepository.getEmployeesByProjectId(projectId);
	}

	public List<Employee> getListEmployees() throws ClassNotFoundException, SQLException {
		return employeeRepository.getListEmployees();
	}

}
