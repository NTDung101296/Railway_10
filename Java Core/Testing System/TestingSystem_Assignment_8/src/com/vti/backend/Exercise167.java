//SET
package com.vti.backend;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Exercise167 {
	private static Map<Integer, String> students;

	public Exercise167() {
		students = new HashMap<Integer, String>();
		addStudent();
	}

	public void addStudent() {
		students.put(1, "Nguyen Van E");
		students.put(2, "Nguyen Van B");
		students.put(3, "Nguyen Van C");
		students.put(4, "Nguyen Van A");
		students.put(5, "Nguyen Van D");
		students.put(6, "Nguyen Van A");
	}

	public void printKey() {
		System.out.println("Cac key cua students:");
		Set<Integer> set = students.keySet();
		for (Integer key : set) {
			System.out.println(key);
		}
		// Sd Map.Entry interface
//		for (Map.Entry<Integer, String> entry : students.entrySet()) {
//			System.out.println(entry.getKey());
//		}
	}

	public void printValue() {
		System.out.println("Cac value cua students:");
		for (Map.Entry<Integer, String> entry : students.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

	public void convertMapToSet() {
		Set<Entry<Integer, String>> setStudent = students.entrySet();
		for (Entry<Integer, String> entry : setStudent) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}