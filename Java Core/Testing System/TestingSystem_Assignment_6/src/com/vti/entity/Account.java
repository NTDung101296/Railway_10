package com.vti.entity;

import java.util.Scanner;

import com.vti.backend.InvalidAgeException;
import com.vti.utils.ScannerUtils;

public class Account {
	private int id;
	private String email;
	private String userName;
	private String fullName;
	private int age;
	public static int COUNT = 0;
	private static Scanner scanner = new Scanner(System.in);

	@Override
	public String toString() {
		return "Account [id=" + id + ", email=" + email + ", userName=" + userName + ", fullName=" + fullName + ", age="
				+ age + "]";
	}

	public Account(String email, String userName, String fullName, int age) {
		super();
		this.id = ++COUNT;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.age = age;
	}

	public Account() {
		super();
		input();
	}

	private void input() {
		System.out.println("Nhap Id: ");
		id = ScannerUtils.inputInt(scanner);
		
		System.out.println("Nhap Email: ");
		email = ScannerUtils.inputEmail(scanner);
		
		System.out.println("Nhap UserName: ");
		userName = ScannerUtils.inputString(scanner);
		
		System.out.println("Nhap Full Name: ");
		fullName = ScannerUtils.inputName(scanner);
		
		System.out.println("Nhap tuoi: ");
		age = inputAccountAge();
	}

	private int inputAge() throws InvalidAgeException {
		int age = ScannerUtils.inputInt(scanner);
		if (age <= 0) {
			throw new InvalidAgeException("The age must be greater than 0, please input again");
		}
		return age;
	}

	private int inputAccountAge() {
		while (true) {
			try {
				int age = inputAge();
				if (age < 18) {
					System.out.println("Your age must be greater than 18, please input again");
				} else {
					return age;
				}
			} catch (InvalidAgeException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}