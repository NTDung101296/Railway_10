package hqd.com.entity;

public class Honda extends Car {
	private String carFuelEnvironmental;// carFuelEnvironmental: nguyên liệu thiên nhiên

	public String getCarFuelEnvironmental() {
		return carFuelEnvironmental;
	}

	public void setCarFuelEnvironmental(String carFuelEnvironmental) {
		this.carFuelEnvironmental = carFuelEnvironmental;
	}

	@Override
	public String toString() {
		return "Honda [carFuelEnvironmental=" + carFuelEnvironmental + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getColor()=" + getColor() + ", getPrice()=" + getPrice() + "]";
	}

}
