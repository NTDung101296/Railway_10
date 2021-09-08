package com.vti.entity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import com.vti.utils.ScannerUtils;

public class Group {
	private int id;
	private String name;
	private Account creator;
	private LocalDate createDate;
	private Account[] accounts;
	public static int COUNT = 0;
	private static Scanner scanner = new Scanner(System.in);

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", creator=" + creator + ", createDate=" + createDate
				+ ", accounts=" + Arrays.toString(accounts) + "]";
	}

	public Group(String name, Account creator, LocalDate createDate, Account[] accounts) {
		super();
		this.id = ++COUNT;
		this.name = name;
		this.creator = creator;
		this.createDate = createDate;
		this.accounts = accounts;
	}

	public Group() {
		accounts = new Account[1000];
		input();
	}

	private void input() {
		System.out.println("Nhap Id: ");
		id = ScannerUtils.inputInt(scanner);
		System.out.println("Nhap ten Group: ");
		name = ScannerUtils.inputString(scanner);
		System.out.println("Ngay tao Group: ");
		createDate = ScannerUtils.inputLocalDate(scanner);
		confirmAddAccount();

	}

	private void confirmAddAccount() {
		System.out.println("Ban co muon them account khong? (Nhap 1.Co, 2. Khong): ");
		int choose;
		while (true) {
			choose = ScannerUtils.inputPositiveInt(scanner);
			switch (choose) {
			case 1:
				addAccount();
				return;
			case 2:
				return;
			default:
				System.out.println("Chi duoc nhap 1 hoac 2, moi nhap lai: ");
				break;
			}
		}
	}

	private void addAccount() {
		System.out.println("Nhap so luong muon them vao group: ");
		int n = ScannerUtils.inputPositiveInt(scanner);

		for (int i = 0; i < n; i++) {
			accounts[i] = new Account();
		}
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

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

//	public void printInforGroup() {
//		System.out.println("Thong tin Group: ");
//		System.out.println("Group: " + "\nID: " + id + "\nName: " + name + "\nCreateDate: " + createDate);
//		if (accounts != null) {
//			System.out.println("So luong Account trong Group la: " + accounts.length);
//			for (Account account : accounts) {
//				System.out.println(account);
//			}
//		}
//	}

//	public Group() throws InvalidAgeException {
//		System.out.println("Nhap thong tin tao Group: ");
//		this.id = ++COUNT;
//		System.out.println("Nhap ten Group: ");
//		this.name = ScannerUtils.inputName();
//		System.out.println("Nhap ngay tap Group: ");
//		this.createDate = ScannerUtils.inputLocalDate();
//		System.out.println("Ban co muon them Account vao Group hay khong: 1.Co, 2.Khong");
//		while (true) {
//			int choose = ScannerUtils.inputPositiveInt();
//			switch (choose) {
//			case 1:
//				System.out.println("Nhap so luong account muon them vao group nay: ");
//				int countAcc = ScannerUtils.inputPositiveInt();
//				Account[] accs = new Account[countAcc];
//				for (int i = 0; i < countAcc; i++) {
//					System.out.println("Nhap vao Account thu " + (i + 1) + ": ");
//					Account acc = new Account();
//					accs[i] = acc;
//				}
//				this.accounts = accs;
//				return;
//			case 2:
//				return;
//			default:
//				System.out.println("Nhap lai: ");
//				break;
//			}
//		}
//	}

}
