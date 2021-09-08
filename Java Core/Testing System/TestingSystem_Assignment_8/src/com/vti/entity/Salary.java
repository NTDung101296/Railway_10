package com.vti.entity;

public class Salary<N extends Number> {
	private N salary;

	public N getSalary() {
		return salary;
	}

	public void setSalary(N salary) {
		this.salary = salary;
	}

	public Salary(N salary) {
		super();
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Salary [salary=" + salary + "]";
	}
	
	
	
	

}
