package com.vti.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUtils {

	public static int inputInt(Scanner scanner) {
		while (true) {
			try {
				String input = scanner.nextLine().trim();
				int output = Integer.parseInt(input);
				return output;
			} catch (NumberFormatException e) {
				System.err.println("Chuoi ban nhap khong phai so nguyen. Moi ban nhap lai!");
			}
		}
	}

	public static int inputPositiveInt(Scanner scanner) {
		while (true) {
			try {
				String input = scanner.nextLine().trim();
				int output = Integer.parseInt(input);
				if (output < 0) {
					System.out.println("Gia tri phai la so duong!");
					continue;
				}
				return output;
			} catch (NumberFormatException e) {
				System.err.println("Chuoi ban nhap khong phai so nguyen duong. Moi ban nhap lai!");
			}
		}
	}

	public static float inputFloat(Scanner scanner) {
		while (true) {
			try {
				String input = scanner.nextLine().trim();
				float output = Float.parseFloat(input);
				return output;
			} catch (NumberFormatException e) {
				System.err.println("Chuoi ban nhap khong phai so thuc. Moi ban nhap lai!");
			}
		}
	}

	public static double inputDouble(Scanner scanner) {
		while (true) {
			try {
				String input = scanner.nextLine().trim();
				double output = Double.parseDouble(input);
				return output;
			} catch (NumberFormatException e) {
				System.err.println("Chuoi ban nhap khong phai so thuc. Moi ban nhap lai!");
			}
		}
	}

	public static String inputString(Scanner scanner) {
		while (true) {
			String input = scanner.nextLine().trim();
			input = input.replaceAll("\\s+", " ");
			if (!input.isEmpty()) {// input.isEmpty() == false
				return input;
			} else {
				System.out.println("Nhap lai!");
			}
		}
	}

	// Nhap vao ten va chuan hoa ten
	public static String inputName(Scanner scanner) {
		while (true) {
			String name = ScannerUtils.inputString(scanner);
			String[] words = name.split("\\s+");
			name = "";
			for (String word : words) {
				String firstCharacter = word.substring(0, 1).toUpperCase();
				String leftCharacter = word.substring(1).toLowerCase();
				word = firstCharacter + leftCharacter;
				name += word + " ";
			}
			return name.trim();
		}
	}

	public static LocalDate inputLocalDate(Scanner scanner) {
		System.out.println("Nhap theo dinh dang yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		while (true) {
			String localDate = scanner.nextLine().trim();
			try {
				if (format.parse(localDate) != null) {
					LocalDate lc = LocalDate.parse(localDate);
					return lc;
				}
			} catch (Exception e) {
				System.err.println("Nhap lai: ");
			}
		}
	}

	public static String inputEmail(Scanner scanner) {
		while (true) {
			String email = scanner.nextLine();
			if (email.contains("@") == false) {// (!email.contains("@"))
				System.err.print("Email ban nhap khong dung dinh dang, moi ban nhap lai: ");
			} else {
				return email;
			}
		}
	}

}
