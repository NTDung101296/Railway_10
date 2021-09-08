package com.vti.entity.Ex2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Person {
	private String name;
	private Gender gender;
	private LocalDate birthDate;
	private String address;

	public Person() {
	}

	public Person(String name, Gender gender, LocalDate birthDate, String address) {
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void inputInfo() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap thong tin Person tu ban phim: ");
		System.out.println("Nhap ten: ");
		this.name = scanner.nextLine();

		byte gioiTinh;
		do {
			System.out.println("Nhap gioi tinh: 1.Male, 2.Female 3.Unknown");
			gioiTinh = scanner.nextByte();
			switch (gioiTinh) {
			case 1:
				this.gender = Gender.MALE;
				break;
			case 2:
				this.gender = Gender.FEMALE;
				break;
			case 3:
				this.gender = Gender.UNKNOWN;
				break;
			default:
				System.out.println("Moi ban nhap lai! (Gia tri trong khoang 1-3)");
			}
		} while (gioiTinh <= 0 || gioiTinh > 3);
		
		scanner.nextLine();
		System.out.println("Ngay sinh nhap theo dinh dang yyyy-MM-dd:");
		this.birthDate = LocalDate.parse(scanner.nextLine(),DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println("Nhap dia chi: ");
		this.address = scanner.nextLine();
	}

	public String showInfo() {
		return "\n Name= " + name + "\n Gender= " + gender + "\n Birth Date= " + birthDate + "\n Address= "
				+ address;
	}
}
