import java.util.Random;
import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		// Question 1: Khai bao 2 so luong co kieu dl la float
		// Q1();

		// Question 2: Lay ngau nhien 1 so co 5 chu so
		// Q2();

		// Question 3: Lay 2 so cuoi cua o question 2
		// Q3();

		// Question 4: Viet method nhap vao 2 so nguyen a va b va tra ve thuong cuachung
		//Q4();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap vao so chia a: ");
		int a = scanner.nextInt();
		System.out.print("Nhap vao so bi chia b: ");
		int b = scanner.nextInt();
		
		float thuong = divide(a, b);
		System.out.println("Ket qua phep chia: " + thuong);
		scanner.close();
	}

	public static void Q1() {
		float salary1;
		float salary2;

		salary1 = (float) 5240.5;
		salary2 = (float) 10970.055;
		System.out.println("Salary1: " + salary1 + "\n Salary2: " + salary2);

		int luong1 = (int) salary1;
		int luong2 = (int) salary2;
		System.out.println("Luong1: " + luong1 + "\n Luong2: " + luong2);
	}

	public static void Q2() {
		Random random = new Random();
		int a = random.nextInt(99999);
		if (a < 10) {
			System.out.println("So ngau nhien la: 0000" + a);
		} else if (a >= 10 && a < 100) {
			System.out.println("So ngau nhien la: 000" + a);
		} else if (a >= 100 && a < 1000) {
			System.out.println("So ngau nhien la: 00" + a);
		} else if (a >= 1000 && a < 10000) {
			System.err.println("So ngau nhien la: 0" + a);
		} else {
			System.out.println("So ngau nhien la: " + a);
		}
	}

	public static void Q3() {
		Random random = new Random();
		int a = random.nextInt(99999);
		if (a < 10) {
			System.out.println("So ngau nhien la: 0000" + a);
		} else if (a >= 10 && a < 100) {
			System.out.println("So ngau nhien la: 000" + a);
		} else if (a >= 100 && a < 1000) {
			System.out.println("So ngau nhien la: 00" + a);
		} else if (a >= 1000 && a < 10000) {
			System.err.println("So ngau nhien la: 0" + a);
		} else {
			System.out.println("So ngau nhien la: " + a);
		}
//		int a1 = a % 100;
//      System.out.println("Hai so cuoi cua so ngau nhien la: " + a1);

		String s = String.valueOf(a);
		System.out.println("Hai so cuoi cua so ngau nhien la: " + s.substring(3));
	}

	public static float divide(int a, int b) {
		return (float) a / b;
	}

}
