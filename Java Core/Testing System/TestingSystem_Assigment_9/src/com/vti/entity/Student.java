package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private static int COUNT = 0;

	public Student() {

	}

	public Student(String name) {
		super();
		this.id = ++COUNT;
		this.name = name;
	}

	/**
	 * 
	 * @deprecated replaced by {@link #getId2()}
	 */
	@Deprecated
	public int getId() {
		return id;
	}
	
	public String getId2() {
		return "MSV" + id;
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	

}
