package com.vti.entity;

public class Fresher extends User {

	private String green;

	public String getGreen() {
		return green;
	}

	public void setGreen(String green) {
		this.green = green;
	}

	public Fresher() {

	}
	
	public Fresher(short id, String name, String email, String passWord, byte exp, String skill, Role role) {
		super(id, name, email, passWord, exp, skill, role);
	}

	public Fresher(short id, String name, String email, byte exp, String skill) {
		super(id, name, email, exp, skill);
	}

	@Override
	public String toString() {
		return "Fresher:" + super.toString();
	}

}
