package com.vti.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.vti.entity.Ex2.Student;

public class Exercise2 {
	private List<Student> students;
	private Scanner scanner;

	public Exercise2() {
		students = new ArrayList<Student>();
		scanner = new Scanner(System.in);
	}

	public void question1() {
		System.out.println("***** QUAN LY STUDENT *****");
		System.out.println("1. Tao danh sach hoc sinh ");
		System.out.println("2. Diem danh ");
		System.out.println("3. Goi nhom 1 di hoc bai");
		System.out.println("4. Goi nhom 2 di don ve sinh");
		System.out.println("5. Hien thi danh sach hoc sinh");
		System.out.println("6. Exit ");

		int menuChoose;

		do {
			System.out.println("Moi ban chon chuc nang: (1-4)");
			menuChoose = scanner.nextInt();
			scanner.nextLine();

			switch (menuChoose) {
			case 1:
				taoDSHS();
				break;
			case 2:
				diemDanh();
				break;
			case 3:
				goiNhom1();
				break;
			case 4:
				goiNhom2();
				break;
			case 5:
				hienThiDSHS();
				break;
			case 6:
				System.out.println("Hen gap lai!");
				return;
			default:
				System.out.println("Nhap sai, moi ban nhap lai gia tri tren menu (1-6) !");
				break;
			}
		} while (menuChoose != 6);
	}

	public void taoDSHS() {
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			Student student = new Student(" Hoc sinh thu " + (i + 1), random.nextInt(3) + 1);
			students.add(student);
		}
		System.out.println("Tao thanh cong 10 hoc sinh va chia lam 3 nhom!");
	}

	public void diemDanh() {
		System.out.println("Ca lop diem danh: ");
		for (Student student : students) {
			student.diemDanh();
		}
	}

	public void goiNhom1() {
		System.out.println("Nhom 1 di hoc bai:");
		for (Student student : students) {
			if (student.getGroup() == 1) {
					student.hocBai();		
			}
		}
	}

	public void goiNhom2() {
		System.out.println("Nhom 1 di don ve sinh:");
		for (Student student : students) {
			if (student.getGroup() == 2) {
					student.donVeSinh();;		
			}
		}
	}

	public void hienThiDSHS() {
		System.out.println("Danh sach hoc sinh: ");
		if (students.size() == 0) {
			System.out.println("Danh sach trong!");
		}
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
