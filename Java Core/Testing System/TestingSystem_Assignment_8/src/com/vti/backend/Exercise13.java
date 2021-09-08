//SET
package com.vti.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.vti.entity.Student;
import com.vti.utils.ScannerUtils;

public class Exercise13 {
	private Set<Student> students;
	private static Scanner scanner;

	public Exercise13() {
		students = new LinkedHashSet<Student>();
		scanner = new Scanner(System.in);
		addStudent();
	}

	public void addStudent() {
		students.add(new Student(1, "Nguyen Van A"));
		students.add(new Student(2, "Nguyen Van B"));
		students.add(new Student(3, "Nguyen Van C"));
		students.add(new Student(4, "Nguyen Van A"));
		students.add(new Student(5, "Nguyen Van D"));
		students.add(new Student(6, "Nguyen Van A"));
	}

	public void printStudent() {
//		for (Student student : students) {
//			System.out.println(student);
//		}
		// Sd Iterator
		Iterator<Student> studentIterator = students.iterator();
		while (studentIterator.hasNext()) {
			System.out.println((Student) studentIterator.next());
		}
	}

	// 1a
	public void getAmountOfStudent() {
		System.out.println("Tong so cac sinh vien la: " + students.size());
	}

	// 1b
	public void getIndex4OfStudent() {
		Iterator<Student> studentIterator = students.iterator();
		System.out.println(studentIterator.next());
		for (int i = 0; i < 3; i++) {
			studentIterator.next();
		}
		System.out.println("Sinh vien thu 4 la: " + studentIterator.next());
	}

	// 1c
	public void printFirstAndLastStudent() {
		Iterator<Student> studentIterator = students.iterator();
		System.out.println("Sinh vien thu nhat la: " + studentIterator.next());
		for (int i = 1; i < students.size() - 1; i++) {
			studentIterator.next();
		}
		System.out.println("Sinh vien cuoi cung la: " + studentIterator.next());
	}

	// 1d
	public void addStudentIntoFirstStudents() {
		List<Student> listStudents = new ArrayList<Student>();
		listStudents.addAll(students);
		System.out.println("Them 1 sinh vien vao vi tri dau\n");
		listStudents.add(0, new Student(7, "Nguyen Trung Dung"));

		System.out.println("Danh sach sinh vien sau khi them: ");
		for (Student student : listStudents) {
			System.out.println(student);
		}
	}

	// 1e
	public void addStudentIntoLastStudents() {
		System.out.println("Them 1 sinh vien vao vi tri cuoi\n");
		students.add(new Student(8, "Nguyen Van E"));

		System.out.println("Danh sach sinh vien sau khi them: ");
		printStudent();
	}

	// 1f
	public void reverseStudents() {
		List<Student> listStudents = new ArrayList<Student>();
		listStudents.addAll(students);
		Collections.reverse(listStudents);
		System.out.println("Danh sach sinh vien sau khi dao nguoc vi tri\n");
		printStudent();
	}

	// 1g
	public void findStudentById() {
		System.out.println("Nhap vao ID sinh vien can tim kiem: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		if (students.size() == 0) {
			System.out.println("Danh sach sinh vien trong!");
		}

		boolean isExist = false;
		for (Student student : students) {
			if (student.getId() == id) {
				isExist = true;
				System.out.println(student);
			}
		}
		if (isExist == false) {
			System.out.println("Khong tim thay!");
		}
	}

	// 1h
	public void findStudentByName() {
		System.out.println("Nhap vao ten can tim kiem: ");
		String name = ScannerUtils.inputName(scanner);
		// System.out.println(name);
		if (students.size() == 0) {
			System.out.println("Danh sach sinh vien trong!");
		}

		boolean isExist = false;
		for (Student student : students) {
			if (student.getName().equals(name) == true) {
				isExist = true;
				System.out.println(student);
			}
		}

		if (isExist == false) {
			System.out.println("Khong tim thay!");
		}

	}

//	public void findStudentByName() {
//		System.out.println("Nhap vao ten can tim kiem: ");
//		String name = scanner.nextLine().trim();
//		char[] charArray = name.toCharArray();
//		boolean foundSpace = true;
//
//		// sd vong lap for de duyet cac phan tu trong charArray
//		for (int i = 0; i < charArray.length; i++) {
//			// neu phan tu trong mang la 1 chu cai
//			if (Character.isLetter(charArray[i])) {
//				// kiem tra khoang trang co truoc chu cai
//				if (foundSpace) {
//					// doi chu cai thanh chu in hoa bang phuong thuc toUpperCase()
//					charArray[i] = Character.toUpperCase(charArray[i]);
//					foundSpace = false;
//				}
//			} else {
//				foundSpace = true;
//			}
//		}
//		// chuyen doi mang char thanh string
//		name = String.valueOf(charArray);
//		boolean isExist = false;
//		for (Student student : students) {
//			if (student.getName().equals(name)) {
//				System.out.println(student);
//				isExist = true;
//			}
//		}
//		if (isExist == false) {
//			System.out.println("Khong tim thay!");
//		}
//	}

	// 1i
	public void findDuplicateStudent() {
		List<Student> listStudents = new ArrayList<Student>();
		listStudents.addAll(students);
		System.out.println("Cac sinh vien co ten giong nhau\n");
		for (int i = 0; i < students.size(); i++) {
			for (int j = i + 1; j < students.size(); j++) {
				// So sanh ten cua student
				if (listStudents.get(i).getName().equals(listStudents.get(j).getName())
						&& listStudents.get(i).getId() != listStudents.get(j).getId()) {
					System.out.println(listStudents.get(i) + " va " + listStudents.get(j));
				}
			}
		}
	}

	// 1j
	public void deleteNameStudentId2() {
		for (Student student : students) {
			if (student.getId() == 2) {
				student.setName(null);
			}
		}
		System.out.println("Danh sach sinh vien sau khi xoa ten cua sinh vien co id = 2");
		printStudent();
	}

	// 1k
	public void deleteStudentId5() {
		for (Student student : students) {
			if (student.getId() == 5) {
				students.remove(student);
			}
		}
		System.out.println("Danh sach sinh vien sau khi xoa sinh vien co id = 5");
		printStudent();

	}

	// 1l
	public void addAllStudentsToStudentsCopies() {
		List<Student> studentsCopies = new ArrayList<Student>();

		studentsCopies.addAll(students);
		for (Student student : studentsCopies) {
			System.out.println(student);
		}

	}

}
