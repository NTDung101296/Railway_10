package com.vti.entity;

import java.time.LocalDate;

public class Account {
	public short id;
	public String email;
	public String userName;
	public String fullName;
	public Department department;
	public Position position;
	public LocalDate createDate;
	public Group[] groups;

	public String toString() {
		return "ID: " + this.id + "\nEmail: " + this.email + "\nUserName: " + this.userName + "\nFullName: "
				+ this.fullName + "\nDepartment: " + this.department + "\nPosition: " + this.position + "\nCreateDate: "
				+ this.createDate + "\nGroups: " + this.groups;
	}

	// Question 2: Tạo constructor cho Account:
	// a) Không có parameters
	public Account() {
	}

	public Account(String userName) {
		this.userName = userName;
	}

	// b) Có các parameter là id, Email, Username, FirstName, LastName
	// (với FullName = FirstName + LastName)
	public Account(short id, String email, String userName, String firstName, String lastName) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + lastName;
	}

	// c) Có các parameter là id, Email, Username, FirstName, LastName
	// (với FullName = FirstName + LastName) và Position của User,
	// default createDate = now
	public Account(short id, String email, String userName, String firstName, String lastName, Position position) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = LocalDate.now();
	}

	// d) Có các parameter là id, Email, Username, FirstName, LastName
	// (với FullName = FirstName + LastName) và Position của User, createDate
	public Account(short id, String email, String userName, String firstName, String lastName, Position position,
			LocalDate creatDate) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firstName + " " + lastName;
		this.position = position;
		this.createDate = creatDate;
	}
}
