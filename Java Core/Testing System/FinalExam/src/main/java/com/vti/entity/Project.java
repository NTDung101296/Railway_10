package com.vti.entity;

import java.util.List;

public class Project {
	private int id;
	private byte teamSize;
	private Manager manager;
	private List<Employee> employees;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(byte teamSize) {
		this.teamSize = teamSize;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Project() {

	}

	public Project(int id, Manager manager) {
		this.id = id;
		this.manager = manager;
	}

	public Project(int id) {
		this.id = id;
	}

	public Project(int id, byte teamSize, Manager manager, List<Employee> employees) {
		super();
		this.id = id;
		this.teamSize = teamSize;
		this.manager = manager;
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Project: id= " + id + ", teamSize= " + teamSize + "\n Manager: " + manager + "\n List employees: \n"
				+ employees;
	}

}
