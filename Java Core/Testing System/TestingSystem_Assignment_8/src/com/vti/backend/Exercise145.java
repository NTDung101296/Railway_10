//SET
package com.vti.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class Exercise145 {
	private static HashSet<String> students;

	public Exercise145() {
		students = new HashSet<String>();
		addStudent();
	}

	public void addStudent() {
		students.add("Nguyen Van E");
		students.add("Nguyen Van B");
		students.add("Nguyen Van C");
		students.add("Nguyen Van A");
		students.add("Nguyen Van D");
		students.add("Nguyen Van A");
	}

	public void printStudentNotOverLap() {
		Iterator<String> studentIterator = students.iterator();
		while (studentIterator.hasNext()) {
			System.out.println(studentIterator.next());
		}
	}

	public void sortByName() {
		Set<String> setStudent = new LinkedHashSet<String>(students);
		List<String> listStudent = new ArrayList<String>(setStudent);
		Collections.sort(listStudent);
		setStudent = new LinkedHashSet<String>(listStudent);
		System.out.println(setStudent);
	}

}