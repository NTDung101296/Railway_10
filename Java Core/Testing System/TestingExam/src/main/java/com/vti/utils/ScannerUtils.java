package com.vti.utils;

import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUtils {
	private static Scanner scanner = new Scanner(System.in);

	public static int inputFunction(int a, int b, String errorMessage) {
		while (true) {
			int number = ScannerUtils.inputInt(errorMessage);
			if (number >= a && number <= b) {
				return number;
			} else {
				System.err.println(errorMessage);
			}
		}
	}

	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine().trim());
			} catch (NumberFormatException e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static int inputInt() {
		return inputInt("Please input a number as int, please input again.");
	}

	public static int inputId() {
		while (true) {
			int id = inputInt("Please input a id as int, please input again.");
			if (id > 0) {
				return id;
			} else {
				System.err.println("Please input a id as int which must be greater (>) than 0, please input again.");
			}
		}
	}

	public static String inputString(String errorMessage) {
		while (true) {
			String input = scanner.nextLine().trim();
			input = input.replaceAll("\\s+", " ");
			if (!input.isEmpty()) {
				return input;
			} else {
				System.err.println(errorMessage);
			}
		}
	}

	public static String inputName() {
		return inputString("Please input a name, please input again.");
	}

	public static boolean isAlpha(String name) {
		return name.matches("[a-zA-Z]+");
	}

	// NHẬP VÀO TÊN VÀ CHUẨN HÓA TÊN, FULLNAME CHỈ CHỨA CHỮ KHÔNG CHỨA KÝ TỰ ĐẶC
	// BIỆT VÀ SỐ
	public static String inputfullName(String errorMessage) {
		while (true) {
			String fullName = ScannerUtils.inputName();
			String[] words = fullName.split(" ");
			fullName = "";
			for (String word : words) {

				String firstCharacter = word.substring(0, 1).toUpperCase();
				String leftCharacter = word.substring(1).toLowerCase();
				word = firstCharacter + leftCharacter;
				fullName += word + " ";
			}
			fullName = fullName.trim();
			if (isAlpha(fullName)) {
				return fullName;
			} else {
				System.err.println(errorMessage);
				System.out.println("Please input fullname again: ");
			}
		}
	}

	public static String inputEmail(String errorMessage) {
		while (true) {
			String email = ScannerUtils.inputString(errorMessage);
			if (email == null || !email.contains("@gmail.com")) {
				System.err.print(errorMessage);
				System.out.println("Re-enter email:");
			} else {
				return email;
			}
		}
	}

	public static String inputPassword(String errorMessage) {
		while (true) {
			String password = ScannerUtils.inputString(errorMessage);
			if (password.length() < 6 || password.length() > 12) {
				System.err.println(errorMessage);
				System.out.print("Please input password again: ");
				continue;
			}

			boolean hasAtLeast1Character = false;
			for (int i = 0; i < password.length(); i++) {
				if (Character.isUpperCase(password.charAt(i)) == true) {
					hasAtLeast1Character = true;
					break;
				}
			}
			if (hasAtLeast1Character == true) {
				return password;
			} else {
				System.err.println(errorMessage);
				System.out.print("Re-enter password: ");
			}
		}
	}

	public static String inputPhoneNumber(String errorMessage) {
		while (true) {
			String number = ScannerUtils.inputString(errorMessage);
			if (number.length() > 12 || number.length() < 9) {
				System.err.println(errorMessage);
				continue;
			}

			if (number.charAt(0) != '0') {
				System.err.println(errorMessage);
				continue;
			}

			boolean isNumber = true;
			for (int i = 0; i < number.length(); i++) {
				if (Character.isDigit(number.charAt(i)) == false) {
					isNumber = false;
					break;
				}
			}
			if (isNumber == true) {
				return number;
			} else {
				System.out.println(errorMessage);
				System.out.print("Please input phone number again: ");
			}
		}
	}

	public static int inputPositiveInt(String errorMessage) {
		while (true) {
			int i = ScannerUtils.inputInt(errorMessage);
			if (i < 0) {
				System.err.println(errorMessage);
			} else {
				return i;
			}
		}
	}

	public static byte inputByte(String errorMessage) {
		while (true) {
			try {
				return Byte.parseByte(scanner.nextLine().trim());
			} catch (NumberFormatException e) {
				System.err.println(errorMessage);
			}
		}
	}
	
	public static float inputFloat(String errorMessage) {
		while (true) {
			try {
				return Float.parseFloat(scanner.nextLine().trim());
			} catch (NumberFormatException e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static double inputDouble(String errorMessage) {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (NumberFormatException e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static LocalDate inputLocalDate(String errorMessage) {
		while (true) {
			try {
				return LocalDate.parse(scanner.nextLine());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

}
