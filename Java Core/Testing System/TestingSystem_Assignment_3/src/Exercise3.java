
public class Exercise3 {

	public static void main(String[] args) {
	//Boxing & Unboxing
		//Question 1
		Q1();
		
		//Question 2
		Q2();
		
		//Question 3
		Q3();
		
	}
	
	public static void Q1() {
		int salary = 5000;
		float fSalary = (float) salary;
		System.out.printf("%.2f%n", fSalary);
	}
	
	public static void Q2() {
		String s = "1234567";
		int i1 = Integer.parseInt(s);
		System.out.println(i1);
	}
	
	public static void Q3() {
		Integer i2 = 1234567;
		int i3 = i2.intValue();
		System.out.println(i3);
	}

}
