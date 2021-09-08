package com.vti.entity;

import java.time.LocalDate;

public class Student2 implements Comparable<Student2> {
	private int id;
	private String name;
	private LocalDate birthDay;
	private float score;

	public Student2() {
		super();
	}

	public Student2(int id, String name, LocalDate birthDay, float score) {
		super();
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student2 [id=" + id + ", name=" + name + ", birthDay=" + birthDay + ", score=" + score + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	@Override
	public int compareTo(Student2 st2) {
		return this.getName().compareTo(st2.getName());
	}

}
