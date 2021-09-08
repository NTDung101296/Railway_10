package com.vti.entity;


public class NhanVien extends CanBo{
	private String congViec;

	
	public String getCongViecString() {
		return congViec;
	}


	public void setCongViecString(String congViec) {
		this.congViec = congViec;
	}
	
	public NhanVien() {
	}
	
	public NhanVien(short id, String name, byte age, Gender gender, String address, String congViec) {
		super(id, name, age, gender, address);
		this.congViec = congViec;
	}
	
	public String toString() {
		return "Nhan Vien [" + super.toString() + "Cong Viec= " + congViec + "]"; 
	}

}
