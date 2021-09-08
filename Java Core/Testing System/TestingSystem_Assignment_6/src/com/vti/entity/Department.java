package com.vti.entity;

import java.util.Scanner;

import com.vti.utils.ScannerUtils;

public class Department {
	private int id;
	private String name;
	public static int COUNT = 0;
	private static Scanner scanner = new Scanner(System.in);;

	public Department(String name) {
		super();
		this.id = ++COUNT;
		this.name = name;
	}

	public Department() {
		input();
	}

	private void input() {
		System.out.println("Nhap id: ");
		id = ScannerUtils.inputInt(scanner);

		System.out.println("Nhap ten phong ban: ");
		name = ScannerUtils.inputName(scanner);
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
