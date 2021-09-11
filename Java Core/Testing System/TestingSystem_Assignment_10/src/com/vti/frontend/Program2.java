package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.AccountDao;
import com.vti.backend.DepartmentDao;

public class Program2 {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		DepartmentDao departmentDao = new DepartmentDao();

		// Question 1: Lay ra danh sach tat ca cac department
		System.out.println("Thong tin tat ca cac phong ban");
		System.out.println(departmentDao.getDepartments());

		// Question 2-3: Lay ra department co id = ?
		System.out.println("Nhap vao id phong ban can lay thong tin: ");
		byte id = scanner.nextByte();
		scanner.nextLine();
		System.out.println(departmentDao.getDepartmentByID(id));

		// Question 4: Kiem tra ten department co ton tai?
		System.out.println("Nhap vao ten phong ban can kiem tra");
		String name = scanner.nextLine();
		if (departmentDao.isDepartmentNameExists(name) == false) {
			System.out.println("Khong ton tai!");
		} else {
			System.out.println("Co ton tai ten phong ban nay.");
		}

		// Question 5: Tao department moi
		System.out.println("-----Create department-----");
		System.out.println("Nhap vao name:");
		String name1 = scanner.nextLine();
		departmentDao.createDepartment(name1);
		System.out.println(departmentDao.getDepartments());

		// Question 6: Update department
		System.out.println("-----Update department name-----");
		System.out.println("Nhap vao id: ");
		byte id2 = scanner.nextByte();
		scanner.nextLine();
		System.out.println("Nhap vao name moi:");
		String newName = scanner.nextLine();
		departmentDao.updateDepartmentName(id2, newName);
		System.out.println(departmentDao.getDepartments());

		// Question 7: Delete department
		System.out.println("Nhap vao id phong ban can xoa: ");
		byte id3 = scanner.nextByte();
		departmentDao.deleteDepartment(id3);
		System.out.println(departmentDao.getDepartments());

		// Question 8: Account
		AccountDao accountDao = new AccountDao();
		System.out.println(accountDao.getAccounts());
//		accountDao.getAccountById(id3);
//		accountDao.isAccountNameExists(name1);
//		accountDao.createAccount(null, id2, id3);
//		accountDao.updateAccountByUserName(id3, name1);
//		accountDao.deleteAccount(id3);

	}

}
