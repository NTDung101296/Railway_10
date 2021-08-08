import java.time.LocalDate;

public class Program {
	public static void main(String[] args) {
		
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
		
	//Tao loai cau hoi
		TypeQuestion typeQuestion1 = new TypeQuestion();
		typeQuestion1.id = 1;
		typeQuestion1.name = TypeName.ESSAY;
		
		TypeQuestion typeQuestion2 = new TypeQuestion();
		typeQuestion2.id = 2;
		typeQuestion2.name = TypeName.MULTIPLE_CHOICE;
	
	//Tao chu de cau hoi
		
		CategoryQuestion categoryQuestion1 = new CategoryQuestion();
		categoryQuestion1.id = 1;
		categoryQuestion1.name = CategoryName.JAVA;
		
		CategoryQuestion categoryQuestion2 = new CategoryQuestion();
		categoryQuestion2.id = 2;
		categoryQuestion2.name = CategoryName.NET;
		
		CategoryQuestion categoryQuestion3 = new CategoryQuestion();
		categoryQuestion3.id = 3;
		categoryQuestion3.name = CategoryName.SQL;
		
		CategoryQuestion categoryQuestion4 = new CategoryQuestion();
		categoryQuestion4.id = 4;
		categoryQuestion4.name = CategoryName.POSTMAN;
		
		CategoryQuestion categoryQuestion5 = new CategoryQuestion();
		categoryQuestion5.id = 5;
		categoryQuestion5.name = CategoryName.RUBY;
	
	//Tao cau hoi	
		Question question1 = new Question();
		question1.id = 1;
		question1.content = "Hoi ve Java";
		question1.category = categoryQuestion1;
		question1.type = typeQuestion2;
		question1.creator = account3;
		question1.createDate = LocalDate.now();
		
		Question question2 = new Question();
		question2.id = 2;
		question2.content = "Hoi ve NET";
		question2.category = categoryQuestion2;
		question2.type = typeQuestion1;
		question2.creator = account2;
		question2.createDate = LocalDate.now();
		
		Question question3 = new Question();
		question3.id = 3;
		question3.content = "Hoi ve SQL";
		question3.category = categoryQuestion3;
		question3.type = typeQuestion1;
		question3.creator = account1;
		question3.createDate = LocalDate.of(2020, 12, 10);
		
		Question question4 = new Question();
		question4.id = 4;
		question4.content = "Hoi ve POSTMAN";
		question4.category = categoryQuestion4;
		question4.type = typeQuestion2;
		question4.creator = account5;
		question4.createDate = LocalDate.now();
		
		Question question5 = new Question();
		question5.id = 5;
		question5.content = "Hoi ve RUBY";
		question5.category = categoryQuestion1;
		question5.type = typeQuestion1;
		question5.creator = account6;
		question5.createDate = LocalDate.now();
		
	//Cau tra loi
		Answer answer1 = new Answer();
		answer1.id = 1;
		answer1.content = "Tra loi 01";
		answer1.question = question1;
		answer1.isCorrect = true;

		Answer answer2 = new Answer();
		answer2.id = 2;
		answer2.content = "Tra loi 02";
		answer2.question = question4;
		answer2.isCorrect = true;
		
		Answer answer3 = new Answer();
		answer3.id = 3;
		answer3.content = "Tra loi 03";
		answer3.question = question5;
		answer3.isCorrect = false;
		
		Answer answer4 = new Answer();
		answer4.id = 4;
		answer4.content = "Tra loi 04";
		answer4.question = question3;
		answer4.isCorrect = true;
		
		Answer answer5 = new Answer();
		answer5.id = 5;
		answer5.content = "Tra loi 05";
		answer5.question = question2;
		answer5.isCorrect = false;
		
	//De thi
		Exam exam1 = new Exam();
		exam1.id = 1;
		exam1.code = "101";
		exam1.title = "De thi JAVA";
		exam1.category = categoryQuestion1;
		exam1.duration = 15;
		exam1.creator = account7;
		exam1.createDate = LocalDate.now();
		
		Exam exam2 = new Exam();
		exam2.id = 2;
		exam2.code = "102";
		exam2.title = "De thi RUBY";
		exam2.category = categoryQuestion5;
		exam2.duration = 45;
		exam2.creator = account2;
		exam2.createDate = LocalDate.now();
		
		Exam exam3 = new Exam();
		exam3.id = 3;
		exam3.code = "103";
		exam3.title = "De thi POSTMAN";
		exam3.category = categoryQuestion4;
		exam3.duration = 60;
		exam3.creator = account5;
		exam3.createDate = LocalDate.now();
		
		Exam exam4 = new Exam();
		exam4.id = 4;
		exam4.code = "104";
		exam4.title = "De thi NET";
		exam4.category = categoryQuestion2;
		exam4.duration = 120;
		exam4.creator = account6;
		exam4.createDate = LocalDate.now();
		
		Exam exam5 = new Exam();
		exam5.id = 5;
		exam5.code = "105";
		exam5.title = "De thi SQL";
		exam5.category = categoryQuestion3;
		exam5.duration = 5;
		exam5.creator = account4;
		exam5.createDate = LocalDate.now();

	//Exam & Question
		Exam[] questionOfExam1 = { exam1, exam5 };
		question1.exams = questionOfExam1;
		
		Exam[] questionOfExam2 = { exam2, exam3 };
		question2.exams = questionOfExam2;
		
		Exam[] questionOfExam3 = { exam2, exam4, exam5 };
		question3.exams = questionOfExam3;
		
		Exam[] questionOfExam4 = { exam1, exam2, exam3, exam5 };
		question4.exams = questionOfExam4;
		
		Exam[] questionOfExam5 = { exam1, exam2, exam3, exam4, exam5 };
		question5.exams = questionOfExam5;
				
		Question[] examByQuestion1 =  { question1, question4, question5 };
		exam1.questions = examByQuestion1;
		
		Question[] examByQuestion2 =  { question2, question3, question4, question5 };
		exam2.questions = examByQuestion2;
		
		Question[] examByQuestion3 =  { question2, question4, question5 };
		exam3.questions = examByQuestion3;
		
		Question[] examByQuestion4 =  { question3, question5 };
		exam4.questions = examByQuestion4;
		
		Question[] examByQuestion5 =  { question1, question3, question4, question5 };
		exam5.questions = examByQuestion5;
		
	//In ra doi tuong
		//1.Thong tin phong ban
		System.out.println("Thong tin phong ban 1: ");
		System.out.println("name: " + department1.name);
		System.out.println("id: " + department1.id);
		System.out.println("\n");
		
		//2.Thong tin chuc vu
		System.out.println("Thong tin chuc vu 1: ");
		System.out.println("name: " + position1.name);
		System.out.println("id: " + position1.id);
		System.out.println("\n");
		
		//3.Thong tin nhan vien
		System.out.println("Thong tin nhan vien 1: ");
		System.out.println("name: " + account1.fullName);
		System.out.println("id: " + account1.id);
		System.out.println("email: " + account1.email);
		System.out.println("department: " + account1.department.name);
		System.out.println("position: " + account1.position.name);
		System.out.println("createDate: " + account1.createDate);
		// System.out.println("groups: " + account1.groups);
		System.out.println("\n");
		
		//4.Thong tin nhom
		System.out.println("Thong tin nhom 1: ");
		System.out.println("name: " + group1.name);
		System.out.println("id: " + group1.id);
		System.out.println("creator: " + group1.creator.fullName);
		System.out.println("createDate: " + group1.createDate);
		System.out.println("\n");
		
		//5. Thong tin loai cau hoi
		System.out.println("Thong tin loai cau hoi 1: ");
		System.out.println("name: " + typeQuestion1.name);
		System.out.println("id: " + typeQuestion1.id);
		System.out.println("\n");
		
		//6. Thong tin chu de cau hoi
		System.out.println("Thong tin chu de cau hoi 1: ");
		System.out.println("name: " + categoryQuestion1.name);
		System.out.println("id: " + categoryQuestion1.id);
		System.out.println("\n");
		
		//7. Thong tin cau hoi
		System.out.println("Thong tin cau hoi 1: ");
		System.out.println("content: " + question1.content);
		System.out.println("id: " + question1.id);
		System.out.println("category: " + question1.category.name);
		System.out.println("type: " + question1.type.name);
		System.out.println("creator: " + question1.creator.fullName);
		System.out.println("createDate: " + question1.createDate);
		System.out.println("\n");
		
		//8. Thong tin cau tra loi
		System.out.println("Thong tin cau tra loi 1: ");
		System.out.println("content: " + answer1.content);
		System.out.println("id: " + answer1.id);
		System.out.println("question: " + answer1.question.content);
		System.out.println("isCorrect: " + answer1.isCorrect);
		System.out.println("\n");
		
		//9. Thong tin de thi
		System.out.println("Thong tin de thi 1: ");
		System.out.println("id: " + exam1.id);
		System.out.println("code: " + exam1.code);
		System.out.println("title: " + exam1.title);
		System.out.println("category: " + exam1.category.name);
		System.out.println("duration: " + exam1.duration);
		System.out.println("creator: " + exam1.creator.fullName);
		System.out.println("createDate: " + exam1.createDate);
		System.out.println("\n");
		
	}

}
