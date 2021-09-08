package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Ex2.Person;
import com.vti.entity.Ex2.Student2;

public class Exercise22 {
	private Scanner scanner;

	public Exercise22() {
		scanner = new Scanner(System.in);
	}

	public void question2() {
		System.out.println("***** ABSTRACT MANAGEMENT *****");
		System.out.println("1. Demo Person ");
		System.out.println("2. Demo Student ");
		System.out.println("3. Thoat khoi chuong trinh");

		int menuChoose;
		do {
			System.out.println("Moi ban chon chuc nang: (1-3)");
			menuChoose = scanner.nextInt();
			scanner.nextLine();

			switch (menuChoose) {
			case 1:
				demoPerson();
				break;
			case 2:
				demoStudent();
				break;
			case 3:
				System.out.println("Hen gap lai!");
				return;
			default:
				System.out.println("Nhap sai, moi ban nhap lai gia tri tren menu (1-3) !");
				break;
			}
		} while (menuChoose != 3);
	}

	public void demoPerson() {
		Person person = new Person();
		person.inputInfo();
		System.out.println("Thong tin person vua nhap vao:" + person.showInfo());
	}

	public void demoStudent() {
		Student2 student2 = new Student2();
		student2.inputInfo();
		System.out.println("Thong tin person vua nhap vao:" + student2.showInfo());
		if (student2.scholarship() == true) {
			System.out.println("Sinh vien nay dat hoc bong");
		} else {
			System.out.println("Sinh vien nay khong dat hoc bong");
		}
	}

}
