import java.time.LocalDate;

public class Exercise2 {

	public static void main(String[] args) {
		//Question 1 (Default value)
		Q1();
	}
	public static void Q1() {
		class Account {
			String email;
			String userName;
			String fullName;
			LocalDate createDate;
		}
		
		Account[] accounts = new Account[5];
		for (int i = 0; i < accounts.length; i++) {
			Account account = new Account();
			account.email = "Email " + i;
			account.userName = "UserName " + i;
			account.fullName = "FullName " + i;		
			account.createDate = LocalDate.now();
			accounts[i] = account;
			
			System.out.println("Account thu " + i);
			System.out.println("Email: " + accounts[i].email);
			System.out.println("User Name: " + accounts[i].userName);
			System.out.println("Full Name: " + accounts[i].fullName);
			System.out.println("Create Date: " + accounts[i].createDate);
			System.out.println("\n");
		}
		
	}

}
