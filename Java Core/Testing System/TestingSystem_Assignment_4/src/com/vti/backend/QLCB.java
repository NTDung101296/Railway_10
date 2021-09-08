package com.vti.backend;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import com.vti.entity.CanBo;
import com.vti.entity.CongNhan;
import com.vti.entity.Gender;
import com.vti.entity.KySu;
import com.vti.entity.NhanVien;

public class QLCB {

	// Khai bao ArrayList
	private static List<CanBo> canBos ;
	//Khoi tao duy nhat 1 lan, sd xuyen suot chuong trinh
	
	public QLCB() {
		canBos = new ArrayList<CanBo>();	
	}

//	public void menu() {
//		Scanner scanner = new Scanner(System.in);
//
//		boolean isFunction = false;
//
//		do {
//			System.out.println("***** PHAN MEM QUAN LY CAN BO *****");
//			System.out.println("1. Them moi can bo");
//			System.out.println("2. Tim kiem theo ho ten");
//			System.out.println("3. Hien thi thong tin ve danh sach can bo");
//			System.out.println("4. Nhap vao ten can bo va xoa can bo do");
//			System.out.println("5. Thoat khoi chuong trinh");
//
//			int menuChoose = scanner.nextInt();
//			switch (menuChoose) {
//			case 1:
//				themCanBo();
//				isFunction = true;
//				break;
//			case 2:
//				timKiemCanBo();
//				isFunction = true;
//				break;
//			case 3:
//				hienThiDanhSachCanBo();
//				isFunction = true;
//				break;
//			case 4:
//				xoaCanBoTheoTen();
//				isFunction = true;
//				break;
//			case 5:
//				return;
//			default:
//				System.out.println("Nhap sai, moi ban nhap lai theo so tren menu!");
//				break;
//			}
//		} while (isFunction == false);
//
//	}

	public void themCanBo() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ban muon them loai can bo nao");
		System.out.println("1- Cong Nhan");
		System.out.println("2- Ky Su");
		System.out.println("3- Nhan Vien");

		byte loaiCanBo = scanner.nextByte();

		boolean isLoaiCanBo = false;

		do {
			switch (loaiCanBo) {
			case 1:
				themCongNhan();
				isLoaiCanBo = true;
				break;
			case 2:
				themKySu();
				isLoaiCanBo = true;
				break;
			case 3:
				themNhanVien();
				isLoaiCanBo = true;
				break;
			default:
				System.out.println("Moi ban nhap lai! (Gia tri trong khoang 1-3)");
				break;
			}
		} while (isLoaiCanBo == false);

	}

	public void timKiemCanBo() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ban muon tim kiem loai can bo nao");
		System.out.println("1- Cong Nhan");
		System.out.println("2- Ky Su");
		System.out.println("3- Nhan Vien");

		byte loaiCanBo = scanner.nextByte();

		boolean isLoaiCanBo = false;

		do {
			switch (loaiCanBo) {
			case 1:
				timKiemCongNhanTheoTen();
				isLoaiCanBo = true;
				break;
			case 2:
				timKiemKySuTheoTen();
				isLoaiCanBo = true;
				break;
			case 3:
				timKiemNhanVienTheoTen();
				isLoaiCanBo = true;
				break;
			default:
				System.out.println("Moi ban nhap lai! (Gia tri trong khoang 1-3)");
				break;
			}
		} while (isLoaiCanBo == false);

	}

	public Gender nhapGioiTinh() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		byte gioiTinh;
//		Gender gender = null;

		// boolean isGioiTinh = false;
		do {
			System.out.println("Moi ban nhap vao gioi tinh: (1- Nam, 2- Nu, 3- Khac)");
			gioiTinh = scanner.nextByte();

			switch (gioiTinh) {
			case 1:
				// isGioiTinh = true;
				return Gender.MALE;
			case 2:
				// isGioiTinh = true;
				return Gender.FEMALE;
			case 3:
				// isGioiTinh = true;
				return Gender.UNKNOWN;
			default:
				System.out.println("Moi ban nhap lai! (Gia tri trong khoang 1-3)");
			}
		} while (gioiTinh <= 0 || gioiTinh > 3);
		return Gender.MALE;// de mac dinh 1 gioi tinh nao do
	}

	public void themCongNhan() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Moi ban nhap ID: ");
		short id = scanner.nextShort();
		scanner.nextLine();

		System.out.println("Moi ban nhap ten: ");
		String name = scanner.nextLine();

		System.out.println("Moi ban nhap tuoi: ");
		byte age = scanner.nextByte();
		scanner.nextLine();

		Gender gender = nhapGioiTinh();

		System.out.println("Moi ban nhap dia chi: ");
		String address = scanner.nextLine();

		byte bac;
		do {
			System.out.println("Nhap vao bac cua cong nhan: (1-10) ");
			bac = scanner.nextByte();

			if (bac < 1 || bac > 10) {
				System.out.println("Ban nhap sai! Moi ban nhap lai");
			}
		} while (bac < 1 || bac > 10);

		CongNhan congNhan = new CongNhan(id, name, age, gender, address, bac);
		canBos.add(congNhan);
		System.out.println("Them thanh cong! \n" + congNhan);
	}

	public void themKySu() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Moi ban nhap ID: ");
		short id = scanner.nextShort();
		scanner.nextLine();

		System.out.println("Moi ban nhap ten: ");
		String name = scanner.nextLine();

		System.out.println("Moi ban nhap tuoi: ");
		byte age = scanner.nextByte();
		scanner.nextLine();

		Gender gender = nhapGioiTinh();

		System.out.println("Moi ban nhap dia chi: ");
		String address = scanner.nextLine();

		System.out.println("Nhap vao nganh dao tao cua ky su: ");
		String nganhDaoTao = scanner.nextLine();

		KySu kySu = new KySu(id, name, age, gender, address, nganhDaoTao);
		canBos.add(kySu);
		System.out.println("Them thanh cong! \n" + kySu);

	}

	public void themNhanVien() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Moi ban nhap ID: ");
		short id = scanner.nextShort();
		scanner.nextLine();

		System.out.println("Moi ban nhap ten: ");
		String name = scanner.nextLine();

		System.out.println("Moi ban nhap tuoi: ");
		byte age = scanner.nextByte();
		scanner.nextLine();

		Gender gender = nhapGioiTinh();

		System.out.println("Moi ban nhap dia chi: ");
		String address = scanner.nextLine();

		System.out.println("Nhap vao cong viec cua nhan vien: ");
		String congViec = scanner.nextLine();

		NhanVien nhanVien = new NhanVien(id, name, age, gender, address, congViec);
		canBos.add(nhanVien);
		
		System.out.println("Them thanh cong! \n" + nhanVien);

	}

//	public CanBo timKiemTheoTen(String name) {
//		name = name.trim().toLowerCase();
////		Scanner scanner = new Scanner(System.in);
////		System.out.println("Nhap vao ten muon tim kiem: ");
////		String findName = scanner.nextLine();
//		for (CanBo canBo : canBos) {
//			if (canBo.getName().toLowerCase().equals(name)) {
////				System.out.println(canBo);
//				return canBo;
//			}
//		}
//		return null;
//	}

	public void timKiemCongNhanTheoTen() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao ten muon tim kiem: ");
		String name = scanner.nextLine();
		name = name.trim().toLowerCase();
		
		boolean isExist = false;

		for (CanBo congNhan : canBos) {
			if (congNhan.getName().toLowerCase().equals(name)) {
				isExist = true;
				System.out.println((CongNhan) congNhan);
			}
		}
		if (isExist == false) {
			System.out.println("Khong tim thay!");
		}
		
	}

	public void timKiemKySuTheoTen() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao ten muon tim kiem: ");
		String name = scanner.nextLine();
		name = name.trim().toLowerCase();

		boolean isExist = false;
		
		for (CanBo kySu : canBos) {
			if (kySu.getName().toLowerCase().equals(name)) {
				isExist = true;
				System.out.println((KySu) kySu);
			}
		}
		if (isExist == false) {
			System.out.println("Khong tim thay!");
		}
	}

	public void timKiemNhanVienTheoTen() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao ten muon tim kiem: ");
		String name = scanner.nextLine();
		name = name.trim().toLowerCase();
		
		boolean isExist = false;

		for (CanBo nhanVien : canBos) {
			if (nhanVien.getName().toLowerCase().equals(name)) {
				isExist = true;
				System.out.println((NhanVien) nhanVien);
			}
		}
		if (isExist == false) {
			System.out.println("Khong tim thay!");
		}
	}

	public void hienThiDanhSachCanBo() {
//		for (CanBo canBo : canBos) {
//			System.out.println(canBo);
//		}
		if (canBos.size() == 0) {
			System.out.println("Danh sach trong!");
		}

		for (int i = 0; i < canBos.size(); i++) {
			if (canBos.get(i) instanceof CongNhan) {
				System.out.println(canBos.get(i));
			} else if (canBos.get(i) instanceof KySu) {
				System.out.println(canBos.get(i));
			} else {
				System.out.println(canBos.get(i));
			}
		}
	}

	public void xoaCanBoTheoTen() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao ten can bo can xoa: ");
		String name = scanner.nextLine();
		name = name.trim().toLowerCase();

		boolean isExist = false;

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Nhap ten can xoa thong tin: ");
//		String deleteName = scanner.nextLine();
		for (CanBo canBo : canBos) {
			if (canBo.getName().toLowerCase().equals(name)) {
				canBos.remove(canBo);
				System.out.println("Xoa thanh cong!");
				isExist = true;
				break; // xoa 1 ban ghi
			}
		}
		if (isExist == false) {
			System.out.println("Khong tim thay can bo co ten la: " + name);
		}

	}
}
