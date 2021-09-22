package com.vti.entity;

public class User {
	private short id;
	private String name;
	private String email;
	private String password;
	private byte exp;
	private String skill;
	private Role role;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getExp() {
		return exp;
	}

	public void setExp(byte exp) {
		this.exp = exp;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User() {

	}

	public User(short id, String name, String email, String password, byte exp, String skill, Role role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.exp = exp;
		this.skill = skill;
		this.role = role;
	}

	public User(short id, String name, String email, byte exp, String skill) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.exp = exp;
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", email=" + email + ", exp=" + exp + ", skill=" + skill;
	}

}
