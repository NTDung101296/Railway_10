package hqd.com.entity;

public class Mercedes extends Car {
	private String rareAccessary; // rareAccessary: phụ kiện hiếm
	private String carTypeRare; // carTypeRare: kiểu xe hiếm
	private String carFuelEnvironmental; // carFuelEnvironmental: nguyên liệu thiên nhiên

	public String getRareAccessary() {
		return rareAccessary;
	}

	public void setRareAccessary(String rareAccessary) {
		this.rareAccessary = rareAccessary;
	}

	public String getcarTypeRare() {
		return carTypeRare;
	}

	public void setcarTypeRare(String carTypeRare) {
		this.carTypeRare = carTypeRare;
	}

	public String getCarFuelEnvironmental() {
		return carFuelEnvironmental;
	}

	public void setCarFuelEnvironmental(String carFuelEnvironmental) {
		this.carFuelEnvironmental = carFuelEnvironmental;
	}

	@Override
	public String toString() {
		return "Mercedes [rareAccessary=" + rareAccessary + ", CarTypeRare=" + carTypeRare + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getColor()=" + getColor() + ", getPrice()=" + getPrice() + "]";
	}

}
