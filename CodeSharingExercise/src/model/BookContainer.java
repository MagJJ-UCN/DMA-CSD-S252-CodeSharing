package model;

import java.util.ArrayList;

public class BookContainer {
	private ArrayList<Book> books;
	private static BookContainer instance;
	
	private BookContainer() {
		books = new ArrayList<>();
	}

	public static BookContainer getInstance() {
		if(instance == null) {
			instance = new BookContainer();
		}
		return instance;
	}

	public void addBook(Book book) {
		books.add(book);
	}
	
	public Book findBookBytitle(String title) {
		Book res = null;
		for (Book book : books) {
			if(book.getTitle().equals(title)) {
				res = book;
				break;
			}
		}
		return res;
	}
	
	public ArrayList<Book> getBooks(){
		return new ArrayList<Book>(books);
	}
}
