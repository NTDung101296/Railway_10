package com.vti.entity.Ex5.Question4;

import java.time.LocalDate;

public class Article extends Document{
	private LocalDate dayRelease;
	
	public Article (int id, String publisher, int numRelease, LocalDate dayRelease) {
		super(id, publisher, numRelease);
		this.setDayRelease(dayRelease);
	}
	
	public String toString() {
		return "\n Article: " + super.toString() +  "\n Day Release= " + dayRelease; 
	}

	public LocalDate getDayRelease() {
		return dayRelease;
	}

	public void setDayRelease(LocalDate dayRelease) {
		this.dayRelease = dayRelease;
	}

}
