package com.vti.frontend;

import com.vti.entity.CPU;
import com.vti.entity.Car;

public class InnerClass {

	public static void main(String[] args) {
		// Question 1:
		CPU cpu = new CPU(500f);
		CPU.Processor processor = cpu.new Processor();
		CPU.Ram ram = cpu.new Ram();
		System.out.println("Price= " + cpu + " Cache= " + processor.getCache() + " ClockSpeed= " + ram.getClockSpeed());

		// Question 2:
		Car car = new Car("Mazda", "8WD");

		Car.Engine engine = car.new Engine("Crysler");
		System.out.println(car + " " + engine);
	}

}
