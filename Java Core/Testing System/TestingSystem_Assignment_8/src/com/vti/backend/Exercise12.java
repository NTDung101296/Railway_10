//STACK & QUEUE
package com.vti.backend;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.vti.entity.Student;

public class Exercise12 {

	public void printStudentLatestToEarliest() {
		Stack<Student> students = new Stack<Student>();
		students.push(new Student("Nguyen Van Nam"));
		students.push(new Student("Nguyen Van Huyen"));
		students.push(new Student("Tran Van Nam"));
		students.push(new Student("Nguyen Van A"));
		
		System.out.println(students.pop());
		System.out.println(students.pop());
		System.out.println(students.pop());
		System.out.println(students.pop());
	}

	public void printStudentEarliestToLatest() {
		Queue<Student> students = new LinkedList<Student>();
		students.add(new Student("Nguyen Van Nam"));
		students.add(new Student("Nguyen Van Huyen"));
		students.add(new Student("Tran Van Nam"));
		students.add(new Student("Nguyen Van A"));
		
		System.out.println(students.poll());
		System.out.println(students.poll());
		System.out.println(students.poll());
		System.out.println(students.poll());
	}

}
