package com.vti.backend;

import com.vti.entity.Employee;
import com.vti.entity.MyMap;
import com.vti.entity.Phone;
import com.vti.entity.Staff;
import com.vti.entity.Student3;

public class Exercise3 {

	public void question1() {
		Student3<Integer> student1 = new Student3<Integer>(1, "Nguyen Trung Dung");
		Student3<Float> student2 = new Student3<Float>(2f, "Nguyen Thanh Trung");
		Student3<Double> student3 = new Student3<Double>(3.0, "Nguyen Van A");

		print(student1);
		print(student2);
		print(student3);

		print(1);
		print(2f);
		print(3d);
	}

	public <T> void print(T a) {
		System.out.println(a);
	}

	public void question4() {
		Integer[] arrInt = { 1, 2, 3, 4 };
		Float[] arrFloat = { 10f, 20f, 30f, 40f };
		Double[] arrDouble = { 5.5, 6.6, 7.7, 8.8 };

		printArray(arrInt);
		printArray(arrFloat);
		printArray(arrDouble);
	}

	public <T> void printArray(T[] array) {
		for (T arr : array) {
			System.out.println(arr);
		}
	}

	public void question5() {
		Integer[] salaryInt = { 10, 20, 30 };
		Float[] salaryFloat = { 12f, 22f, 33f };
		Double[] salaryDouble = { 15.5, 20.5, 30.5 };

		Employee<Integer> empInt = new Employee<Integer>(1, "Nguyen Trung Dung", salaryInt);
		Employee<Float> empFloat = new Employee<Float>(2, "Nguyen Thanh Trung", salaryFloat);
		Employee<Double> empDouble = new Employee<Double>(3, "Nguyen Van A", salaryDouble);

		System.out.println("Thong tin cac nhan vien: ");
		System.out.println(empInt);
		System.out.println(empFloat);
		System.out.println(empDouble);

		System.out.println("Thong tin thang luong cuoi cung: ");
		System.out.println(empInt.getLastSalary());
		System.out.println(empFloat.getLastSalary());
		System.out.println(empDouble.getLastSalary());
	}

	public void question6() {
		MyMap<Integer, String> student = new MyMap<Integer, String>(1, "Nguyen Trung Dung");
		System.out.println("Id cua sinh vien: " + student.getKey());
		System.out.println("Ten sinh vien: " + student.getValue());
	}

	public void question7() {
		// <email, phone number>
		Phone<String, String> email = new Phone<String, String>("trungdungbka59@gmail.com", "0984735796");
		System.out.println("Email: " + email.getKey() + "\nPhone Number: " + email.getValue());

		// <id, phone number>
		Phone<Integer, String> id = new Phone<Integer, String>(1, "0984735796");
		System.out.println("ID: " + id.getKey() + "\nPhone Number: " + id.getValue());

		// <email, phone number>
		Phone<String, String> user = new Phone<String, String>("ntd", "0984735796");
		System.out.println("User: " + user.getKey() + "\nPhone Number: " + user.getValue());
	}

	public void question8() {
		// Interger
		Staff<Integer, String> staff1 = new Staff<Integer, String>(1, "Nguyen Trung Dung");
		System.out.println("ID: " + staff1.getKey() + "\nName: " + staff1.getValue());

		// Long
		Staff<Long, String> staff2 = new Staff<Long, String>(2L, "Nguyen Trung Dung");
		System.out.println("ID: " + staff2.getKey() + "\nName: " + staff2.getValue());
	}

}
