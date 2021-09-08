package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Ex1.TuyenSinh;

public class QLTS {
	private TuyenSinh tuyenSinh;
	private Scanner scanner;

	public QLTS() {
		tuyenSinh = new TuyenSinh();
		scanner = new Scanner(System.in);
	}

	public void question2() {
		System.out.println("***** TUYEN SINH *****");
		System.out.println("1. Them moi thi sinh ");
		System.out.println("2. Hien thi thong tin thi sinh ");
		System.out.println("3. Tim kiem theo so bao danh ");
		System.out.println("4. Thoat khoi chuong trinh");

		int menuChoose;
		do {
			System.out.println("Moi ban chon chuc nang: (1-4)");
			menuChoose = scanner.nextInt();
			scanner.nextLine();

			switch (menuChoose) {
			case 1:
				tuyenSinh.addConstestant();
				break;
			case 2:
				tuyenSinh.showInfoConstestant();
				break;
			case 3:
				System.out.println("Nhap vao ID can tim kiem: ");
				int id = scanner.nextInt();
				tuyenSinh.findById(id);
				break;
			case 4:
				System.out.println("Hen gap lai!");
				return;
			default:
				System.out.println("Nhap sai, moi ban nhap lai gia tri tren menu (1-4) !");
				break;
			}
		} while (menuChoose != 4);
	}
}
