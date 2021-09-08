package com.vti.backend;

import java.util.Scanner;

import com.vti.entity.Ex2.MyMath;

public class Exercise24 {

	Scanner scanner;
	MyMath myMath;

	public Exercise24() {
		scanner = new Scanner(System.in);
		myMath = new MyMath();
	}

	public void question4() {
		System.out.println("***** TINH TONG *****");
		System.out.println("1. Tinh tong 2 so kieu int ");
		System.out.println("2. Tinh tong 2 so kieu byte ");
		System.out.println("3. Tinh tong 2 so kieu int va byte ");
		System.out.println("4. Tinh tong 2 so kieu float ");
		System.out.println("5. Tinh tong 2 so kieu float va byte ");
		System.out.println("6. Tinh tong 2 so kieu float va int ");
		System.out.println("7. Exit ");

		int menuChoose;

		do {
			System.out.println("Moi ban chon chuc nang: (1-7)");
			menuChoose = scanner.nextInt();
			scanner.nextLine();

			switch (menuChoose) {
			case 1:
				sumInt();
				break;
			case 2:
				sumByte();
				break;
			case 3:
				sumIntByte();
				break;
			case 4:
				sumFloat();
				break;
			case 5:
				sumFloatByte();
				break;
			case 6:
				sumFloatInt();
				break;	
			case 7:
				System.out.println("Hen gap lai!");
				return;
			default:
				System.out.println("Nhap sai, moi ban nhap lai gia tri tren menu (1-6) !");
				break;
			}
		} while (menuChoose != 7);
	}
	
	public void sumInt() {
		System.out.println("Nhap vao so int 1: ");
		int i1 = scanner.nextInt();
		System.out.println("Nhap vao so int 2: ");
		int i2 = scanner.nextInt();
		System.out.println("Tong 2 so la: " + myMath.sum(i1, i2));
	}
	
	public void sumByte() {
		System.out.println("Nhap vao so byte 1: ");
		byte b1 = scanner.nextByte();
		System.out.println("Nhap vao so byte 2: ");
		byte b2 = scanner.nextByte();
		System.out.println("Tong 2 so la: " + myMath.sum(b1, b2));
	}
	
	public void sumIntByte() {
		System.out.println("Nhap vao so int 1: ");
		int i1 = scanner.nextInt();
		System.out.println("Nhap vao so byte 2: ");
		byte b2 = scanner.nextByte();
		System.out.println("Tong 2 so la: " + myMath.sum(i1, b2));
	}
	
	public void sumFloat() {
		System.out.println("Nhap vao so float 1: ");
		float f1 = scanner.nextFloat();
		System.out.println("Nhap vao so float 2: ");
		float f2 = scanner.nextFloat();
		System.out.println("Tong 2 so la: " + myMath.sum(f1, f2));
	}
	
	public void sumFloatByte() {
		System.out.println("Nhap vao so float 1: ");
		float f1 = scanner.nextFloat();
		System.out.println("Nhap vao so byte 2: ");
		byte b2 = scanner.nextByte();
		System.out.println("Tong 2 so la: " + myMath.sum(f1, b2));
	}
	
	public void sumFloatInt() {
		System.out.println("Nhap vao so float 1: ");
		float f1 = scanner.nextFloat();
		System.out.println("Nhap vao so int 2: ");
		int i2 = scanner.nextInt();
		System.out.println("Tong 2 so la: " + myMath.sum(f1, i2));
	}
	

}
