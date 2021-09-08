import java.time.LocalDate;
import java.util.Scanner;

public class InoutFromConsole {

	public static void main(String[] args) {

		createAccount();

	}

	public static void createAccount() {
		Scanner scanner = new Scanner(System.in);
		Account account = new Account();

		System.out.println("----------CREATE ACCOUNT---------");

		System.out.println("Moi ban nhap vao id:");
		account.id = scanner.nextShort();
		scanner.nextLine();

		System.out.println("Moi ban nhap vao email:");
		account.email = scanner.nextLine();

		System.out.println("Moi ban nhap vao userName:");
		account.userName = scanner.nextLine();

		System.out.println("Moi ban nhap vao fullName:");
		account.fullName = scanner.nextLine();

		boolean isDepartmentName = false;
		do {
			System.out.println("Moi ban nhap vao ten department:");
			String departmentName = scanner.nextLine();

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
			System.out.println("Moi ban nhap vao Position: ");
			String positionName = scanner.nextLine();
			Position[] positions = inputPositions();

			for (Position position : positions) {
				if (positionName.equals(position.name.toString())) {
					account.position = position;
					isPositionName = true;
					break; // thoat khi tim thay phong ban
				}
			}
				if (isPositionName == false) {
					System.out.println("TEN VI TRI BAN NHAP CHUA DUNG, MOI BAN NHAP LAI!");
				}
		} while (isPositionName == false);

		account.createDate = LocalDate.now();
		account.groups = null;

		System.out.println("Ban da tao tai khoan thanh cong");
		scanner.close();
		
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

}
