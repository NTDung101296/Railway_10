package com.vti.backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.vti.entity.Student2;

public class Exercise2 {
	private List<Student2> students;

	public Exercise2() {
		students = new ArrayList<Student2>();
		addStudent();
	}

	public void addStudent() {
		students.add(new Student2(1, "Nguyen Van A", LocalDate.parse("1997-12-10"), 0f));
		students.add(new Student2(2, "Nguyen Van A", LocalDate.parse("1997-12-10"), 5f));
		students.add(new Student2(3, "Nguyen Van E", LocalDate.parse("1996-04-23"), 8f));
		students.add(new Student2(4, "Nguyen Van B", LocalDate.parse("2000-09-04"), 6.5f));
		students.add(new Student2(5, "Nguyen Van A", LocalDate.parse("1997-12-10"), 9f));
	}

	public void printStudent() {
		for (Student2 student : students) {
			System.out.println(student);
		}
	}

	public void printSortByName() {
		System.out.println("Danh sach sinh vien sap xep theo ten: ");
		Collections.sort(students);
		printStudent();
	}

	public void sortStudent() {
		System.out.println("Danh sach sinh vien sap xep theo ten, ngay sinh, diem: ");
		Collections.sort(students, new Comparator<Student2>() {
			@Override
			public int compare(Student2 o1, Student2 o2) {
				if (o1.getName().equals(o2.getName())) {
					return o1.getBirthDay().compareTo(o2.getBirthDay());
				} else if (o1.getName().equals(o2.getName()) && o1.getBirthDay() == o2.getBirthDay()) {
					return o1.getScore() > o2.getScore() ? 1 : -1;
				} else {
					return o1.getName().compareTo(o2.getName());
				}
			}
		});
		printStudent();
	}
}
