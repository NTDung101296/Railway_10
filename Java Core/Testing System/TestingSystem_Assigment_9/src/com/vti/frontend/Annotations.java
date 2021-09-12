package com.vti.frontend;

import java.util.Date;

import com.vti.entity.Student;

public class Annotations {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Question 1:
		Date date = new Date(2020, 05, 18);
		System.out.println(date);
		
		//Question 2:
		Student student = new Student("Nguyen Van A");
		System.out.println(student.getId());
		System.out.println(student.getName());
		
		System.out.println(student.getId2());
	}

}
