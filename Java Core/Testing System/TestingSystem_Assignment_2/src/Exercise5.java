import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Exercise5 {
	public static void main(String[] args) {
		// Question 1: Viet lenh cho phep nguoi dung nhap 3 so nguyen vao chuong trinh
		inputThreeIntergers();

		// Question 2: Viet lenh cho phep nguoi dung nhap 2 so thuc vao chuong trinh
		inputTwoFloats();

		// Question 3: Viet lenh cho phep nguoi dung nhap ho va ten
		inputFullName();

		// Question 4: Viet lenh cho phep nguoi dung nhap vao ngay sinh cua ho
		inputBirthDay();

		// Question 5: Viet lenh cho phep nguoi dung tao Account (viet thanh Method)
		createAccount();

		// Question 6: Viet lenh cho phep nguoi dung tao Department (viet thanh Method)
		createDepartment();

		// Question 7: Nhap so chan tu console
		System.out.println("----------INPUT EVEN NUMBER---------");
		inputEvenNumber();

		// Question 8: Viet chuong trinh thuc hien chuc nang muon sd
		System.out.println("----------INPUT FUNCTION---------");
		inputFunction();

		// Question 9: Them group vao account
		addGroupForAccount();

		// Question 10: Them chuc nang group vao account
		inputFunction2();

		// Question 11: Them chuc nang group ngau nhien vao account
		inputFunction3();

	}

	// Q1
	public static void inputThreeIntergers() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap vao 3 so nguyen");
		System.out.println("Nhap vao so thu nhat: ");
		int i1 = sc.nextInt();

		System.out.println("Nhap vao so thu hai: ");
		int i2 = sc.nextInt();

		System.out.println("Nhap vao so thu ba: ");
		int i3 = sc.nextInt();
		System.out.println("Ban vua nhap vao cac so nguyen: " + i1 + " " + i2 + " " + i3 + "\n");

		sc.close();
	}

	// Q2
	public static void inputTwoFloats() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap vao 2 so thuc");
		System.out.println("Nhap vao so thu nhat: ");
		float f1 = sc.nextFloat();

		System.out.println("Nhap vao so thu hai: ");
		float f2 = sc.nextFloat();

		System.out.println("Ban vua nhap vao cac thuc: " + f1 + " " + f2 + "\n");

		sc.close();
	}

	// Q3
	public static void inputFullName() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Moi ban nhap vao Ho: ");
		String s1 = sc.nextLine(); // or next()

		System.out.println("Moi ban nhap vao ten: ");
		String s2 = sc.nextLine();

		System.out.println("Fullname cua ban la: " + s1 + " " + s2 + "\n");

		sc.close();
	}

	// Q4
	public static void inputBirthDay() {
		Scanner sc4 = new Scanner(System.in);
		System.out.println("Moi ban nhap vao nam sinh: ");
		int year = sc4.nextInt();

		System.out.println("Moi ban nhap vao thang sinh: ");
		int month = sc4.nextInt();

		System.out.println("Moi ban nhap vao ngay sinh: ");
		int day = sc4.nextInt();

		LocalDate dateBirth = LocalDate.of(year, month, day);
		System.out.println("Ngay sinh cua ban la: " + dateBirth + "\n");

		sc4.close();
	}

	// Q5
	public static void createAccount() {
		Scanner sc = new Scanner(System.in);
		Account account = new Account();

		System.out.println("----------CREATE ACCOUNT---------");

		System.out.println("Moi ban nhap vao id:");
		account.id = sc.nextShort();
		sc.nextLine();

		System.out.println("Moi ban nhap vao email:");
		account.email = sc.nextLine();

		System.out.println("Moi ban nhap vao userName:");
		account.userName = sc.nextLine();

		System.out.println("Moi ban nhap vao fullName:");
		account.fullName = sc.nextLine();

		boolean isDepartmentName = false;
		do {
			System.out.println("Moi ban nhap vao ten phong ban:");
			String departmentName = sc.nextLine();

			Department[] departments = inputDepartments();

			for (Department department : departments) {
				if (departmentName.equals(department.name)) {
					account.department = department;
					isDepartmentName = true;
					break; // thoat khi tim thay phong ban
				}
			}
			if (isDepartmentName == false) {
				System.out.println("TEN PHONG BAN BAN NHAP CHUA DUNG, MOI BAN NHAP LAI!");
			}
		} while (isDepartmentName == false);

		boolean isPositionName = false;
		do {
			System.out.println("Moi ban nhap vao vi tri: ");
			String positionName = sc.nextLine();
			Position[] positions = inputPositions();

			for (Position position : positions) {
				if (positionName.equals(position.name.toString())) {
					account.position = position;
					isPositionName = true;
					break; // thoat khi tim thay vi tri
				}
			}
			if (isPositionName == false) {
				System.out.println("TEN VI TRI BAN NHAP CHUA DUNG, MOI BAN NHAP LAI!");
			}
		} while (isPositionName == false);

		account.createDate = LocalDate.now();
		account.groups = null;

		System.out.println("Ban da tao tai khoan thanh cong!");
		System.out.println("THONG TIN TAI KHOAN VUA TAO: \n ID: " + account.id + "\n Email: " + account.email
				+ "\n UserName: " + account.userName + "\n FullName: " + account.fullName + "\n Department: "
				+ account.department.name + " \n Position: " + account.position.name + "\n CreateDate: "
				+ account.createDate + "\n Groups: " + account.groups + "\n");

		sc.close();
	}

	public static Department[] inputDepartments() {
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sales";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Marketing";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "Training";

		Department department4 = new Department();
		department4.id = 4;
		department4.name = "Support";

		Department department5 = new Department();
		department5.id = 5;
		department5.name = "Service";

		Department[] departments = { department1, department2, department3, department4, department5 };
		return departments;
	}

	public static Position[] inputPositions() {
		Position position1 = new Position();
		position1.id = 1;
		position1.name = PositionName.DEV;

		Position position2 = new Position();
		position2.id = 2;
		position2.name = PositionName.TEST;

		Position position3 = new Position();
		position3.id = 3;
		position3.name = PositionName.SCRUM_MASTER;

		Position position4 = new Position();
		position4.id = 4;
		position4.name = PositionName.PM;

		Position[] positions = { position1, position2, position3, position4 };
		return positions;
	}

	

	// Q6
	public static void createDepartment() {
		Scanner sc = new Scanner(System.in);
		Department department = new Department();

		System.out.println("----------CREATE DEPARTMENT---------");
		
		//Kiem tra xem co trung voi id phong ban hien co
		boolean isIdDepartmentExist;
		do {
			System.out.println("Moi ban nhap vao id:");
			department.id = sc.nextByte();
			isIdDepartmentExist = isIdDepartmentExist(department.id);
			if (isIdDepartmentExist(department.id) == true) {
				System.out.println("Id da ton tai, vui long nhap lai!");
			}
		} while (isIdDepartmentExist == true);

		sc.nextLine();

		//Kiem tra xem co trung voi ten phong ban hien co
		boolean isNameDepartmentExist;
		do {
			System.out.println("Moi ban nhap vao ten phong ban:");
			department.name = sc.nextLine();
			isNameDepartmentExist = isNameDepartmentExist(department.name);
			if (isNameDepartmentExist(department.name) == true) {
				System.out.println("Ten phong ban da ton tai, vui long nhap lai!");
			}
		} while (isNameDepartmentExist == true);

		System.out.println("Ban da tao phong ban thanh cong");
		System.out.println(
				"THONG TIN DEPARTMENT VUA TAO: \n ID: " + department.id + "\n Name: " + department.name + "\n");

		sc.close();
	}

	// Q7
	public static void inputEvenNumber() {
		Scanner sc = new Scanner(System.in);
		boolean isEvenNumber = false;
		while (isEvenNumber == false) {
			System.out.println("Hay nhap vao 1 so chan:");
			int a = sc.nextInt();
			if (a % 2 == 0) {
				System.out.println("Ban vua nhap vao so:" + a);
				isEvenNumber = true;
				// return; Neu sd se khong thuc hien cau lenh phia duoi
			} else {
				System.out.println("Nhap sai, day khong phai so chan!");
			}
		}
		sc.close();
	}

	// Q8
	public static void inputFunction() {
		Scanner sc = new Scanner(System.in);
		int choose = 0;

		do {
			System.out.println("Moi ban chon chuc nang muon su dung");
			System.out.println(" 1.Tao Account \n 2.Tao Department \n 3.Thoat khoi chuong trinh");
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				createAccount();
				break;
			case 2:
				createDepartment();
				break;
			case 3:
				System.out.println("Hen gap lai ban lan sau!");
				break;
			default:
				System.out.println("Moi ban nhap lai!");
				break;
			}
		} while (choose != 3);
		
		sc.close();
	}

	// Q9
	public static void addGroupForAccount() {
		Scanner sc = new Scanner(System.in);
		Group[] groups = inputGroups();
		Account[] accounts = inputAccounts();

		System.out.println("Danh sach UserName co tren he thong: ");
		for (int i = 0; i < accounts.length; i++) {
			System.out.println(accounts[i].userName);
		}

		// Kiem tra xem userName co ton tai hay khong?
		String userName;
		boolean isUserNameExist;
		do {
			System.out.println("Nhap vao UserName cua Account: ");
			userName = sc.nextLine();
			isUserNameExist = isUserNameExist(userName);

			if (isUserNameExist(userName) == false) {
				System.out.println("Username ban nhap khong ton tai, moi ban nhap lai!");
			}
		} while (isUserNameExist == false);

		Account account = findAccountByUsername(userName);

		System.out.println("Danh sach Groups dang co tren he thong: ");
		for (int i = 0; i < groups.length; i++) {
			System.out.println(groups[i].name);
		}

		// Kiem tra xem ten group co ton tai hay khong?
		String groupName;
		boolean isGroupNameExist;
		do {
			System.out.println("Nhap vao ten Group: ");
			groupName = sc.nextLine();
			isGroupNameExist = isGroupNameExist(groupName);

			if (isGroupNameExist(groupName) == false) {
				System.out.println("Ten group ban nhap khong ton tai, moi ban nhap lai!");
			}
		} while (isGroupNameExist == false);

		Group group = findGroupByName(groupName);

		// Them group vao account
		Group[] groups2 = { group };
		account.groups = groups2;
		System.out.println("Ban vua them group: " + group.name + " cho Account: " + account.userName);
		
		sc.close();
	}
	
	public static Account[] inputAccounts() {
		Account account1 = new Account();
		account1.id = 1;
		account1.email = "nguyen-trung.dung@vmec.vn";
		account1.userName = "ntd";
		account1.fullName = "Nguyen Trung Dung";
		account1.createDate = LocalDate.of(2018, 10, 1);

		Account account2 = new Account();
		account2.id = 2;
		account2.email = "tang-manh.hung@vmec.vn";
		account2.userName = "tmh";
		account2.fullName = "Tang Manh Hung";
		account2.createDate = LocalDate.now();

		Account account3 = new Account();
		account3.id = 3;
		account3.email = "nguyen-thi.huong@vmec.vn";
		account3.userName = "nth";
		account3.fullName = "Nguyen Thi Huong";
		account3.createDate = LocalDate.of(2020, 6, 15);

		Account account4 = new Account();
		account4.id = 4;
		account4.email = "mai-ngoc.lenh@vmec.vn";
		account4.userName = "mnl";
		account4.fullName = "Mai Ngoc Lenh";
		account4.createDate = LocalDate.of(2015, 12, 1);

		Account account5 = new Account();
		account5.id = 5;
		account5.email = "chu-xuan.minh@vmec.vn";
		account5.userName = "cxm";
		account5.fullName = "Chu Xuan Minh";
		account5.createDate = LocalDate.of(2010, 8, 7);

		Account account6 = new Account();
		account6.id = 6;
		account6.email = "truong-hai.ly@vmec.vn";
		account6.userName = "thl";
		account6.fullName = "Truong Hai Ly";
		account6.createDate = LocalDate.of(2018, 9, 1);

		Account account7 = new Account();
		account7.id = 7;
		account7.email = "nguyen-dieu.ha@vmec.vn";
		account7.userName = "ndh";
		account7.fullName = "Nguyen Dieu Ha";
		account7.createDate = LocalDate.of(2015, 1, 29);

		Account[] accounts = { account1, account2, account3, account4, account5, account6, account7 };
		return accounts;
	}

	public static Group[] inputGroups() {
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Testing System";
		group1.createDate = LocalDate.now();

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "GenZ";
		group2.createDate = LocalDate.of(2020, 1, 1);

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Traveling";
		group3.createDate = LocalDate.now();

		Group group4 = new Group();
		group4.id = 4;
		group4.name = "MND";
		group4.createDate = LocalDate.of(2021, 7, 10);

		Group group5 = new Group();
		group5.id = 5;
		group5.name = "RND";
		group5.createDate = LocalDate.now();

		Group[] groups = { group1, group2, group3, group4, group5 };
		return groups;
	}

	public static boolean isUserNameExist(String userName) {
		Account[] accounts = inputAccounts();

		for (Account account : accounts) {
			if (userName.equals(account.userName)) {
				return true;
			}
		}
		return false;
	}

	public static Account findAccountByUsername(String userName) {
		Account[] accounts = inputAccounts();
		for (Account account : accounts) {
			if (userName.equals(account.userName)) {
				return account;
			}
		}
		return null;
	}

	public static boolean isGroupNameExist(String groupName) {
		Group[] groups = inputGroups();
		for (Group group : groups) {
			if (groupName.equals(group.name)) {
				return true;
			}
		}
		return false;
	}

	public static Group findGroupByName(String groupName) {
		Group[] groups = inputGroups();
		for (Group group : groups) {
			if (groupName.equals(group.name)) {
				return group;
			}
		}
		return null;
	}
	
	// Q10
	public static void inputFunction2() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int choose;
		String yesNo;

		do {
			System.out.println("Moi ban chon chuc nang muon su dung");
			System.out.println(" 1.Tao Account \n 2.Tao Department \n 3.Them group vao account");
			choose = sc.nextInt();
			if (choose == 1 || choose == 2 || choose == 3) {
				switch (choose) {
				case 1:
					createAccount();
					break;
				case 2:
					createDepartment();
					break;
				case 3:
					addGroupForAccount();
					break;
				}
				sc.nextLine();

				System.out.print("Ban co muon tiep tuc khong? (Y/N)");
				yesNo = sc.nextLine();
				if (yesNo.equals("N") || yesNo.equals("n")) {
					System.out.println("Ket thuc chuong trinh, hen gap lai!");
					return;
				}
			} else {
				System.out.println("Moi nhap lai!");
			}
		} while (true);
	}

	// Q11
	public static void inputFunction3() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int choose;
		String yesNo;

		do {
			System.out.println("Moi ban chon chuc nang muon su dung");
			System.out.println(
					" 1.Tao Account \n 2.Tao Department \n 3.Them group vao account \n 4.Them group ngau nhien cho account");
			choose = sc.nextInt();
			if (choose == 1 || choose == 2 || choose == 3 || choose == 4) {
				switch (choose) {
				case 1:
					createAccount();
					break;
				case 2:
					createDepartment();
					break;
				case 3:
					addGroupForAccount();
					break;
				case 4:
					addGroupRandomForAccount();
					break;
				}
				sc.nextLine();

				System.out.print("Ban co muon tiep tuc khong? (Y/N)");
				yesNo = sc.nextLine();
				if (yesNo.equals("N") || yesNo.equals("n")) {
					System.out.println("Ket thuc chuong trinh, hen gap lai!");
					return;
				}
			} else {
				System.out.println("Moi nhap lai!");
			}
		} while (true);
	}

	public static void addGroupRandomForAccount() {
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		Group[] groups = inputGroups();
		Account[] accounts = inputAccounts();

		System.out.println("Danh sach UserName co tren he thong: ");
		for (int i = 0; i < accounts.length; i++) {
			System.out.println(accounts[i].userName);
		}

		// Kiem tra xem userName co ton tai hay khong?
		String userName;
		boolean isUserNameExist;
		do {
			System.out.println("Nhap vao UserName cua Account: ");
			userName = sc.nextLine();
			isUserNameExist = isUserNameExist(userName);

			if (isUserNameExist(userName) == false) {
				System.out.println("Username ban nhap khong ton tai, moi ban nhap lai!");
			}
		} while (isUserNameExist == false);

		Account account = findAccountByUsername(userName);

		Group group = groups[random.nextInt(groups.length)];
		System.out.println("Lay ngau nhien mot group: " + group.name);

		Group[] groups2 = { group };

		// Them group vao account
		account.groups = groups2;
		System.out.println("Ban vua them group: " + group.name + " cho Account: " + account.userName);
		
		sc.close();
	}

	public static boolean isIdDepartmentExist(byte id) {
		Department[] departments = inputDepartments();

		for (Department department : departments) {
			if (id == department.id) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNameDepartmentExist(String name) {
		Department[] departments = inputDepartments();

		for (Department department : departments) {
			if (name.equals(department.name)) {
				return true;
			}
		}
		return false;
	}

}
