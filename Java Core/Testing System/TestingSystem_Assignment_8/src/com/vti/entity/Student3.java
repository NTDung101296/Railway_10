package com.vti.entity;

public class Student3<T> {
	private T id;
	private String name;

	public Student3() {
		super();
	}

	public Student3(T id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student3 [id=" + id + ", name=" + name + "]";
	}

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
