package com.vti.entity.Ex2;

import java.util.Scanner;


public class Student2 extends Person {
	private int id;
	private float gradeAvg;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getGradeAvg() {
		return gradeAvg;
	}

	public void setGradeAvg(float gradeAvg) {
		this.gradeAvg = gradeAvg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void inputInfo() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		super.inputInfo();
		System.out.println("Nhap ID: ");
		this.id = scanner.nextInt();
		System.out.println("Nhap diem TB: ");
		this.gradeAvg = scanner.nextFloat();
		scanner.nextLine();
		System.out.println("Nhap Email: ");
		this.email = scanner.nextLine();
	}

	public String showInfo() {
		return super.showInfo() + "\n ID= " + id + "\n GradeAvg= " + gradeAvg + "\n Email= " + email;
	}

	public boolean scholarship() {
		return gradeAvg > 8.0 ? true : false;
	}

}
