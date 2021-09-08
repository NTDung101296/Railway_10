package com.vti.entity.Ex6;

public abstract class User {
	private String name;
	private double salaryRatio;
	
	public User() {
	}
	
	public User(String name, double salaryRatio) {
		this.name = name;
		this.salaryRatio = salaryRatio;
	}
	
	public abstract double calculatePay();
	
	public void displayInfor(){
		System.out.println("Name= " + name);
		System.out.println("Ratio Salary= " + salaryRatio);
		System.out.println("Luong chi tra= " + calculatePay());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalaryRatio() {
		return salaryRatio;
	}

	public void setSalaryRatio(double salaryRatio) {
		this.salaryRatio = salaryRatio;
	}

}
