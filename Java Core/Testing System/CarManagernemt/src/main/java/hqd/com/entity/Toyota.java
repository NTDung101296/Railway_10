package hqd.com.entity;

public class Toyota extends Car {
	private String carFuelEnvironmental; // carFuelEnvironmental: nguyên liệu thiên nhiên
	private String carTypeRare; // carTypeRare: kiểu xe hiếm

	public String getCarFuelEnvironmental() {
		return carFuelEnvironmental;
	}

	public void setCarFuelEnvironmental(String carFuelEnvironmental) {
		this.carFuelEnvironmental = carFuelEnvironmental;
	}

	public String getCarTypeRare() {
		return carTypeRare;
	}

	public void setCarTypeRare(String carTypeRare) {
		this.carTypeRare = carTypeRare;
	}

	@Override
	public String toString() {
		return "Toyota [carFuelEnvironmental=" + carFuelEnvironmental + ", CarTypeRare=" + carTypeRare + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getColor()=" + getColor() + ", getPrice()=" + getPrice()
				+ "]";
	}

}
