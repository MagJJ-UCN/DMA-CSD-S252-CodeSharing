package controller;

import model.*;

public class BookController {
	private BookContainer bookCon;
	
	public BookController() {
		bookCon = BookContainer.getInstance();
	}

	public Book createBook(String title, String author) {
		Book res = null;
		if(bookCon.findBookBytitle(title) == null) {
			if(!title.equals("") || !author.equals("")) {
				res = new Book(title, author);
				bookCon.addBook(res);
			}
		}
		return res;
	}

	public BookCopy createBookCopy(String title, int bookNumber) {
		BookCopy res = null;
		Book b = bookCon.findBookBytitle(title);
		for (int i = 0; i < bookCon.getBooks().size() && b != null; i++) {
			for (int j = 0; j < bookCon.getBooks().get(i).getCopies().size() && b != null; j++) {
				if(bookCon.getBooks().get(i).getCopies().get(j).getCopyNumber() == bookNumber) {
					b = null;
				}
			}
		}
		/*
		 * BEDRE ;)
		for (Book book : bookCon.getBooks()) {
			for (BookCopy bookCopy : book.getCopies()) {
			}
		}
		*/
		
		if(b != null) {
			res = new BookCopy(bookNumber);
			b.addBookCopy(bookNumber);
		}
		return res;
	}
}
