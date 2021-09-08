package com.vti.entity.Ex6;

import java.util.ArrayList;
import java.util.List;

public class VietnamesePhone extends Phone {
	private List<Contact> contacts;

	public VietnamesePhone() {
		contacts = new ArrayList<Contact>();
	}

	public void insertContact(String name, String phone) {
		Contact contact = new Contact(name, phone);
		contacts.add(contact);
	}

	public void removeContact(String name) {
		contacts.removeIf(contact -> contact.getName().toLowerCase().equals(name));
	}

	public void updateContact(String name, String newPhone) {
		for (Contact contact : contacts) {
			if (contact.getName().toLowerCase().equals(name)) {
				contact.setPhone(newPhone);
			}
		}
	}

	public void searchContact(String name) {
		boolean isExist = false;
		for (Contact contact : contacts) {
			if (contact.getName().toLowerCase().equals(name)) {
				isExist = true;
				System.out.println(contact);
			}
		}
		if (isExist == false) {
			System.out.println("Khong tim thay thong tin!");
		}
	}

	public void printContact() {
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
		
		if (contacts.size() == 0) {
			System.out.println("Danh sach trong!");
		}
	}
}
