package com.vti.frontend;

import java.util.Scanner;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.utils.ScannerUtils;

public class Program2 {

	public static void main(String[] args) {
		question1112();
	}

	// Question 1-2:
	public static void question12() {
		try {
			float result = devide(7, 0);
			System.out.println(result);
		} catch (Exception e) {
			System.err.println("Cannot devide 0");
		} finally {
			System.out.println("Devide completed! ");
		}

	}

	public static float devide(int a, int b) {
		return (float) (a / b);
	}

	// Question 3:
	public static void question3() {
		try {
			int[] numbers = { 1, 2, 3 };
			System.out.println(numbers[10]);
		} catch (Exception e) {
			System.err.println("Loi!");
		}
	}

	// Question 4:
	public static void question4() {
		Department dep1 = new Department("Dep1");
		Department dep2 = new Department("Dep2");
		Department dep3 = new Department("Dep3");
		Department[] deps = { dep1, dep2, dep3 };
		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("Insert the number of department that you want to get information: ");
			int i = scanner.nextInt();
			System.out.println(deps[i].toString());
		} catch (Exception e) {
			System.err.println("Cannot find department!");
		}
	}

	// Question 5:
	public static void question5() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input your age: ");
		try {
			int age = scanner.nextInt();
			if (age <= 0) {
				System.err.println("Wrong inputing! The age must be greater than 0, input again.");
			}
		} catch (Exception e) {
			System.err.println("Wrong inputing! Please input an age as int, input again.");
		}
	}

	// Question 6:

	public static int question6() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please input your age: ");
		while (true) {
			try {
				int age = Integer.parseInt(scanner.nextLine().trim());
				if (age < 0) {
					System.out.println("Tuoi phai la so duong. Moi ban nhap lai: ");
					continue;
				} else {
					System.out.println("Your age is: " + age);
					return age;
				}
			} catch (NumberFormatException e) {
				System.err.println("Wrong inputing! Please input an age as int, input again.");
			}
		}
	}

	// Question 7-8:
	public static void question78() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhap id: ");
		int id = ScannerUtils.inputInt(scanner);
		System.out.println("Id cua ban: " + id);

		System.out.println("Nhap diem: ");
		float point = ScannerUtils.inputFloat(scanner);
		System.out.println("Diem cua ban: " + point);

		System.out.println("Nhap money: ");
		double money = ScannerUtils.inputDouble(scanner);
		System.out.println("Money cua ban: " + money);

		System.out.println("Nhap ten: ");
		String name = ScannerUtils.inputString(scanner);
		System.out.println("Ten cua ban: " + name);

		System.out.println("Nhap ten va ho day du: ");
		String fullName = ScannerUtils.inputName(scanner);
		System.out.println("Ten cua ban: " + fullName);
	}
	
	public static void question9() {
		System.out.println("Nhap thong tin department: ");
		Department department = new Department();
		System.out.println(department);
		
		System.out.println("Nhap thong tin position: ");
		Position position = new Position();
		System.out.println(position);
	}
	
	public static void question10() {
		System.out.println("Nhap thong tin group: ");
		Group group = new Group();
		System.out.println(group);	
	}
	
	public static void question1112() {
		System.out.println("Nhap thong tin account: ");
		Account account = new Account();
		System.out.println(account);
		
	}
	
}
