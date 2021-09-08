package com.vti.entity.Ex4.Question2;

public class Date {
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String toString() {
		return "Date: " + "\n Day= " + day + "\n Month= " + month + "\n Year= " + year;
	}

	public boolean isLeapYear() {
		return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)); // Tra ve true neu chia het cho 4 nhung
																				// khong chia het cho 100
																				// hoac chia het cho 400
	}
//
//	//Kiem tra nam nhuan
//	public static void main(String[] args) {
//		int year = 2000;
//		System.out.println(isLeapYear(year) ? "Leap Year" : "Not a Leap Year");
//	}
}


