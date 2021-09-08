package com.vti.backend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.PositionName;

public class Exercise1 {
	// Khoi tao Department
	public void question1() {
		Department department = new Department();
		Department department1 = new Department("Sales");
		Department department2 = new Department((byte) 2, "Marketing");

		System.out.println(department);
		System.out.println(department1);
		System.out.println(department2);
	}

	// Khoi tao Account
	public void question2() {
		Account account = new Account();
		Account account1 = new Account((short) 1, "nguyen-trung.dung@vmec,vn", "ntd", "Dung", "Nguyen");

		Position position2 = new Position((byte) 2, PositionName.PM);
		Account account2 = new Account((short) 2, "tang-manh.hung@vmec.vn", "tmh", "Hung", "Tang", position2);

		Position position3 = new Position((byte) 2, PositionName.TEST);
		Account account3 = new Account((short) 3, "nguyen-thi.huong@vmec.vn", "nth", "Huong", "Nguyen", position3,
				LocalDate.of(2018, 10, 1));

		System.out.println(account);
		System.out.println(account1);
		System.out.println(account2);
		System.out.println(account3);
	}

	// Khoi tao Group
	public void question3() {
		Group group = new Group();

		Account creator = new Account((short) 2, "tang-manh.hung@vmec.vn", "tmh", "Hung", "Tang");

		Account account1 = new Account((short) 1, "nguyen-trung.dung@vmec,vn", "ntd", "Dung", "Nguyen");
		Account[] accounts = { account1 };
		Group group1 = new Group((byte) 1, "Testing System", creator, accounts, LocalDate.now());

		String[] userNames = { "user1", "user2", "user3" };
		Group group2 = new Group((byte) 2, "GenZ", account1, userNames, LocalDate.now());

		System.out.println(group);
		System.out.println(group1);
		System.out.println(group2);

	}
}
