package hqd.com.ultil;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ScannerUtils {

	private static Scanner scanner = new Scanner(System.in);

	public static int inputId() {
		while (true) {
			int id = inputInt("Please input a id as int, please input again.");
			if (id > 0) {
				return id;
			}
			// else
			System.out.println("Please input a id as int which must be greater than > 0, please input again.");
		}
	}

	public static String inputName() {
		return inputString("Please input a name, please input again.");
	}

	public static float inputFloat(String errorMessage) {
		while (true) {
			try {
				return Float.parseFloat(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static double inputDouble(String errorMessage) {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static String inputString(String errorMessage) {
		while (true) {
			String input = scanner.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			} else {
				System.err.println(errorMessage);
			}
		}
	}

// ----------------------------------------scanner sử dụng regex--------------------------------------
// input mã code của xe ferrari nhập phụ kiện xe( phải có Fer và 5 số và chữ )(I)
	public static String inputCodeFer() {
		String input;
		while (true) {
			input = scanner.nextLine().trim();
			Pattern p = Pattern.compile("^[0-9]{3}+[A-Za-z]{2}$");
			if (p.matcher(input).find() ) {
				System.out.println("ok");
				break;
			} else {
				System.err.println("Mời bạn nhập đúng định dạng");
			}
		}
		return input;

	}
	
	// input mã code của xe ferrari nhập phụ kiện xe( phải có Fer và 5 số và chữ in hoa đằng sau)(I)
		public static String inputFuelEnvironmentalName() {
			String input;
			while (true) {
				input = scanner.nextLine().trim();
				Pattern p = Pattern.compile("^[A-Z]{4}+[0-9]$");				
				if (p.matcher(input).find() ) {
					System.out.println("ok");
					break;
				} else {
					System.err.println("Mời bạn nhập đúng định dạng");
				}
			}
			return input;

		}

	// nhập 4 chữ số đằng sau tên xe(có thể dùng được cho các scanner có yêu cầu phù
	// hợp khác)
	public static String inputIntName() {
		String input;
		while (true) {
			input = scanner.nextLine().trim();
			Pattern p = Pattern.compile("^[0-9]{4}$");
			if (p.matcher(input).find()) {
				System.out.println("ok");
				break;
			} else {
				System.err.println("Mời bạn nhập đúng định dạng");
			}
		}
		return input;
	}

	// price của xe chỉ được giới hạn giá từ (99999 đến 10000- nhập 5 số)
	// (I)
	public static int inputInt() {
		return inputInt("Please input a number as int, please input again");
	}

	// (II)
	public static int inputPrice() {
		while (true) {
			int price = inputInt("Mời bạn nhập đúng định dạng số nguyên.Mời nhập lại!!!");

			if (price < 10000 && price > 99999) {
				System.err.println(" phải nhập 5 con số, mời nhập lại.");

			} else {
				return price;
			}
		}
	}

	// (III)
	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}
	
	

}
