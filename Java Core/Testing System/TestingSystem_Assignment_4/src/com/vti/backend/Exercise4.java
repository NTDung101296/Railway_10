package com.vti.backend;

import com.vti.entity.Student;
import com.vti.entity.Ex4.Question2.Account;
import com.vti.entity.Ex4.Question2.Circle;
import com.vti.entity.Ex4.Question2.Date;

public class Exercise4 {
	public void printInformationQ1() {
		Student st1 = new Student((byte) 1, "Dung", "HN");
		st1.plusPoint(2.0);

		Student st2 = new Student((byte) 2, "Hung", "Bac Giang");
		st2.plusPoint(6.0);

		Student st3 = new Student((byte) 3, "Tung", "Thanh Hoa");
		st3.plusPoint(9.0);

		Student st4 = new Student((byte) 4, "Huan", "Nam Dinh");
		st4.plusPoint(4.5);

		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
		System.out.println(st4);
	}

	public void Question2() {
		System.out.println("** Demo Circle **");
		Circle circle = new Circle(1.0, "read");

		System.out.println(" Dien tich hinh tron la: " + circle.getArea());

		System.out.println("-- Demo Account --");
		Account account1 = new Account("1", "Dung", 100);
		Account account2 = new Account("2", "Nam", 200);

		System.out.println("So tien ban dau cua Account1 la: " + account1.getBalance());
		System.out.println("So tien ban dau cua Account2 la: " + account2.getBalance());

		account1.credit(30);
		System.err.println("So du cua Account1 sau khi Credit 30 la: " + account1.getBalance());

		account2.debit(50);
		System.err.println("So du cua Account1 sau khi Debit 50 la: " + account2.getBalance());

		System.out.println("Account1 chuyen cho Account2 80");
		account1.tranferTo(account2, 80);
		System.out.println("Sau khi chuyen khoan so tien cua Account 1:" + account1.getBalance() + " Account2: "
				+ account2.getBalance());
		
		System.out.println("__ Demo Date __");
		Date date = new Date(10, 12, 1996);
		System.out.println("Ngay vua tao: " + date);
		
		System.out.println("Kiem tra nam nhuan: ");
		if (date.isLeapYear()) {
			System.err.println("Day la nam nhuan");
		} else {
			System.out.println("Day khong phai nam nhuan");
		}
	}	
}
