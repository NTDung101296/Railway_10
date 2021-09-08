package com.vti.entity.Ex5.Question4;

import java.time.LocalDate;

public class Magazine extends Document {
	private int idRelease;
	private LocalDate monthRelease;
	
	public Magazine (int id, String publisher, int numRelease, int idRelease, LocalDate monthRelease) {
		super(id, publisher, numRelease);
		this.idRelease = idRelease;
		this.monthRelease = monthRelease;
	}
	
	public String toString() {
		return "\n Magazine: " + super.toString() +  "\n Id Release= " + idRelease + "\n Month Release= " + monthRelease; 
	}
	
	public int getIdRelease() {
		return idRelease;
	}
	public void setIdRelease(int idRelease) {
		this.idRelease = idRelease;
	}
	
	public LocalDate getMonthRelease() {
		return monthRelease;
	}
	public void setMonthRelease(LocalDate monthRelease) {
		this.monthRelease = monthRelease;
	}
	

}
