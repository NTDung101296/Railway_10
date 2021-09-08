package com.vti.entity;

public class Department {
	public byte id;
	public String name;
	
	public String toString() {
		return "ID: " + this.id + "\nName: " + this.name;
	}
	
	//Question 1: Tao constructor cho department
	//a) Khong co parameter
	public Department() {
		
	}
	
	//b) Co 1 parameter la nameDepartment & default id cua Department = 0
	public Department(String nameDepartment) {
		this.name = nameDepartment;
	}
	
	//c) Co 2 parameter 
	public Department(byte id, String name) { 
		this.id = id; 
		this.name = name;
	}
}
