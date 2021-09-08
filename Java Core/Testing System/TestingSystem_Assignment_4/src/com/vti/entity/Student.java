package com.vti.entity;

public class Student {
	private byte id;
	private String name;
	private String homeTown;
	private double point;

	// Question 1
	// a) Tao constructor
	public Student(byte id, String name, String homeTown) {
		this.id = id;
		this.name = name;
		this.homeTown = homeTown;
	}

	// b) Tao method set diem vao
	public void setPoint(double point) {
		this.point = point;
	}

	// c) Tao method cho phep cong them diem
	public void plusPoint(double point) {
		this.point = this.point + point;
	}

	// d) Tao method in thong tin
	public String toString() {
		String rank;
		if (this.point < 4.0) {
			rank = "Yếu";
		} else if (this.point < 6.0) {
			rank = "Trung Bình";
		} else if (this.point < 8.0) {
			rank = "Khá";
		} else {
			rank = "Giỏi";
		}
		return "Student [Id= " + id + ", Name= " + name + ", HomeTown= " +
				homeTown + ", Point= " + point + ", Xếp loại= " + rank + "]";
	}

}
