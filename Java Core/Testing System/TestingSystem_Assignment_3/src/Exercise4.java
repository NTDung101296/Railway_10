import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Exercise4 {

	public static void main(String[] args) {
		// Question 1: Nhap vao 1 xau ki tu, dem so luong

		// Question 2: Nhap hai xau ki tu s1,s2. Noi xau s2 vao sau xau s1

		// Question 3: Nhap vao ten, kiem tra va viet hoa chu cai dau

		// Question 4: Nhap vao ten va in tung ki tu

		// Question 5: Nhap vao ho va in, in ra ho va ten day du

		// Question 6: Tach ho, ten va ten dem

		// Question 7: Chuan hoa ho va ten

		// Question 8: In ra tat ca group co chua chu Java

		// Question 9: In ra tat ca group "Java"

		// Question 10: Kiem tra 2 chuoi co phai la dao nguoc cua nhau khong
//		boolean isReverse = question10("hien", "neih");
//		if (isReverse == true) {
//			System.out.println("Hai chuoi la nghich dao cua nhau");
//		} else {
//			System.out.println("Hai chuoi ko la nghich dao cua nhau");
//		}

		// Question 11: Count special character, so lan xuat hien ky tu a trong chuoi

		// Question 12: Dao nguoc chuoi sd vong lap
		// System.out.println(Question12("Nguyen Trung Dung "));
		// Ma hoa bao mat

		// Question 13: Kiem tra 1 chuoi co chua chu so hay khong

		// Question 14: Chuyen ky tu duoc chi dinh sang 1 ky tu khac cho truoc

		// Question 15: Dao nguoc cac ky tu cua chuoi

		// Question 16: Chia chuoi lam cac phan bang nhau
		System.out.println(Question16("Nguyen Trung Dung", (byte) 2));

	}

	public static void Q1() {
		Scanner sc1 = new Scanner(System.in);
		String s1;

		System.out.println("Moi ban nhap chuoi: ");
		s1 = sc1.nextLine();

		if (s1.isEmpty()) {
			System.out.println("Khong co ki tu nao");
		} else {
			StringTokenizer stringTokenizer = new StringTokenizer(s1);
			int countString = stringTokenizer.countTokens();
			System.out.println("So tu co trong chuoi \" " + s1 + "\" = " + countString);
		}
		sc1.close();
	}

	// Cach khac cua question 1
	public static void Question1() {
		Scanner scanner = new Scanner(System.in);
		String input;

		System.out.println("Moi ban nhap vao 1 chuoi: ");
		input = scanner.nextLine();

		// Buoc 1: Chuan hoa xau (xoa khoang trang o dau va o cuoi xau)
		input = input.trim();
		// System.out.println(input);

		// Buoc 2: Tach chuoi thanh mang cac tu, phan cach boi khoang trang
		// \\s+: dai dien cho 1 hoac nhieu khoang trang
		String[] words = input.split("\\s+");
//		for (String word : words) {
//			System.out.println(word);
//		}

		// Buoc 3: In ra man hinh so tu cua chuoi
		System.out.println("So luong tu trong chuoi: " + words.length);

		scanner.close();
	}

	public static void Q2() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Nhap chuoi ki tu thu nhat: ");
		String s1 = sc2.nextLine();

		System.out.println("Nhap chuoi ki tu thu hai: ");
		String s2 = sc2.nextLine();

		System.out.println(s1 + " " + s2);
		sc2.close();
	}

	public static void Q3() {
		Scanner sc3 = new Scanner(System.in);
		System.out.println("Moi ban nhap vao ten: ");
		String name = sc3.nextLine();
		String firstChar = name.substring(0, 1).toUpperCase();
		String sideChar = name.substring(1);
		name = firstChar + sideChar;
		System.out.println("Ten: " + name);
		sc3.close();
	}

	// Cach khac cua cau 3
	public static void Question3() {
		Scanner scanner = new Scanner(System.in);
		String input;

		System.out.println("Moi ban nhap vao 1 chuoi: ");
		input = scanner.nextLine();

		// Chuan hoa xau (xoa khoang trang o dau va o cuoi xau)
		input = input.trim();

		// Lay ky tu dau tien cua chuoi
		Character firstCharacter = input.charAt(0);

		// Kiem tra xem ky tu co viet hoa hay chua " Character.isUpperCase()", neu chua
		// viet hoa len
		if (Character.isUpperCase(firstCharacter) == false) {
			firstCharacter = Character.toUpperCase(firstCharacter);
		}

		// Chuyen doi ky tu sang chuoi
		String output = firstCharacter.toString() + input.substring(1);
		// Hoac: String output1 = firstCharacter.toString().concat(input.substring(1));
		System.out.println("Output: " + output);

		scanner.close();

	}

	public static void Q4() {
		Scanner sc4 = new Scanner(System.in);
		System.out.println("Nhap vao ten: ");
		String name = sc4.nextLine();
		name = name.toUpperCase();
		for (int i = 0; i < name.length(); i++) {
			System.out.println("Ki tu thu " + (i + 1) + " la: " + name.charAt(i));
		}
		sc4.close();
	}

	// Cach khac cua cau 4
	public static void Question4() {
		Scanner scanner = new Scanner(System.in);
		String input;

		System.out.println("Moi ban nhap vao 1 chuoi: ");
		input = scanner.nextLine();

		// Chuan hoa xau (xoa khoang trang o dau va o cuoi xau)
		input = input.trim();
		// Viet hoa tat ca cac chu
		input = input.toUpperCase();

		// Chuyen doi chuoi thanh mang ky tu
		char[] charArrays = input.toCharArray();
		for (char c : charArrays) {
			System.out.println(c);
		}
		scanner.close();
	}

	public static void Q5() {
		Scanner sc5 = new Scanner(System.in);
		System.out.println("Nhap vao ho: ");
		String lastName = sc5.nextLine();
		System.out.println("Nhap vao ten: ");
		String firstName = sc5.nextLine();

		System.out.println("Ho va ten da nhap: " + lastName.concat(firstName));
		sc5.close();
	}

	public static void Q6() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao ho va ten: ");
		String fullName = sc.nextLine();

		// Chuan hoa xau, bo khoang trang bat dau va ket thuc
		fullName = fullName.trim();

		String[] strs = fullName.split("\\s+");// tach chuoi dua tren khoang trang

		String lastName = strs[0];
		String firstName = strs[strs.length - 1];
		String middleName = "";
		for (int i = 1; i <= strs.length - 2; i++) {
			middleName += strs[i] + " ";
		}

		System.out.println("Ho la: " + lastName);
		System.out.println("Ten dem la: " + middleName);
		System.out.println("Ten la: " + firstName);

		sc.close();
	}

	// Cach khac cau 6:
	public static String question3(String input) {

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

	public static void Question6() {
		Scanner scanner = new Scanner(System.in);
		String input;

		System.out.println("Moi ban nhap vao ho va ten: ");
		input = scanner.nextLine();

		// Chuan hoa xau (xoa khoang trang o dau va o cuoi xau)
		input = input.trim();

		// Tach chuoi thanh mang cac tu, phan cach boi khoang trang
		// \\s+: dai dien cho 1 hoac nhieu khoang trang
		String[] words = input.split("\\s+");

		// question3 de chuan hoa xau
		String ho = words[0];
		ho = question3(ho);

		String ten = words[words.length - 1];
		ten = question3(ten);

		String tenDem = "";

		for (int i = 1; i <= words.length - 2; i++) {
			words[i] = question3(words[i]);
			tenDem = tenDem + words[i] + " ";
		}
		// Hoac tach ra lam 2 vong lap
//		for (int i = 1; i <= words.length - 2; i++) {
//			tenDem = tenDem + words[i] + " ";
//			//Or tenDem += words[i];
//		}

		System.out.println("Ho la: " + ho);
		System.out.println("Ten dem la: " + tenDem);
		System.out.println("Ten la: " + ten);

		scanner.close();

	}

	public static void Q7() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap vao ho va ten: ");
		String fullName = sc.nextLine();

		// Xoa dau cach dau va cuoi nguoi dung nhap vao
		fullName = fullName.trim();

		// Khai bao 1 mang, sau do su dung phuong thuc toCharArray
		// de chuyen doi name thanh 1 mang kieu char
		char[] charArray = fullName.toCharArray();
		boolean foundSpace = true;

		// sd vong lap for de duyet cac phan tu trong charArray
		for (int i = 0; i < charArray.length; i++) {
			// neu phan tu trong mang la 1 chu cai
			if (Character.isLetter(charArray[i])) {
				// kiem tra khoang trang co truoc chu cai
				if (foundSpace) {
					// doi chu cai thanh chu in hoa bang phuong thuc toUpperCase()
					charArray[i] = Character.toUpperCase(charArray[i]);
					foundSpace = false;
				}
			} else {
				foundSpace = true;
			}
		}
		// chuyen doi mang char thanh string
		fullName = String.valueOf(charArray);
		System.out.println("Ho va Ten sau khi chuan hoa: " + fullName);
		sc.close();
	}

	public static void Q8() {
		String[] groupNames = { "Java group", "DEV group", "Java club" };
		for (String groupName : groupNames) {
			if (groupName.contains("Java")) {
				System.out.println(groupName);
			}
		}
	}

	public static void Q9() {
		String[] groupNames = { "Java", "HTML", "SQL", "PHP" };
		for (String groupName : groupNames) {
			if (groupName.equals("Java")) {
				System.out.println(groupName);
			}
		}
	}

	public static void Q10() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhap chuoi 1: ");
		String array1 = scanner.nextLine().trim();
		System.out.print("Nhap chuoi 2: ");
		String array2 = scanner.nextLine().trim();

		// Phuong thuc reverse() của lop StringBuilder dao nguoc chuoi hien tai
		String reverseArray1 = new StringBuilder(array1).reverse().toString();
		if (array2.equals(reverseArray1)) {
			System.out.println("Chuoi 2 la chuoi dao nguoc cua chuoi 1");
		} else {
			System.out.println("Chuoi 2 khong la chuoi dao nguoc cua chuoi 1");
		}
		scanner.close();
	}

	// Cach khac cau 10
	public static void Question10() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhap chuoi 1: ");
		String array1 = scanner.nextLine().trim();
		System.out.print("Nhap chuoi 2: ");
		String array2 = scanner.nextLine().trim();

		String reverse = "";
		for (int i = array1.length() - 1; i >= 0; i--) {
			reverse = reverse + array1.charAt(i);
		}

		if (reverse.equals(array2)) {
			System.out.println("Chuoi 2 la chuoi dao nguoc cua chuoi 1");
		} else {
			System.out.println("Chuoi 2 khong la chuoi dao nguoc cua chuoi 1");
		}
		scanner.close();
	}

	public static boolean question10(String s1, String s2) {
		int j = 0;

		for (int i = s1.length() - 1; i >= 0; i--) {
			if (s1.charAt(i) != s2.charAt(j)) {
				return false;
			}
			j++;
		}
		return true;
	}

	public static void Q11() {
		Scanner scanner = new Scanner(System.in);
		int amount = 0;

		System.out.print("Nhap vao mot chuoi: ");
		String array = scanner.nextLine();
		char[] charArray = array.trim().toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == 'a') {
				amount++;
			}
		}
		System.out.println("So lan xuat hien chu 'a' la " + amount + " lan");
		scanner.close();
	}

	public static void Q12() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String array = scanner.nextLine().trim();
		String reverse = "";
		for (int i = array.length() - 1; i >= 0; i--) {
			reverse += array.charAt(i);
		}
		System.out.println(reverse);
		scanner.close();
	}

	// Cach khac cau 12
	public static String Question12(String input) {
		input = input.trim();

		String reverse = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			reverse += input.charAt(i);
		}
		return reverse;
	}

	public static void Q13() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String string = scanner.nextLine();
		string = string.trim();

		// Kiem tra xem chuoi co chua chu so hay khong, \\d thay cho [0-9]
		if (string.matches(".*[0-9].*")) {
			System.out.println("False");
		} else {
			System.out.println("True");
		}
		scanner.close();
	}

	public static void Q14() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String str = scanner.nextLine();

		System.out.print("Nhap ki tu muon chuyen: ");

		char char1 = scanner.nextLine().toCharArray()[0];
		System.out.print("Nhap ki tu ma ki tu " + char1 + " se chuyen thanh: ");
		char char2 = scanner.nextLine().toCharArray()[0];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == char1) {
				str = str.replace(char1, char2);
			}
		}
		System.out.println("Chuoi sau khi chuyen: " + str);
		scanner.close();
	}

	public static void Q15() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String str = scanner.nextLine();
		// Xoa khoang trang o dau va cuoi chuoi
		str = str.trim();

		// Tach chuoi dua tren khoang trang, \s: ky tu khoang trang
		String[] strings = str.split("\\s+");

		for (int i = strings.length - 1; i >= 0; i--) {
			System.out.print(strings[i] + "\s");
		}
		scanner.close();
	}

	public static void Q16() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String str = scanner.nextLine();
		// Xoa khoang trang o dau va cuoi chuoi
		str = str.trim();

		// Remove khoang trang
		str = str.replaceAll("\s", "");

		System.out.print("Nhap so n: ");
		int n = scanner.nextInt();

		if (str == null || str.length() % n != 0) {
			System.out.println("KO");
		} else {
			for (int i = 0; i < str.length(); i += n) {
				System.out.print(str.substring(i, i + n) + " ");
			}
		}
		scanner.close();
	}

	// Cach khac cau 16
	public static String Question16(String input, byte n) {
		if (input.length() % n != 0) {
			return "Khong the chia chuoi nay!";
		}
		List<String> subStrings = new ArrayList<String>();
		for (int i = 0; i < input.length(); i += n) {
			subStrings.add(input.substring(i, i + n));
		}
		String output = "";
		for (String string : subStrings) {
			output += string + "\n";
		}
		return output;
	}

}
