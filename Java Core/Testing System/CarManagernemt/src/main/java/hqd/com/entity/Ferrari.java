package hqd.com.entity;

public class Ferrari extends Car {
	private String rareAccessary;// rareAccessary: phụ kiện hiếm
	private String CarTypeRare;// carTypeRare: kiểu xe hiếm

	public Ferrari(String rareAccessary, String carTypeRare) {
		super();
		this.rareAccessary = rareAccessary;
		CarTypeRare = carTypeRare;
	}

	public String getRareAccessary() {
		return rareAccessary;
	}

	public void setRareAccessary(String rareAccessary) {
		this.rareAccessary = rareAccessary;
	}

	public String getCarTypeRare() {
		return CarTypeRare;
	}

	public void setCarTypeRare(String carTypeRare) {
		CarTypeRare = carTypeRare;
	}

	@Override
	public String toString() {
		return "Ferrari [rareAccessary=" + rareAccessary + ", CarTypeRare=" + CarTypeRare + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getColor()=" + getColor() + ", getPrice()=" + getPrice() + "]";
	}

}
