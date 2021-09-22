package com.vti.frontend;

import com.vti.utils.ScannerUtils;

import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.Role;
import com.vti.entity.User;

public class Program {

	private static UserController userController;

	public static void menuLogin() throws Exception {
		int choose;
		do {
			System.out.println("-----MENU-----");
			System.out.println("1. Login");
			System.out.println("2. Exit");
			System.out.println("--------------");
			System.out.println("Input your choice: ");
			choose = ScannerUtils.inputInt("Just 1 or 2");

			switch (choose) {
			case 1:
				System.out.println("----LOGIN----");
				User user = login();
				System.out.println("Login successfull!");
				if (user.getRole() == Role.SENIOR) {
					menuSenior();
				} else {
					menuFresher();
				}
				break;
			case 2:
				System.out.println("See you again!");
				break;
			default:
				System.out.println("Input wrong! Please input again (1 or 2)");
				break;
			}
		} while (choose != 2);
	}

	private static void menuSenior() throws Exception {
		int choose;
		do {
			System.out.println("-----SENIOR-----");
			System.out.println("1. Get list users");
			System.out.println("2. Get user by ID");
			System.out.println("3. Create user");
			System.out.println("4. Delete user");
			System.out.println("5. Logout");
			System.out.println("--------------");
			System.out.println("Input your choice: ");
			choose = ScannerUtils.inputFunction(1, 5, "You only choose from 1 --> 5. Please input again.");
			switch (choose) {
			case 1:
				System.out.println("-----List Users-----");
				getListUser();
				break;
			case 2:
				System.out.println("-----User by ID-----");
				getUserById();
				break;
			case 3:
				System.out.println("-----Create User-----");
				deleteUser();
				break;
			case 4:
				System.out.println("-----Delete User-----");
				createUser();
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

	private static void menuFresher() throws Exception {
		int choose;
		do {
			System.out.println("-----Fresher-----");
			System.out.println("1. Get list users");
			System.out.println("2. Get user by ID");
			System.out.println("3. Logout");
			System.out.println("--------------");
			System.out.println("Input your choice: ");
			choose = ScannerUtils.inputFunction(1, 3, "You only choose from 1 --> 3. Please input again.");

			switch (choose) {
			case 1:
				System.out.println("-----List Users-----");
				getListUser();
				break;
			case 2:
				System.out.println("-----User by ID-----");
				getUserById();
				break;
			case 3:
				System.out.println("Logout success!");
				break;
			default:
				System.out.println("Input wrong! Please input again (1 --> 3)");
				break;
			}
		} while (choose != 3);
	}

	public static User login() {
		while (true) {
			try {
				System.out.print("Input Email: ");
				String email = ScannerUtils.inputEmail("Email form: abcd@gmail.com \n");
				System.out.print("Input Password: ");
				String password = ScannerUtils
						.inputPassword("Enter between 6 and 12 characters, with at least 1 uppercase character!");

				return userController.login(email, password);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	public static void getListUser() throws ClassNotFoundException, SQLException {
		List<User> users = userController.getListUsers();
		for (User user : users) {
			System.out.println(user);
		}
	}

	public static void getUserById() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.print("Input userId: ");
			int id = ScannerUtils.inputId();

			if (userController.isUserExistsById((short) id)) {
				System.out.println(userController.getUserById((short) id));
				return;
			} else {
				System.err.println("Id khong ton tai! Vui long nhap lai! ");
			}
		}
	}

	public static void deleteUser() throws ClassNotFoundException, SQLException, Exception {
		while (true) {
			System.out.print("Input userId: ");
			int id = ScannerUtils.inputId();
			userController.deleteUser((short) id);
		}
	}

	public static void createUser() throws Exception {
		System.out.println("Input Full Name: ");
		String fullName = ScannerUtils
				.inputfullName("Only contain letters, doesn't contain any special characters & numbers");
		System.out.println("Input Email: ");
		String email = ScannerUtils.inputEmail("Email form: abcd@gmail.com");
		System.out.print("Input password: ");
		String password = ScannerUtils
				.inputPassword("Enter between 6 and 12 characters, with at least 1 uppercase character!");
		System.out.println("Input Experience: ");
		byte exp = ScannerUtils.inputByte("Please input a number as byte, please input again");
		System.out.println("Input Skill: ");
		String skill = ScannerUtils.inputString("");
		userController.createUser(fullName, email, password, exp, skill);
	}

	public static void main(String[] args) throws Exception {
		userController = new UserController();
		menuLogin();
	}

}
