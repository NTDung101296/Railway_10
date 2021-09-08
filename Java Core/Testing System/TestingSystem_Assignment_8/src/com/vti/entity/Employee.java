package com.vti.entity;

import java.util.Arrays;

public class Employee<T> {
	private int id;
	private String name;
	private T[] salaries;

	public Employee() {
		super();
	}

	public Employee(int id, String name, T[] salaries) {
		super();
		this.id = id;
		this.name = name;
		this.salaries = salaries;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salaries=" + Arrays.toString(salaries) + "]";
	}

	public String getLastSalary() {
		return "Employee [id=" + id + ", name=" + name + ", salaries=" + salaries[salaries.length - 1] + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T[] getSalaries() {
		return salaries;
	}

	public void setSalaries(T[] salaries) {
		this.salaries = salaries;
	}

}
