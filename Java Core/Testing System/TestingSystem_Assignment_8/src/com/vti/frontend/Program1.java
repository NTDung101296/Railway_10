package com.vti.frontend;

import com.vti.backend.Exercise11;
import com.vti.backend.Exercise12;
import com.vti.backend.Exercise13;
import com.vti.backend.Exercise145;
import com.vti.backend.Exercise167;

public class Program1 {

	public static void main(String[] args) {
		Exercise11 list = new Exercise11();
		list.deleteStudentId5();

		question2();

		Exercise13 set = new Exercise13();
		set.addAllStudentsToStudentsCopies();

		question45();
		
		Exercise167 map= new Exercise167();
		map.convertMapToSet();

	}

//	public static void question1() {
//		Exercise11 list = new Exercise11();
//		list.addStudent();
//		
//		list.getAmountOfStudent();
//		
//		list.getIndex4OfStudent();
//		
//		list.printFirstAndLastStudent();
//		
//		list.addStudentIntoFirstStudents();
//		
//		list.addStudentIntoLastStudents();
//		
//		list.reverseStudents();
//		
//		list.findStudentById();
//		
//		list.findStudentByName();
//		
//		list.findDuplicateStudent();
//		
//		list.deleteNameStudentId2();
//		
//		list.deleteStudentId5();
//		
//		list.addAllStudentsToStudentsCopies();
//	}

	public static void question2() {
		Exercise12 stackAndQueue = new Exercise12();
		System.out.println("Thu tu student den phong van tu muon nhat den som nhat: ");
		stackAndQueue.printStudentLatestToEarliest();

		System.out.println("Thu tu student den phong van tu som nhat den som nhat: ");
		stackAndQueue.printStudentEarliestToLatest();
	}

	public static void question3() {

	}

//	public static void question1() {
//	Exercise13 set = new Exercise13();
//	set.addStudent();
//	
//	set.getAmountOfStudent();
//	
//	set.getIndex4OfStudent();
//	
//	set.printFirstAndLastStudent();
//	
//	set.addStudentIntoFirstStudents();
//	
//	set.addStudentIntoLastStudents();
//	
//	set.reverseStudents();
//	
//	set.findStudentById();
//	
//	set.findStudentByName();
//	
//	set.findDuplicateStudent();
//	
//	set.deleteNameStudentId2();
//	
//	set.deleteStudentId5();
//	
//	set.addAllStudentsToStudentsCopies();
//}

	public static void question45() {
		Exercise145 ex45 = new Exercise145();
		System.out.println("Danh sach sinh vien");
		ex45.printStudentNotOverLap();
		System.out.println("Danh sach sinh vien sau khi sap xep");
		ex45.sortByName();
	}
}
