package com.vti.entity.Ex4.Question2;

public class Account {
	private String id;
	private String name;
	private int balance;

	public Account(String id, String name, int balance) {
		this.setId(id); // ~this.id = id;
		this.setName(name);
		this.setBalance(balance);// so du tai khoan
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int credit(int amount) {
		return this.balance += amount;
	}

	public int debit(int amount) {
		return this.balance -= amount;
	}

	public void tranferTo(Account account, int amount) {
		this.balance -= amount;
		account.balance += amount;
	}

}
