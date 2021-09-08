package com.vti.entity.Ex1;

public class Block {
	private String name;
	private String subject;
	
	public Block (String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		switch (this.name) {
		case "A":
			this.subject = "Toan, Ly, Hoa";
			break;
		case "B":
			this.subject = "Toan, Hoa, Sinh";
			break;
		case "C":
			this.subject = "Van, Su, Dia";
			break;
		}
		return this.subject;
	}

}
