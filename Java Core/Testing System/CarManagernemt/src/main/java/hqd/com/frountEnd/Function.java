package hqd.com.frountEnd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import hqd.com.backend.controller.CarController;
import hqd.com.entity.Car;
import hqd.com.entity.CarColor;
import hqd.com.entity.CarCompany;
import hqd.com.ultil.ScannerUtils;

public class Function {
	private CarController controller;

	public Function() throws FileNotFoundException, IOException {
		controller = new CarController();
	}

// ------------------------------get List--------------------------------------------------------------------------------------------------------
	public void getListOfCar() throws ClassNotFoundException, SQLException {
		List<Car> cars= null;
		 cars = controller.GetListCar();
		for (Car car : cars) {
			System.out.println(car);
		}
	}

// -------------------------------------------------Choose color -----------------------------------------------------------------------------------------
	public CarColor getColor() {
		int choose;
		CarColor color = null;
		do {
			System.out.println("Mời chọn màu của xe");
			System.out.println("1:đỏ" + " 2:xanh" + " 3:trắng" + " 4:đen");
			choose = ScannerUtils.inputId();
			switch (choose) {

			case 1:
				color = CarColor.red;
				break;
			case 2:
				color = CarColor.blue;
				break;
			case 3:
				color = CarColor.white;
				break;
			case 4:
				color = CarColor.black;
				break;
			default:
				System.out.println("bạn đã nhập sai mời nhập lại");
			}

		} while (choose > 4 || choose < 0);
		return color;
	}

	// -------------------------------------------------AddNewCar----------------------------------------------------------------------------------
	public void AddNewCarFerrari() throws ClassNotFoundException, SQLException {
		
		System.out.println("nhập tên xe(phải có 4 số đằng sau)");
		String name ="Fer"+ ScannerUtils.inputIntName();
		System.out.println(" Mời bạn nhập màu");
		CarColor color = getColor();
		System.out.println("Mời bạn nhập giá trị của xe(chỉ được nhập 5 số)");
		int price = ScannerUtils.inputPrice();
		System.out.println("Đây là hãng xe ferrari");
		CarCompany nameCompany = CarCompany.Ferrari;
		System.out.println("Nhập phụ kiện cần có của xe(phải có mã code có 3 số ở đầu và 2 chữ ở cuối)");
		String rareAccessary ="Fer"+ ScannerUtils.inputCodeFer();
		System.out.println("Nhập kiểu xe(phải có mã code 4 chữ số)");
		String carTypeRare = "Fer"+ScannerUtils.inputIntName();
		controller.AddNewCarferrari(name, color, price, nameCompany, rareAccessary, carTypeRare);
	}

	public void AddNewCarFord() throws ClassNotFoundException, SQLException {
		System.out.println("nhập tên xe(phải có 4 số đằng sau)");
		String name ="Ford"+ ScannerUtils.inputIntName();
		System.out.println(" Mời bạn nhập màu");
		CarColor color = getColor();
		System.out.println("Mời bạn nhập giá trị của xe(chỉ được nhập 5 số)");
		int price = ScannerUtils.inputPrice();
		System.out.println("Đây là hãng xe Ford");
		CarCompany nameCompany = CarCompany.Ford;
		System.out.println("Nhập phụ kiện cần có của xe(phải có mã code có 3 số ở đầu và 2 chữ ở cuối)");
		String rareAccessary ="Ford"+ ScannerUtils.inputCodeFer();
		System.out.println("Nhập nhiên liệu thiên nhiên mà xe dùng(nhập mã code 4 chữ in hoa và 1 số)");
		String carFuelEnvironmental ="dầu"+ ScannerUtils.inputFuelEnvironmentalName();
		controller.AddNewFord(name, color, price, nameCompany, rareAccessary, carFuelEnvironmental);
	}

	public void AddNewCarHonda() throws ClassNotFoundException, SQLException {
		System.out.println("nhập tên xe(phải có 4 số đằng sau)");
		String name ="Honda"+ScannerUtils.inputIntName();
		System.out.println(" Mời bạn nhập màu");
		CarColor color = getColor();
		System.out.println("Mời bạn nhập giá trị của xe:(chỉ được nhập 5 số)");
		int price = ScannerUtils.inputPrice();
		System.out.println("Đây là hãng xe Honda");
		CarCompany nameCompany = CarCompany.Honda;
		System.out.println("Nhập nhiên liệu thiên nhiên mà xe dùng(nhập mã code 4 chữ in hoa và 1 số)");
		String carFuelEnvironmental ="xăng"+ ScannerUtils.inputFuelEnvironmentalName();
		controller.AddNewHonda(name, color, price, nameCompany, carFuelEnvironmental);
	}

	public void AddNewCarMercedes() throws ClassNotFoundException, SQLException {
		System.out.println("nhập tên xe(phải có 4 số đằng sau)");
		String name = "Mercedes"+ScannerUtils.inputIntName();
		System.out.println(" Mời bạn nhập màu");
		CarColor color = getColor();
		System.out.println("Mời bạn nhập giá trị của xe:");
		int price = ScannerUtils.inputPrice();
		System.out.println("Đây là hãng xe Mercedes");
		CarCompany nameCompany = CarCompany.Mercedes;
		System.out.println("Nhập phụ kiện cần có của xe(phải có mã code có 3 số ở đầu và 2 chữ ở cuối)");
		String rareAccessary = "Mercedes"+ScannerUtils.inputCodeFer();
		System.out.println("Nhập kiểu xe(phải có 4 số đằng sau)");
		String carTypeRare = "Mercedes"+ ScannerUtils.inputIntName();
		System.out.println("Nhập nhiên liệu thiên nhiên mà xe dùng(nhập mã code 4 chữ in hoa và 1 số)");
		String carFuelEnvironmental ="dầu"+ ScannerUtils.inputFuelEnvironmentalName();
		controller.AddNewMercedes(name, color, price, nameCompany, carTypeRare, rareAccessary, carFuelEnvironmental);
	}

	public void AddNewCarToyota() throws ClassNotFoundException, SQLException {
		System.out.println("nhập tên xe(phải có 4 số đằng sau)");
		String name = "Toyota"+ScannerUtils.inputIntName();
		System.out.println(" Mời bạn nhập màu");
		CarColor color = getColor();
		System.out.println("Mời bạn nhập giá trị của xe:");
		int price = ScannerUtils.inputPrice();
		System.out.println("Đây là hãng xe Toyota");
		CarCompany nameCompany = CarCompany.Toyota;
		System.out.println("Nhập kiểu xe(phải có 4 số đằng sau)");
		String carTypeRare = "Toyota"+ ScannerUtils.inputIntName();
		System.out.println("Nhập nhiên liệu thiên nhiên mà xe dùng(nhập mã code 4 chữ in hoa và 1 số)");
		String carFuelEnvironmental ="xăng"+ ScannerUtils.inputFuelEnvironmentalName();
		controller.AddNewToyota(name, color, price, nameCompany, carTypeRare, carFuelEnvironmental);
	}

	// --------------------------------------------------UppdateCar--------------------------------------------------------------------------------
	public void UppdateCarFerrari() throws ClassNotFoundException, SQLException {
		System.out.println("Mời nhập id của xe");
		int id = ScannerUtils.inputId();
		System.out.println("nhập tên xe(phải có 4 số đằng sau)");
		String name ="Fer"+ ScannerUtils.inputIntName();
		System.out.println(" Mời bạn nhập màu");
		CarColor color = getColor();
		System.out.println("Mời bạn nhập giá trị của xe(chỉ được nhập 5 số)");
		int price = ScannerUtils.inputPrice();
		System.out.println("Nhập phụ kiện cần có của xe(phải có mã code có 3 số ở đầu và 2 chữ ở cuối)");
		String rareAccessary ="Fer"+ ScannerUtils.inputCodeFer();
		System.out.println("Nhập kiểu xe(phải có mã code 4 chữ số)");
		String carTypeRare = "Fer"+ScannerUtils.inputIntName();
		controller.UppdateNewCarferrari(id, name, color, price, rareAccessary, carTypeRare);
	}
	
	public void UppdateCarFord() throws ClassNotFoundException, SQLException {
		System.out.println("Mời nhập id của xe");
		int id = ScannerUtils.inputId();
		System.out.println("nhập tên xe(phải có 4 số đằng sau)");
		String name ="Ford"+ ScannerUtils.inputIntName();
		System.out.println(" Mời bạn nhập màu");
		CarColor color = getColor();
		System.out.println("Mời bạn nhập giá trị của xe(chỉ được nhập 5 số)");
		int price = ScannerUtils.inputPrice();
		System.out.println("Nhập phụ kiện cần có của xe(phải có mã code có 3 số ở đầu và 2 chữ ở cuối)");
		String rareAccessary ="Ford"+ ScannerUtils.inputCodeFer();
		System.out.println("Nhập nhiên liệu thiên nhiên mà xe dùng(nhập mã code 4 chữ in hoa và 1 số)");
		String carFuelEnvironmental ="dầu"+ ScannerUtils.inputFuelEnvironmentalName();
		controller.UppdateNewFord(id, name, color, price, rareAccessary, carFuelEnvironmental);
	}

	public void UppdateCarHonda() throws ClassNotFoundException, SQLException {
		System.out.println("Mời nhập id của xe");
		int id = ScannerUtils.inputId();
		System.out.println("nhập tên xe(phải có 4 số đằng sau)");
		String name ="Honda"+ScannerUtils.inputIntName();
		System.out.println(" Mời bạn nhập màu");
		CarColor color = getColor();
		System.out.println("Mời bạn nhập giá trị của xe:(chỉ được nhập 5 số)");
		int price = ScannerUtils.inputPrice();
		System.out.println("Nhập nhiên liệu thiên nhiên mà xe dùng(nhập mã code 4 chữ in hoa và 1 số)");
		String carFuelEnvironmental ="xăng"+ ScannerUtils.inputFuelEnvironmentalName();
		controller.UppdateNewHonda(id, name, color, price, carFuelEnvironmental);
	}

	public void UppdateCarMercedes() throws ClassNotFoundException, SQLException {
		System.out.println("Mời nhập id của xe");
		int id = ScannerUtils.inputId();
		System.out.println("nhập tên xe(phải có 4 số đằng sau)");
		String name = "Mercedes"+ScannerUtils.inputIntName();
		System.out.println(" Mời bạn nhập màu");
		CarColor color = getColor();
		System.out.println("Mời bạn nhập giá trị của xe:");
		int price = ScannerUtils.inputPrice();
		System.out.println("Nhập phụ kiện cần có của xe(phải có mã code có 3 số ở đầu và 2 chữ ở cuối)");
		String rareAccessary = "Mercedes"+ScannerUtils.inputCodeFer();
		System.out.println("Nhập kiểu xe(phải có 4 số đằng sau)");
		String carTypeRare = "Mercedes"+ ScannerUtils.inputIntName();
		System.out.println("Nhập nhiên liệu thiên nhiên mà xe dùng(nhập mã code 4 chữ in hoa và 1 số)");
		String carFuelEnvironmental ="dầu"+ ScannerUtils.inputFuelEnvironmentalName();
		controller.UppdateNewMercedes(id, name, color, price, carFuelEnvironmental, rareAccessary, carTypeRare);
	}

	public void UppdateCarToyota() throws ClassNotFoundException, SQLException {
		System.out.println("Mời nhập id của xe");
		int id = ScannerUtils.inputId();
		System.out.println("nhập tên xe(phải có 4 số đằng sau)");
		String name = "Toyota"+ScannerUtils.inputIntName();
		System.out.println(" Mời bạn nhập màu");
		CarColor color = getColor();
		System.out.println("Mời bạn nhập giá trị của xe:");
		int price = ScannerUtils.inputPrice();
		System.out.println("Nhập kiểu xe(phải có 4 số đằng sau)");
		String carTypeRare = "Toyota"+ ScannerUtils.inputIntName();
		System.out.println("Nhập nhiên liệu thiên nhiên mà xe dùng(nhập mã code 4 chữ in hoa và 1 số)");
		String carFuelEnvironmental ="xăng"+ ScannerUtils.inputFuelEnvironmentalName();
		controller.UppdateNewToyota(id, name, color, price, carFuelEnvironmental, carTypeRare);
	}
	
	//----------------------------------------------- xoá xe---------------------------------------------------------------------------------------------
	
	public void deleteCar() throws ClassNotFoundException, SQLException {
		System.out.println("nhập id muốn xoá");
		int id = ScannerUtils.inputId();
		controller.DeleteCar(id);
		System.out.println("bạn đã xoá thành công!");
	}
	
	//------------------------------------------------lấy ra xew đắt nhất----------------------------------------------------------------------------
	public void getExpensiveCar() throws ClassNotFoundException, SQLException {
		List<Car> cars= controller.MostExpensiveCar();
		for (Car car : cars) {
			System.out.println(car);
		}
	}
}
