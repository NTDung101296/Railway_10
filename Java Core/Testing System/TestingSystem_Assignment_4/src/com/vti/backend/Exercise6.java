package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Ex6.VietnamesePhone;


public class Exercise6 {
	VietnamesePhone vnPhone;
	Scanner scanner;

	public Exercise6() {
		vnPhone = new VietnamesePhone();
		scanner = new Scanner(System.in);
	}

	public void menuPhone() {

		System.out.println("***** QUAN LY THONG TIN LIEN LAC *****");
		System.out.println("1. Them moi");
		System.out.println("2. Xoa");
		System.out.println("3. Cap nhat");
		System.out.println("4. Tim kiem");
		System.out.println("5. Hien thi thong tin lien lac");
		System.out.println("6. Thoat khoi chuong trinh");
		int choose;

		do {
			System.out.println("Moi ban chon chuc nang: (1-6)");
			choose = scanner.nextInt();
			switch (choose) {
			case 1:
				insertContact();
				break;
			case 2:
				removeContact();
				break;
			case 3:
				updateContact();
				break;
			case 4:
				searchContact();
				break;
			case 5:
				vnPhone.printContact();
				return;
			case 6:
				System.out.println("Hen gap lai ban lan sau!");
				return;
			default:
				System.out.println("Nhap sai, moi ban nhap lai!");
				break;
			}
		} while (choose != 6);
	}

	public void insertContact() {
		System.out.println("Nhap vao ten contact: ");
		String name = scanner.nextLine();
		scanner.nextLine();
		
		System.out.println("Nhap vao so Phone: ");
		String phone = scanner.nextLine();
		vnPhone.insertContact(name, phone);

		System.out.println("Them moi thanh cong!");
	}

	public void removeContact() {
		System.out.println("Nhap vao ten contact can xoa: ");
		String nameRemove = scanner.nextLine();
		nameRemove= nameRemove.trim().toLowerCase();
		vnPhone.removeContact(nameRemove);

		System.out.println("Xoa thanh cong!");
	}

	public void updateContact() {
		System.out.println("Nhap vao ten contact can cap nhat: ");
		String nameUpdate = scanner.nextLine();
		nameUpdate = nameUpdate.trim().toLowerCase();
		scanner.nextLine();
		
		System.out.println("Nhap vao so Phone moi: ");
		String newPhone = scanner.nextLine();
		vnPhone.updateContact(nameUpdate, newPhone);

		System.out.println("Cap nhat thanh cong!");
	}

	public void searchContact() {
		System.out.println("Nhap vao ten contact can tim kiem: ");
		String nameSearch = scanner.nextLine();
		nameSearch = nameSearch.trim().toLowerCase();
		vnPhone.searchContact(nameSearch);
	}

}
