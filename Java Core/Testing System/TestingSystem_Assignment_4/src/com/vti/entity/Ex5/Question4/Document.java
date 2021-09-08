package com.vti.entity.Ex5.Question4;

public class Document {
	private int id;
	private String publisher;
	private int numRelease;

	public Document(int id, String publisher, int numRelease) {
		this.id = id;
		this.publisher = publisher;
		this.numRelease = numRelease;
	}

	public String toString() {
		return "\n Id= " + id + "\n Publisher= " + publisher + "\n Number Release= " + numRelease;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getNumRelease() {
		return numRelease;
	}

	public void setNumRelease(int numRelease) {
		this.numRelease = numRelease;
	}

}
