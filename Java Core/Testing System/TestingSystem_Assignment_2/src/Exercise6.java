import java.time.LocalDate;

public class Exercise6 {

	public static void main(String[] args) {


		// Question 1
		System.out.println("Cac so chan nguyen duong nho hon 10 la: ");
		soChan(10);
		
		// Question 2
		Account[] accounts = inputAccounts();
		PrintAccounts(accounts);
		
		//Question 3
		System.out.println("Cac so nguyen duong nho hon 10 la: ");
		soNguyen(10);
		
	}
//Q1
	public static void soChan(int n) {
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}	
		}
	}
	
//Q2
//	public static void PrintAccount(Account[] accounts) {
//		for (int i = 0; i < accounts.length; i++) {
//			System.out.println("Thong tin account thu " + (i + 1) + " la:");
//			System.out.println("name: " + accounts[i].fullName);
//			System.out.println("id: " + accounts[i].id);
//			System.out.println("email: " + accounts[i].email);
//			System.out.println("department: " + accounts[i].department.name);
//			System.out.println("position: " + accounts[i].position.name);
//			System.out.println("createDate: " + accounts[i].createDate);
//			System.out.println("\n");
//		}	
//	}
	
	public static void PrintAccounts(Account[] accounts) {
		for (Account account : accounts) {
			System.out.println("name: " + account.fullName);
			System.out.println("id: " + account.id);
			System.out.println("email: " + account.email);
			System.out.println("department: " + account.department.name);
			System.out.println("position: " + account.position.name);
			System.out.println("createDate: " + account.createDate);
			System.out.println("Group tham gia: ");
			for (Group group : account.groups) {
				System.out.println(group.name);
			}
			System.out.println("\n");
		}	
	}
	
	public static Account[] inputAccounts() {
		//Tao phong ban
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
				
			//Tao chuc vu
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
				
			//Tao tai khoan
				Account account1 = new Account();
				account1.id = 1;
				account1.email = "nguyen-trung.dung@vmec.vn";
				account1.userName = "ntd";
				account1.fullName = "Nguyen Trung Dung";
				account1.department = department4;
				account1.position = position1;
				account1.createDate = LocalDate.of(2018, 10, 1);
				
				Account account2 = new Account();
				account2.id = 2;
				account2.email = "tang-manh.hung@vmec.vn";
				account2.userName = "tmh";
				account2.fullName = "Tang Manh Hung";
				account2.department = department1;
				account2.position = position2;
				account2.createDate = LocalDate.now();
				
				Account account3 = new Account();
				account3.id = 3;
				account3.email = "nguyen-thi.huong@vmec.vn";
				account3.userName = "nth";
				account3.fullName = "Nguyen Thi Huong";
				account3.department = department2;
				account3.position = position4;
				account3.createDate = LocalDate.of(2020, 6, 15);
				
				Account account4 = new Account();
				account4.id = 4;
				account4.email = "mai-ngoc.lenh@vmec.vn";
				account4.userName = "mnl";
				account4.fullName = "Mai Ngoc Lenh";
				account4.department = department5;
				account4.position = position3;
				account4.createDate = LocalDate.of(2015, 12, 1);
				
				Account account5 = new Account();
				account5.id = 5;
				account5.email = "chu-xuan.minh@vmec.vn";
				account5.userName = "cxm";
				account5.fullName = "Chu Xuan Minh";
				account5.department = department3;
				account5.position = position3;
				account5.createDate = LocalDate.of(2010, 8, 7);
				
				Account account6 = new Account();
				account6.id = 6;
				account6.email = "truong-hai.ly@vmec.vn";
				account6.userName = "thl";
				account6.fullName = "Truong Hai Ly";
				account6.department = department1;
				account6.position = position4;
				account6.createDate = LocalDate.of(2018, 9, 1);
				
				Account account7 = new Account();
				account7.id = 7;
				account7.email = "nguyen-dieu.ha@vmec.vn";
				account7.userName = "ndh";
				account7.fullName = "Nguyen Dieu Ha";
				account7.department = department2;
				account7.position = position2;
				account7.createDate = LocalDate.of(2015, 1, 29);
				
			//Tao nhom
				Group group1 = new Group();
				group1.id = 1;
				group1.name = "Testing System";
				group1.creator = account1;
				group1.createDate = LocalDate.now();
				
				Group group2 = new Group();
				group2.id = 2;
				group2.name = "GenZ";
				group2.creator = account6;
				group2.createDate = LocalDate.of(2020, 1, 1);
				
				Group group3 = new Group();
				group3.id = 3;
				group3.name = "Traveling";
				group3.creator = account2;
				group3.createDate = LocalDate.now();
				
				Group group4 = new Group();
				group4.id = 4;
				group4.name = "MND";
				group4.creator = account3;
				group4.createDate = LocalDate.of(2021, 7, 10);
				
				Group group5 = new Group();
				group5.id = 5;
				group5.name = "RND";
				group5.creator = account4;
				group5.createDate = LocalDate.now();
				
			//Group & Account
				Group[] groupOfAccount1 = { group1, group2, group3, group4};
				account1.groups = groupOfAccount1;
				
				Group[] groupOfAccount2 = { group2, group3, group4};
				account2.groups = groupOfAccount2;
				
				Group[] groupOfAccount3 = { group3, group4, group5};
				account3.groups = groupOfAccount3;
				
				Group[] groupOfAccount4 = { group1, group4, group5};
				account4.groups = groupOfAccount4;
				
				Group[] groupOfAccount5 = { group1, group5};
				account5.groups = groupOfAccount5;
				
				Group[] groupOfAccount6 = { group3 };
				account6.groups = groupOfAccount6;
				
				Group[] groupOfAccount7 = { group2, group4 };
				account7.groups = groupOfAccount7;
				
				Account[] accountOfG1 =  { account1, account4, account5 };
				group1.accounts = accountOfG1;
				
				Account[] accountOfG2 =  { account1, account2, account7 };
				group2.accounts = accountOfG2;
				
				Account[] accountOfG3 =  { account1, account2, account3, account6 };
				group3.accounts = accountOfG3;
				
				Account[] accountOfG4 =  { account1, account2, account3, account7 };
				group4.accounts = accountOfG4;
				
				Account[] accountOfG5 =  { account3, account4, account5 };
				group5.accounts = accountOfG5;
				
				Account[] accounts = { account1, account2, account3, account3, account4, account5, account6, account7};
				
				return accounts;
		
	}
//Q3
	public static void soNguyen(int n) {
		for (int i = 0; i < n; i++) {
				System.out.println(i);
		}
	}

}
