package com.vti.entity;

public class Senior extends User {

	private String softSkill;

	public String getSoftSkill() {
		return softSkill;
	}

	public void setSoftSkill(String softSkill) {
		this.softSkill = softSkill;
	}

	public Senior() {

	}

	public Senior(short id, String name, String email, String passWord, byte exp, String skill, Role role) {
		super(id, name, email, passWord, exp, skill, role);
	}
	
	public Senior(short id, String name, String email, byte exp, String skill) {
		super(id, name, email, exp, skill);
	}

	@Override
	public String toString() {
		return "Senior:" + super.toString();
	}
}
