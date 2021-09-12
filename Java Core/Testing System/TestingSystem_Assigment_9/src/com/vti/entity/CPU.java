package com.vti.entity;

public class CPU {
	private float price;

	@Override
	public String toString() {
		return "CPU [price=" + price + "]";
	}

	public CPU(float price) {
		super();
		this.price = price;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public class Processor {
		private int coreAmount;
		private String menufacturer;

		public int getCoreAmount() {
			return coreAmount;
		}

		public void setCoreAmount(int coreAmount) {
			this.coreAmount = coreAmount;
		}

		public String getMenufacturer() {
			return menufacturer;
		}

		public void setMenufacturer(String menufacturer) {
			this.menufacturer = menufacturer;
		}

		public Processor(int coreAmount, String menufacturer) {
			super();
			this.coreAmount = coreAmount;
			this.menufacturer = menufacturer;
		}

		public Processor() {
			
		}

		@Override
		public String toString() {
			return "Processor [coreAmount=" + coreAmount + ", menufacturer=" + menufacturer + "]";
		}

		public float getCache() {
			return 4.3f;
		}

	}

	public class Ram {
		private int memory;
		private String menufacturer;

		public int getMemory() {
			return memory;
		}

		public void setMemory(int memory) {
			this.memory = memory;
		}

		public String getMenufacturer() {
			return menufacturer;
		}

		public void setMenufacturer(String menufacturer) {
			this.menufacturer = menufacturer;
		}

		@Override
		public String toString() {
			return "Ram [memory=" + memory + ", menufacturer=" + menufacturer + "]";
		}

		public Ram() {
			
		}

		public Ram(int memory, String menufacturer) {
			super();
			this.memory = memory;
			this.menufacturer = menufacturer;
		}

		public float getClockSpeed() {
			return 5.5f;
		}
	}

}
