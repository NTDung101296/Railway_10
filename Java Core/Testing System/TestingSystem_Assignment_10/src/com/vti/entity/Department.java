package com.vti.entity;

public class Department {
	private byte id;
	private String name;
	
	public Department(byte id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Department() {
		super();
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
