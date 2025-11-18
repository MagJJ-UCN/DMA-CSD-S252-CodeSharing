package model;

import java.util.ArrayList;

public class Book {
	private String title;
	private String author;
	private ArrayList<BookCopy> copies;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		copies = new ArrayList<>();
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	
	public ArrayList<BookCopy> getCopies(){
		return new ArrayList<BookCopy>(copies);
	}
	
	public void addBookCopy(int bookNumber) {
		copies.add(new BookCopy(bookNumber));
	}

	public String getAuthor() {
		return author;
	}

}
