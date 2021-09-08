package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Ex2.HinhChuNhat;
import com.vti.entity.Ex2.HinhVuong;

public class Exercise23 {

	private HinhVuong hv;
	private HinhChuNhat hcn;
	private Scanner scanner;

	public Exercise23() {
		scanner = new Scanner(System.in);
	}

	public void question3() {
		System.out.println("***** Tinh chu vi- dien tich *****");
		System.out.println("1. Hinh Vuong ");
		System.out.println("2. Hinh Chu Nhat ");
		System.out.println("3. Thoat khoi chuong trinh");

		int menuChoose;
		do {
			System.out.println("Moi ban chon chuc nang: (1-3)");
			menuChoose = scanner.nextInt();
			scanner.nextLine();

			switch (menuChoose) {
			case 1:
				hinhVuong();
				break;
			case 2:
				hinhChuNhat();
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

	public void hinhVuong() {
		System.out.println("Nhap vao canh hinh vuong: ");
		float a = scanner.nextFloat();
		hv = new HinhVuong(a);
		System.out.println("Chu vi cua hinh vuong la: " + hv.tinhChuVi());
		System.out.println("Dien tich cua hinh vuong la: " + hv.tinhDienTich());
	}

	public void hinhChuNhat() {
		System.out.println("Nhap vao chieu dai hinh chu nhat (a): ");
		float a = scanner.nextFloat();
		System.out.println("Nhap vao chieu rong hinh chu nhat (b): ");
		float b = scanner.nextFloat();
		hcn = new HinhChuNhat(a, b);
		System.out.println("Chu vi cua hinh vuong la: " + hcn.tinhChuVi());
		System.out.println("Dien tich cua hinh vuong la: " + hcn.tinhDienTich());
	}

}
