package com.vti.entity.Ex6;

public abstract class Phone {
	private Contact[] contacts;
	
	public abstract void insertContact(String name, String phone);
	public abstract void removeContact(String name);
	public abstract void updateContact(String name, String newPhone);
	public abstract void searchContact(String name);
	
	public Contact[] getContacts() {
		return contacts;
	}
	public void setContacts(Contact[] contacts) {
		this.contacts = contacts;
	}
}
