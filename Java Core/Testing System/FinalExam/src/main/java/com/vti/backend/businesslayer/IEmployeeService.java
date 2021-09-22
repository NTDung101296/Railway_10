package com.vti.backend.businesslayer;

import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Employee;

public interface IEmployeeService {

	Employee loginEmployee(String email, String password) throws Exception;

	boolean isEmployeeExistByEmail(String email) throws ClassNotFoundException, SQLException;
	
	boolean isEmployeeExistById(String employeeId) throws ClassNotFoundException, SQLException;

	boolean isCorrectPassword(String password) throws ClassNotFoundException, SQLException;

	Employee getEmployeeById(String employeeId) throws ClassNotFoundException, SQLException, Exception;
	
	List<Employee> getEmployeesByProjectId(int projectId) throws ClassNotFoundException, SQLException, Exception;

	List<Employee> getListEmployees() throws ClassNotFoundException, SQLException;
}
