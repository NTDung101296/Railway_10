package com.vti.entity;

import java.time.LocalDate;

public class Account3 {
	private short id;
	private String email;
	private String userName;
	private String fullName;
	private Department department;
	private Position position;
	private LocalDate createDate;
	private Group[] groups;
	
	public short getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public Group[] getGroups() {
		return groups;
	}
	public void setGroups(Group[] groups) {
		this.groups = groups;
	}

}
