package hqd.com.frountEnd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import hqd.com.ultil.ScannerUtils;

public class Program {
	private static Function function;

	public static void main(String[] args)
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		  function = new Function();
		int choose = 0;

		// function.getListOfCar();-- lấy danh sách
		// System.out.println(function.getColor());
		// function.AddNewCarFerrari();
		// function.UppdateCarFerrari();
		do {
			menu();
			choose = ScannerUtils.inputInt();
			switch (choose) {
			case 1:
				function.getListOfCar();
				break;
			case 2:
				menuAddCar();
				break;
			case 3:
				MenuUppdateCar();
				break;
			case 4:
				function.deleteCar();
				break;
			case 5:
				function.getExpensiveCar();
				break;
			case 6:
				System.out.println("hẹn bạn lần sau");
				break;
			default:
				System.out.println("bạn đã nhập sai tham số.Mời bạn nhập lại");
			}
		} while (choose != 6);

	}

// tạo menu tổng
	public static void menu() {
		System.out.println("Mời bạn chọn phương thức sau:");
		System.out.println("1: In dang sách các xe của hệ thống");
		System.out.println("2: Thêm xe");
		System.out.println("3: Uppdate thông tin xe");
		System.out.println("4: Xoá thông tin xe");
		System.out.println("5: In ra thông tin 5 xe có giá đắt nhất");
		System.out.println("6: Thoát");

	}

	// tạo menu add Car
	public static void AddCar() {
		System.out.println("1: Add xe Ferrari ");
		System.out.println("2: Add xe Ford ");
		System.out.println("3: Add xe Honda ");
		System.out.println("4: Add xe Mercedes ");
		System.out.println("5: Add xe Toyota ");
		System.out.println("6: thoát");
	}

	// xử lý menu Addcar
	public static void menuAddCar() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		  function = new Function();
		int choose1 = 0;
		do {
			AddCar();
			choose1 = ScannerUtils.inputInt();
			switch (choose1) {
			case 1:
				function.AddNewCarFerrari();
				break;
			case 2:
				function.AddNewCarFord();
				break;
			case 3:
				function.AddNewCarHonda();
				break;
			case 4:
				function.AddNewCarMercedes();
				break;
			case 5:
				function.AddNewCarToyota();
				break;
			case 6:
				break;
			default:
				System.out.println("bạn đã nhập sai tham số.Mời bạn nhập lại");
				break;
			}
		} while (choose1 != 6);
	}

	// tạo menu Uppdate Car
	public static void UppdateCarImformation() {
		System.out.println("1: Uppdate xe Ferrari ");
		System.out.println("2: Uppdate xe Ford ");
		System.out.println("3: Uppdate xe Honda ");
		System.out.println("4: Uppdate xe Mercedes ");
		System.out.println("5: Uppdate xe Toyota ");
		System.out.println("6: thoát");

	}

	// xử lý menu Uppdatecar
	public static void MenuUppdateCar() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		  function = new Function();
		int choose1 = 0;
		do {
			AddCar();
			choose1 = ScannerUtils.inputInt();
			switch (choose1) {
			case 1:
				function.UppdateCarFerrari();
				break;
			case 2:
				function.UppdateCarFord();
				break;
			case 3:
				function.UppdateCarHonda();
				break;
			case 4:
				function.UppdateCarMercedes();
				break;
			case 5:
				function.UppdateCarToyota();
				break;
			case 6:
				break;
			default:
				System.out.println("bạn đã nhập sai tham số.Mời bạn nhập lại");
				break;
			}
		} while (choose1 != 6);
	}
}
