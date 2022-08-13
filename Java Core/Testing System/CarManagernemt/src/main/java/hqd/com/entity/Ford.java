package hqd.com.entity;

public class Ford extends Car {
	private String carFuelEnvironmental;// carFuelEnvironmental: nguyên liệu thiên nhiên
	private String rareAccessary;// rareAccessary: phụ kiện hiếm

	public Ford() {

	}

	public Ford(String carFuelEnvironmental, String rareAccessary) {
		super();
		this.carFuelEnvironmental = carFuelEnvironmental;
		this.rareAccessary = rareAccessary;
	}

	public String getCarFuelEnvironmental() {
		return carFuelEnvironmental;
	}

	public void setCarFuelEnvironmental(String carFuelEnvironmental) {
		this.carFuelEnvironmental = carFuelEnvironmental;
	}

	public String getRareAccessary() {
		return rareAccessary;
	}

	public void setRareAccessary(String rareAccessary) {
		this.rareAccessary = rareAccessary;
	}

	@Override
	public String toString() {
		return "Ford [carFuelEnvironmental=" + carFuelEnvironmental + ", rareAccessary=" + rareAccessary + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getColor()=" + getColor() + ", getPrice()=" + getPrice()
				+ "]";
	}

}
