package com.vti.entity;

public class HighSchoolStudent extends Student5 {
	private String clazz;
	private String desiredUniversity;

	public HighSchoolStudent(String name, int id, String clazz, String desiredUniversity) {
		super(name, id);
		this.clazz = clazz;
		this.desiredUniversity = desiredUniversity;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getDesiredUniversity() {
		return desiredUniversity;
	}

	public void setDesiredUniversity(String desiredUniversity) {
		this.desiredUniversity = desiredUniversity;
	}

	public String toString() {
		return "HighSchoolStudent" + "\n Id= " + super.getId() + "\n Name= " + super.getName() + "\n Clazz= " + clazz
				+ "\n DesiredUniversity= " + desiredUniversity;
	}
}
