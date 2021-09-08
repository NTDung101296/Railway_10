package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Ex6.Employee;
import com.vti.entity.Ex6.Manager;
import com.vti.entity.Ex6.Waiter;

public class QLNV {
	Scanner scanner;

	public QLNV() {
		scanner = new Scanner(System.in);
	}

	public void menuStaff() {

		System.out.println("***** QUAN LY NHAN VIEN *****");
		System.out.println("1. Them moi Employee");
		System.out.println("2. Them moi Manager");
		System.out.println("3. Them moi Waiter");
		System.out.println("4. Thoat khoi chuong trinh");
		int choose;

		do {
			System.out.println("Moi ban chon chuc nang: (1-4)");
			choose = scanner.nextInt();
			scanner.nextLine();
			
			switch (choose) {
			case 1:
				addEmployee();
				break;
			case 2:
				addManager();
				break;
			case 3:
				addWaiter();
				break;
			case 4:
				System.out.println("Hen gap lai ban lan sau!");
				return;
			default:
				System.out.println("Nhap sai, moi ban nhap lai!");
				break;
			}
		} while (choose != 4);
	}

	public void addEmployee() {
		System.out.println("Nhap vao ten Employee: ");
		String employeeName = scanner.nextLine();

		System.out.println("Nhap vao Salary Ratio: ");
		double emSalaryRatio = scanner.nextDouble();

		Employee employee = new Employee(employeeName, emSalaryRatio);
		employee.displayInfor();

		System.out.println("Them moi thanh cong!");
	}

	public void addManager() {
		System.out.println("Nhap vao ten Manager: ");
		String managerName = scanner.nextLine();

		System.out.println("Nhap vao Salary Ratio: ");
		double maSalaryRatio = scanner.nextDouble();

		Manager manager = new Manager(managerName, maSalaryRatio);
		manager.displayInfor();

		System.out.println("Them moi thanh cong!");
	}

	public void addWaiter() {
		System.out.println("Nhap vao ten Waiter: ");
		String waiterName = scanner.nextLine();

		System.out.println("Nhap vao Salary Ratio: ");
		double waSalaryRatio = scanner.nextDouble();

		Waiter waiter = new Waiter(waiterName, waSalaryRatio);
		waiter.displayInfor();

		System.out.println("Them moi thanh cong!");
	}

}
