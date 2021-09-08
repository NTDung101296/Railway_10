package com.vti.entity.Ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TuyenSinh implements ITuyenSinh {

	private List<Contestant> contestants;
	private Scanner scanner;

	public TuyenSinh() {
		contestants = new ArrayList<Contestant>();
		scanner = new Scanner(System.in);
	}

	@Override
	public void addConstestant() {
		System.out.println("Nhap vao ten thi sinh: ");
		String name = scanner.nextLine();
		name = chuanHoaChuoi(name);

		System.out.println("Nhap vao dia chi thi sinh: ");
		String address = scanner.nextLine();
		address = chuanHoaChuoi(address);

		System.out.println("Nhap vao muc uu tien cua thi sinh: ");
		int priority = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Nhap vao khoi thi sinh chon cac khoi A,B,C: ");
		String block;
		boolean isBlock = false;
		do {
			block = scanner.nextLine().toUpperCase();
			switch (block) {
			case "A":
				isBlock = true;
				break;
			case "B":
				isBlock = true;
				break;
			case "C":
				isBlock = true;
				break;
			default:
				System.out.println("Nhap sai, moi nhap lai khoi thi sinh A-B-C");
				break;
			}
		} while (isBlock == false);

		Contestant contestant = new Contestant(name, address, priority, new Block(block));
		contestants.add(contestant);
		System.out.println("Them moi thanh cong! ");
	}

	@Override
	public void showInfoConstestant() {
		System.out.println("Thong tin thi sinh du thi: ");

		if (contestants.size() == 0) {
			System.out.println("Danh sach trong!");
		}

		for (Contestant contestant : contestants) {
			System.out.println(contestant);
		}

	}

	@Override
	public void findById(int id) {
		if (contestants.size() == 0) {
			System.out.println("Danh sach trong!");
		}
		boolean isExist = false;
		for (Contestant contestant : contestants) {
			if (contestant.getId() == id) {
				isExist = true;
				System.out.println(contestant);
			}
		}
		if (isExist == false) {
			System.out.println("Khong tim thay!");
		}
		
	}

	// Viet hoa chu cai dau
	public String chuanHoa(String input) {

		// Chuan hoa xau (xoa khoang trang o dau va o cuoi xau)
		input = input.trim();

		// Chuyen xau thanh xau viet thuong
		input = input.toLowerCase();

		// Lay ky tu dau tien cua chuoi
		Character firstCharacter = input.charAt(0);

		// Kiem tra xem ky tu co viet hoa hay chua " Character.isUpperCase()", neu chua
		// viet hoa len
		if (Character.isUpperCase(firstCharacter) == false) {
			firstCharacter = Character.toUpperCase(firstCharacter);
		}

		// Chuyen doi ky tu sang chuoi
		// String output = firstCharacter.toString() + input.substring(1);
		String output = firstCharacter.toString().concat(input.substring(1));

		return output;
	}

	public String chuanHoaChuoi(String input) {
		// Chuan hoa xau (xoa khoang trang o dau va o cuoi xau)
		input = input.trim();

		// Tach chuoi thanh mang cac tu, phan cach boi khoang trang
		// \\s+: dai dien cho 1 hoac nhieu khoang trang
		String[] words = input.split("\\s+");
		String output = "";

		for (int i = 0; i < words.length; i++) {
			words[i] = chuanHoa(words[i]);
			output += words[i] + " ";
		}
		return output;
	}
}
