package com.vti.entity.Ex2;

public class Student implements IStudent {
	private int id;
	private String name;
	private int group;
	public static int count;
	
	public Student() {
	}
	
	public Student(String name, int group) {
		count++;
		this.id = count;
		this.name = name;
		this.group = group;
	}
	
	public String toString() {
		return "\n ID= " + id + "\n Name= " + name + "\n Group= " + group;
	}
	
	public int getId() {
		return id;
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
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}

	@Override
	public void diemDanh() {
		System.out.println(name + " diem danh");
		
	}

	@Override
	public void hocBai() {
		System.out.println(name + " dang hoc bai");
	}

	@Override
	public void donVeSinh() {
		System.out.println(name + " di don ve sinh");
		
		
	}

}
