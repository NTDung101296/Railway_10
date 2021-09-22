package com.vti.entity;

import java.util.List;

public class Employee extends User {

	private String proSkill;
	private List<Project> projects;

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Employee() {

	}

	public Employee(String id, String name, String email, String proSkill) {
		super(id, name, email);
		this.proSkill = proSkill;
	}

	public Employee(String id, String name, String email, String password, String proSkill) {
		super(id, name, email, password);
		this.proSkill = proSkill;
	}

	public Employee(String proSkill, List<Project> projects) {
		this.proSkill = proSkill;
		this.projects = projects;
	}

	@Override
	public String toString() {
		return super.toString() + ", proSkill= " + proSkill + "\n";
	}

}
