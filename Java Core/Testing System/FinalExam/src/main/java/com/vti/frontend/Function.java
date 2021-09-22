package com.vti.frontend;

import com.vti.utils.ScannerUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.EmployeeController;
import com.vti.backend.presentationlayer.ManagerController;
import com.vti.backend.presentationlayer.ProjectController;
import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.entity.Project;

public class Function {

	private ProjectController projectController;
	private EmployeeController employeeController;
	private ManagerController managerController;

	public Function() throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {
		projectController = new ProjectController();
		employeeController = new EmployeeController();
		managerController = new ManagerController();
	}

	public Manager loginManager() {
		while (true) {
			try {
				System.out.print("Input Email: ");
				String email = ScannerUtils.inputEmail("Email form: abcd@gmail.com \n");
				System.out.print("Input Password: ");
				String password = ScannerUtils
						.inputPassword("Enter between 6 and 12 characters, with at least 1 uppercase character!");

				return managerController.loginManager(email, password);

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public Manager getManagerById() throws ClassNotFoundException, SQLException {
		while (true) {
			try {
				System.out.print("Input managerId: ");
				String managerId = ScannerUtils.inputString("ID form: M1,M2,...");
				Manager manager = managerController.getManagerById(managerId);
				System.out.println(manager);
				return manager;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}

	}

	public void getManagerOfAllProject() throws ClassNotFoundException, SQLException {
		List<Manager> managers = managerController.getManagerOfAllProject();
		System.out.println("Manager of all project: ");
		String leftAlignFormat = "| %-6s | %-25s | %-35s | %-12s | %-12s |%n";
		System.out.format(
				"+--------+---------------------------+-------------------------------------+--------------+--------------+%n");
		System.out.format(
				"|   ID   |          FullName         |               Email                 |   ExpInYear  |   ProjectID  |%n");
		System.out.format(
				"+--------+---------------------------+-------------------------------------+--------------+--------------+%n");
		for (Manager manager : managers) {
			System.out.format(leftAlignFormat, manager.getId(), manager.getName(), manager.getEmail(),
					manager.getExpInYear(), manager.getIdProject());
		}
		System.out.format(
				"+--------+---------------------------+-------------------------------------+--------------+--------------+%n");
	}

	public Employee loginEmployee() {
		while (true) {
			try {
				System.out.print("Input Email: ");
				String email = ScannerUtils.inputEmail("Email form: abcd@gmail.com \n");
				System.out.print("Input Password: ");
				String password = ScannerUtils
						.inputPassword("Enter between 6 and 12 characters, with at least 1 uppercase character!");

				return employeeController.loginEmployee(email, password);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public Employee getEmployeeById() {
		while (true) {
			try {
				System.out.print("Input employeeId: ");
				String employeeID = ScannerUtils.inputString("ID form: E1,E2,...");
				Employee employee = employeeController.getEmployeeById(employeeID);
				System.out.println(employee);
				return employee;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public List<Employee> getEmployeesByProjectId() {
		while (true) {
			try {
				System.out.print("Input projectId: ");
				int projectId = ScannerUtils.inputId();
				List<Employee> employees = employeeController.getEmployeesByProjectId(projectId);
				System.out.println("List employees of project: ");
				String leftAlignFormat = "| %-6s | %-25s | %-35s | %-12s |%n";
				System.out.format(
						"+--------+---------------------------+-------------------------------------+--------------+%n");
				System.out.format(
						"|   ID   |          FullName         |               Email                 |   ProSkill   |%n");
				System.out.format(
						"+--------+---------------------------+-------------------------------------+--------------+%n");
				for (Employee employee : employees) {
					System.out.format(leftAlignFormat, employee.getId(), employee.getName(), employee.getEmail(),
							employee.getProSkill());
				}
				System.out.format(
						"+--------+---------------------------+-------------------------------------+--------------+%n");
				return employees;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public void getListEmployees() throws ClassNotFoundException, SQLException {
		List<Employee> employees = employeeController.getListEmployees();
		System.out.println("List employees: ");
		String leftAlignFormat = "| %-6s | %-25s | %-35s | %-12s |%n";
		System.out.format(
				"+--------+---------------------------+-------------------------------------+--------------+%n");
		System.out.format(
				"|   ID   |          FullName         |               Email                 |   ProSkill   |%n");
		System.out.format(
				"+--------+---------------------------+-------------------------------------+--------------+%n");
		for (Employee employee : employees) {
			System.out.format(leftAlignFormat, employee.getId(), employee.getName(), employee.getEmail(),
					employee.getProSkill());
		}
		System.out.format(
				"+--------+---------------------------+-------------------------------------+--------------+%n");
	}

	public List<Project> getProjectsByEmployeeId() {
		while (true) {
			try {
				System.out.print("Input employeeId: ");
				String employeeId = ScannerUtils.inputString("ID form: E1,E2,...");
				List<Project> projects = projectController.getProjectsByEmployeeId(employeeId);
				System.out.println("List projects of employee: ");
				for (Project project : projects) {
					System.out.println(project.getId());
				}
				return projects;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public Project getProjectById() throws Exception {
		while (true) {
			try {
				System.out.print("Input projectId: ");
				int projectId = ScannerUtils.inputId();
				Project project = projectController.getProjectById(projectId);
				System.out.println("Information of project: ");
				System.out.println(" ID: " + project.getId());
				System.out.println(" TeamSize: " + project.getTeamSize());
				System.out.println(" Manager: " + project.getManager());
				System.out.println(" List Employees: \n" + project.getEmployees());
				return project;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

}
