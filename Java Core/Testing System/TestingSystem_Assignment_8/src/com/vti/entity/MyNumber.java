package com.vti.entity;

public class MyNumber<N extends Number> {
	private N number;

	public N getnumber() {
		return number;
	}

	public void setnumber(N number) {
		this.number = number;
	}

	public MyNumber(N number) {
		super();
		this.number = number;
	}

	@Override
	public String toString() {
		return "MyNumber [number=" + number + "]";
	}
	
	
	
	

}
