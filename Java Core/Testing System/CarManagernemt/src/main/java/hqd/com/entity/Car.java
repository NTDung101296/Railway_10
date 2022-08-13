package hqd.com.entity;

public class Car {
	private int id;
	private String name;
	private CarColor color;
	private int price;
	private CarCompany carCompany;

	// carFuelEnvironmental: nguyên liệu thiên nhiên
	// rareAccessary: phụ kiện hiếm 
	// carTypeRare: kiểu xe hiếm

	
	public CarCompany getCarCompany() {
		return carCompany;
	}

	public void setCarCompany(CarCompany carCompany) {
		this.carCompany = carCompany;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CarColor getColor() {
		return color;
	}

	public void setColor(CarColor color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
	public Car() {
		
	}

	
public Car(int id, String name, CarColor color, int price,CarCompany carCompany) {
		
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.carCompany= carCompany;
	}

@Override
public String toString() {
	return "Car [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + ", carCompany=" + carCompany
			+ "]";
}
	

	
	
	

}
