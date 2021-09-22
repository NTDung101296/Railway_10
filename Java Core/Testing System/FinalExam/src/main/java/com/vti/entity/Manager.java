package com.vti.entity;

public class Manager extends User {

	private byte expInYear;
	private int idProject;

	public byte getExpInYear() {
		return expInYear;
	}

	public void setExpInYear(byte expInYear) {
		this.expInYear = expInYear;
	}

	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public Manager() {

	}

	public Manager(String id, String name, String email, byte expInYear) {
		super(id, name, email);
		this.expInYear = expInYear;
	}

	public Manager(String id, String name, String email, byte expInYear, int idProject) {
		super(id, name, email);
		this.expInYear = expInYear;
		this.idProject = idProject;
	}

	public Manager(String id, String name, String email, String password, byte expInYear) {
		super(id, name, email, password);
		this.expInYear = expInYear;
	}

	@Override
	public String toString() {
		return super.toString() + ", expInYear= " + expInYear;
	}

}
