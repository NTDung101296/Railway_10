package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.DepartmentDao;

public class Program2 {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		String name = scanner.nextLine();
		String newName = scanner.nextLine();

		DepartmentDao departmentDao = new DepartmentDao();
		departmentDao.getDepartments();
		departmentDao.getDepartmentByID(id);
		departmentDao.createDepartment(id, name);
		departmentDao.updateDepartmentName(id, newName);
		departmentDao.deleteDepartment(id);

	}

}
