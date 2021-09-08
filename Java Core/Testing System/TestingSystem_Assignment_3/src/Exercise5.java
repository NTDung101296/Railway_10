

public class Exercise5 {

	public static void main(String[] args) {
		// Question 1: In ra thong tin cua phong ban thu nhat

		Department[] departments = inputDepartments();

		System.out.println(departments[0]);

		// Question 2: In ra thong tin cua tat ca phong ban

		for (Department department : departments) {
			System.out.println(department);
		}

		// Question 3: In ra dia chi phong ban thu nhat

		System.out.println(departments[0].hashCode());

		// Question 4: Kiem tra xem phong ban thu nhat co ten la "Phong A" khong?

		if (departments[0].name.equals("Phong A")) {
			System.out.println("Co ten la phong A");
		} else {
			System.out.println("Khong ten la phong A");
		}

		// Question 5: So sanh 2 phong ban thu 1 va thu 2 co bang nhau khong
		if (departments[0].equals(departments[1])) {
			System.out.println("Co bang nhau");
		} else {
			System.out.println("Khong bang nhau");
		}

		// Question 6: In ra danh sach phong ban sap xep theo ABCD
        Q6(departments);
		// Question 7: In ra danh sach phong ban sap xep theo ABCD
        Q7(departments);
	}

	public static Department[] inputDepartments() {
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Accounting";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Sale";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "Marketing";

		Department department4 = new Department();
		department4.id = 4;
		department4.name = "Waiting room";

		Department department5 = new Department();
		department5.id = 5;
		department5.name = "Boss of director";

		Department[] departments = { department1, department2, department3, department4, department5 };
		return departments;
	}

	public static void Q6(Department[] departments) {
		for (int i = 0; i < departments.length; i++) {
			for (int j = 0; j < departments.length - 1; j++) {
				if (departments[i].name.compareToIgnoreCase(departments[j].name) < 0) {
					Department result = departments[i];
					departments[i] = departments[j];
					departments[j] = result;
				}
			}
		}
		for (Department department : departments) {
			System.out.println(department.name);
		}
	}
	
	public static void Q7(Department[] departments) {
		for (int i = 0; i < departments.length; i++) {
			String str1 = Reverse(departments[i].name);
			for (int j = 0; j < departments.length - 1; j++) {
				String str2 = Reverse(departments[j].name);
				if (str1.compareToIgnoreCase(str2) < 0) {
					Department result = departments[i];
					departments[i] = departments[j];
					departments[j] = result;
				}
			}
		}
		for (Department department : departments) {
			System.out.println(department.name);
		}
	}

	//Dao nguoc chuoi
	public static String Reverse(String str) {
		// Xoa khoang trang o dau va cuoi chuoi
		str = str.trim();

		// Tach chuoi dua tren khoang trang, \s: ky tu khoang trang
		String[] strings = str.split("\\s");
		str = "";
		for (int i = strings.length - 1; i >= 0; i--) {
			str += strings[i] + " ";
		}
		return str;
	}
}
