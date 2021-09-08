package com.vti.entity;

import java.time.LocalDate;

public class Group {
	byte id;
	String name;
	Account creator;
	LocalDate createDate;
	Account[] accounts;

	public String toString() {
		return "ID: " + this.id + "\nName: " + this.name + "\nCreateDate: " + this.createDate + "\nAccounts: "
				+ this.accounts;
	}

	// Question 2: Tạo constructor cho Group:
	// a) Không có parameters
	public Group() {
	}

	// b) Có các parameter là GroupName, Creator, array Account[]
	// accounts, CreateDate
	public Group(byte id, String groupName, Account creator, Account[] accounts, LocalDate createDate) {
		this.id = id;
		this.name = groupName;
		this.creator = creator;
		this.accounts = accounts;
		this.createDate = createDate;
	}

	// c) Có các parameter là GroupName, Creator, array String[], usernames ,
	// CreateDate
	// Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin username, các
	// thông tin còn lại = null).
	public Group(byte id, String groupName, Account creator, String[] userNames, LocalDate createDate) {
		this.id = id;
		this.name = groupName;
		this.creator = creator;
		Account[] accounts = new Account[userNames.length];
		for (int i = 0; i < userNames.length; i++) {
			accounts[i] = new Account(userNames[i]);
		}
		this.accounts = accounts;
		this.createDate = createDate;
	}
}
