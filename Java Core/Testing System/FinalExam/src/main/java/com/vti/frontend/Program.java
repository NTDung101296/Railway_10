package com.vti.frontend;

import com.vti.utils.ScannerUtils;

public class Program {
	private static Function function;

	public static void main(String[] args) throws Exception {
		function = new Function();

		menuLogin();

	}

	public static void menuLogin() throws Exception {
		int choose;
		do {
			System.out.println("-----MENU-----");
			System.out.println("1. Login for Manager");
			System.out.println("2. Login for Employee");
			System.out.println("3. Exit");
			System.out.println("--------------");
			System.out.println("Input your choice: ");
			choose = ScannerUtils.inputInt("Just 1 or 2 or 3");

			switch (choose) {
			case 1:
				System.out.println("----LOGIN MANAGER----");
				function.loginManager();
				System.out.println("Login successfull!");
				menuManager();
				break;
			case 2:
				System.out.println("----LOGIN EMPLOYEE----");
				function.loginEmployee();
				System.out.println("Login successfull!");
				menuEmployee();
				break;
			case 3:
				System.out.println("See you again!");
				break;
			default:
				System.out.println("Input wrong! Please input again (1 or 2 or 3)");
				break;
			}
		} while (choose != 3);
	}

	private static void menuManager() throws Exception {
		int choose;
		do {
			System.out.println("-----FUNCTION FOR MANAGER-----");
			System.out.println("1. Get inform employee by employeeId");
			System.out.println("2. Get inform manager by managerId");
			System.out.println("3. Get inform project by projectId");
			System.out.println("4. Get list employees by projectId");
			System.out.println("5. Get list projects by employeeId");
			System.out.println("6. Get manager of all project");
			System.out.println("7. Get list employees");
			System.out.println("8. Logout");
			System.out.println("--------------");
			System.out.println("Input your choice: ");
			choose = ScannerUtils.inputFunction(1, 8, "You only choose from 1 --> 8. Please input again.");
			switch (choose) {
			case 1:
				System.out.println("-----Employee by ID-----");
				function.getEmployeeById();
				break;
			case 2:
				System.out.println("-----Manager by ID-----");
				function.getManagerById();
				break;
			case 3:
				System.out.println("-----Project by ID-----");
				function.getProjectById();
				break;
			case 4:
				System.out.println("-----List employees of project-----");
				function.getEmployeesByProjectId();
				break;
			case 5:
				System.out.println("-----List projects of employee----");
				function.getProjectsByEmployeeId();
				break;
			case 6:
				System.out.println("-----Manager of all project-----");
				function.getManagerOfAllProject();
				break;
			case 7:
				System.out.println("-----List employees-----");
				function.getListEmployees();
				break;
			case 8:
				System.out.println("Logout success!");
				break;
			default:
				System.out.println("Input wrong! Please input again (1 --> 8)");
				break;
			}
		} while (choose != 8);
	}

	private static void menuEmployee() throws Exception {
		int choose;
		do {
			System.out.println("-----FUNCTION FOR EMPLOYEE-----");
			System.out.println("1. Get inform employee by employeeId");
			System.out.println("2. Get list employees by projectId");
			System.out.println("3. Get list projects by employeeId");
			System.out.println("4. Get list employees");
			System.out.println("5. Logout");
			System.out.println("--------------");
			System.out.println("Input your choice: ");
			choose = ScannerUtils.inputFunction(1, 5, "You only choose from 1 --> 5. Please input again.");
			switch (choose) {
			case 1:
				System.out.println("-----Employee by ID-----");
				function.getEmployeeById();
				break;
			case 2:
				System.out.println("-----List employees of project-----");
				function.getEmployeesByProjectId();
				break;
			case 3:
				System.out.println("-----List projects of employee----");
				function.getProjectsByEmployeeId();
				break;
			case 4:
				System.out.println("-----List employees-----");
				function.getListEmployees();
				break;
			case 5:	
				System.out.println("Logout success!");
				break;
			default:
				System.out.println("Input wrong! Please input again (1 --> 5)");
				break;
			}
		} while (choose != 5);
	}

}
