package com.vti.frontend;

import java.util.Scanner;

import com.vti.backend.Exercise5;
import com.vti.backend.QLCB;
import com.vti.backend.QLTV;

public class Program5 {

	public static void main(String[] args) {
		//Question 1-2
		menuQLCB();
		// Question 3
		Exercise5 exercise5 = new Exercise5();
		exercise5.Question3();
		
		//Question 4
		menuQLTV();
	}

	public static void menuQLCB() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("***** PHAN MEM QUAN LY CAN BO *****");
		System.out.println("1. Them moi can bo");
		System.out.println("2. Tim kiem theo ho ten");
		System.out.println("3. Hien thi thong tin ve danh sach can bo");
		System.out.println("4. Nhap vao ten can bo va xoa can bo do");
		System.out.println("5. Thoat khoi chuong trinh");

		QLCB qlcb = new QLCB();
		int chucNang;

		do {
			System.out.println("Moi ban chon chuc nang: (1-5)");
			chucNang = scanner.nextInt();
			switch (chucNang) {
			case 1:
				qlcb.themCanBo();
				break;
			case 2:
				qlcb.timKiemCanBo();
				break;
			case 3:
				qlcb.hienThiDanhSachCanBo();
				break;
			case 4:
				qlcb.xoaCanBoTheoTen();
				break;
			case 5:
				System.out.println("Hen gap lai ban lan sau!");
				return;
			default:
				System.out.println("Nhap sai, moi ban nhap lai theo so tren menu!");
				break;
			}
		} while (chucNang != 5);
	}

	public static void menuQLTV() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("***** PHẦN MỀM QUẢN LÝ THƯ VIỆN *****");
		System.out.println("1. Thêm mới tài liệu ");
		System.out.println("2. Xoá tài liệu theo mã tài liệu ");
		System.out.println("3. Hiển thị thông tin về tài liệu ");
		System.out.println("4. Tìm kiếm tài liệu ");
		System.out.println("5. Thoát khỏi chương trình ");

		QLTV qltv = new QLTV();
		int menuChoose;

		do {
			System.out.println("Mời bạn chọn chức năng: (1-5)");
			menuChoose = scanner.nextInt();
			switch (menuChoose) {
			case 1:
				qltv.addDocument();
				break;
			case 2:
				qltv.deleteDocument();
				break;
			case 3:
				qltv.printDocuments();
				break;
			case 4:
				qltv.findByCategory();
				break;
			case 5:
				System.out.println("Hẹn gặp lại bạn lần sau!");
				return;
			default:
				System.out.println("Nhập sai, mời bạn nhập lại theo số trên menu (1-5) !");
				break;
			}
		} while (menuChoose != 5);
	}
}
