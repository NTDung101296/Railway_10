package com.vti.entity.Ex5.Question4;

public class Book extends Document{
	private String author;
	private int numPage;
	
	public Book (int id, String publisher, int numRelease, String author, int numPage) {
		super(id, publisher, numRelease);
		this.author = author;
		this.numPage = numPage;
	}
	
	public String toString() {
		return "\n Book: " + super.toString() + "\n Author= " + author + "\n Number Page= " + numPage; 
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getNumPage() {
		return numPage;
	}
	public void setNumPage(int numPage) {
		this.numPage = numPage;
	}
	
	

}
