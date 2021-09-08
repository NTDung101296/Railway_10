package com.vti.backend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.MyMath;
import com.vti.entity.MyNumber;
import com.vti.entity.Salary;

public class Exercise4 {
	public void question1() {
		System.out.println("Salary hien tai la: ");
		Salary<Integer> salary = new Salary<Integer>(9640000);
		System.out.println(salary);
	}

	public void question2() {
		MyNumber<Double> number = new MyNumber<Double>(9576.93833);
		System.out.println(number);
	}

	public void question3() {
		MyMath<Integer> math = new MyMath<>();

		int maxInt = math.maximum(1, 22, 1000);
		System.out.println(maxInt);

		float maxFloat = math.maximum(3.5f, 6.88f, 8.3322f);
		System.out.println(maxFloat);
	}

	public void question4() {
		MyMath<Double> mathDouble = new MyMath<>();

		// Add
		double sumDouble = mathDouble.add(5.3333d, 44.5d, 3.5d, 4.67d);
		System.out.println(sumDouble);

		// Substract
		double subDouble = mathDouble.substract(2d, 3d);
		System.out.println(subDouble);

		// Pow
		double powDouble = mathDouble.pow(4d, 5d);
		System.out.println(powDouble);
	}

	public void question5() {
		List<Object> listWildcards = new ArrayList<Object>();
		listWildcards.add("Nguyen Van Nam");
		listWildcards.add(30);
		listWildcards.add("Ha Dong, HN");
		for (Object object : listWildcards) {
			System.out.println(object);
		}
	}
}
