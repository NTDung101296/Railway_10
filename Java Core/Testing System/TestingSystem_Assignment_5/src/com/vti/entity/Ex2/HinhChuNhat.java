package com.vti.entity.Ex2;

public class HinhChuNhat {

	private float a;
	private float b;

	public HinhChuNhat(float a, float b) {
		this.a = a;
		this.b = b;
	}

	public float tinhChuVi() {
		return (a + b) * 2;
	}
	
	public float tinhDienTich() {
		return a*b;
	}

}
