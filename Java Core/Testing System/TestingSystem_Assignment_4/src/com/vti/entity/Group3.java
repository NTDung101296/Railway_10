package com.vti.entity;

import java.time.LocalDate;

public class Group3 {
	private byte id;
	private String name;
	private Account creator;
	private LocalDate createDate;
	private Account[] accounts;
	
	public byte getId() {
		return id;
	}
	public void setId(byte id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getCreator() {
		return creator;
	}
	public void setCreator(Account creator) {
		this.creator = creator;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public Account[] getAccounts() {
		return accounts;
	}
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	
}
