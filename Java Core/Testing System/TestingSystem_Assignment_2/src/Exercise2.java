import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Exercise2 {

	public static void main(String[] args) {
		// Tao phong ban
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

		// Tao chuc vu
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

		// Tao tai khoan
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

		// Tao nhom
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

		// Group & Account
		Group[] groupOfAccount1 = { group1, group2, group3, group4 };
		account1.groups = groupOfAccount1;

		Group[] groupOfAccount2 = { group2, group3, group4 };
		account2.groups = groupOfAccount2;

		Group[] groupOfAccount3 = { group3, group4, group5 };
		account3.groups = groupOfAccount3;

		Group[] groupOfAccount4 = { group1, group4, group5 };
		account4.groups = groupOfAccount4;

		Group[] groupOfAccount5 = { group1, group5 };
		account5.groups = groupOfAccount5;

		Group[] groupOfAccount6 = { group3 };
		account6.groups = groupOfAccount6;

		Group[] groupOfAccount7 = { group2, group4 };
		account7.groups = groupOfAccount7;

		Account[] accountOfG1 = { account1, account4, account5 };
		group1.accounts = accountOfG1;

		Account[] accountOfG2 = { account1, account2, account7 };
		group2.accounts = accountOfG2;

		Account[] accountOfG3 = { account1, account2, account3, account6 };
		group3.accounts = accountOfG3;

		Account[] accountOfG4 = { account1, account2, account3, account7 };
		group4.accounts = accountOfG4;

		Account[] accountOfG5 = { account3, account4, account5 };
		group5.accounts = accountOfG5;

		// Question 1
		int a = 5;
		System.out.printf("%d %n", a);

		// Question 2
		int a1 = 100000000;
		System.out.printf(Locale.US, "%,d %n", a1);

		// Question 3
		float a2 = 5.567098f;
		System.out.printf("%.4f %n", a2);

		// Question 4
		String name = "Nguyen Trung Dung";
		System.out.printf("Ten toi la %s va toi dang doc than %n", name);
		System.out.println("Ten toi la " + name + " va toi dang doc than");

		// Question 5
		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String formatDateTime = nowDateTime.format(formatter);
		System.out.println(formatDateTime);

		Date date = Calendar.getInstance().getTime();
		System.out.printf("Thoi gian bay gio la: %td/%tm/%tY %tHh:%tMp:%tSs %n", date, date, date, date, date, date);
		
		String pattern = "dd/MM/yyyy HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date2 = simpleDateFormat.format(new Date());
		System.out.println(date2);

		// Question 6
		System.out.printf("%-30s %-30s %s %n", "Email", "FullName", "Department Name");
		Account[] accounts = { account1, account2, account3, account4, account5, account6, account7 };
		for (int i = 0; i < accounts.length; i++) {
			System.out.printf("%-30s %-30s %s %n", accounts[i].email, accounts[i].fullName, accounts[i].department.name);
		}
	}

}
