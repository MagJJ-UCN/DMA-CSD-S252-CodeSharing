package tui;

import java.util.Scanner;

import controller.BookController;
import model.*;

/**
 * Book menu
 * @author Anita Lykke Clemmensen
 * @version 0.1
 */

public class BookMenu {
    //Instance variables
	private final int CREATE_BOOK = 1;
	private final int CREATE_BOOKCOPY = 2;
	private BookController bookCtrl;
    
	public BookMenu() {
        bookCtrl = new BookController();
	}

    public void start() {
        bookMenu();
    }

    private void bookMenu() {
        boolean running = true;
        while (running) {
            int choice = writeBookMenu();
            switch (choice) {
                case CREATE_BOOK:
                	createBook();
                	break;
                case CREATE_BOOKCOPY:
                	createBookCopy();
                    break;
                case 0:
                  running = false;
                  break;
                default:
                  System.out.println("En uforklarlig fejl er sket med choice = " + choice);
                  break;
            }
        }
    }

    private void createBook() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is the title of the book?: ");
        String title = keyboard.nextLine();
        System.out.println("Who is the author of the book?: ");
        String author = keyboard.nextLine();
        Book b = bookCtrl.createBook(title, author);
        while(b == null) {
        	System.out.println("Something went wrong - Probably duplicate title");
        	System.out.println("What is the title of the book?: ");
        	title = keyboard.nextLine();
        	b = bookCtrl.createBook(title, author);
        }
        System.out.println("Book has been created");
        writeBook(b);
    }

    private void createBookCopy() {
    	Scanner keyboard = new Scanner(System.in);
    	System.out.println("What is the title of the book?: ");
    	String title = keyboard.nextLine();
    	System.out.println("What is the copy number?: ");
    	int copyNumber = getIntegerFromUser(keyboard);
    	BookCopy bCopy = bookCtrl.createBookCopy(title, copyNumber);
    	while(bCopy == null) {
    		System.out.println("\nTitle could not be found");
    		System.out.println("What is the title of the book?: ");
    		title = keyboard.nextLine();
    		bCopy = bookCtrl.createBookCopy(title, copyNumber);
    	}
    	System.out.println("Book has been created");
    	writeBookCopy(title, bCopy);
    }

    private void writeBook(Book book) {
    	System.out.println(book.getTitle() + " - " + book.getAuthor());
    }

    private void writeBookCopy(String title, BookCopy bookCopy) {
    	System.out.println(bookCopy.getCopyNumber() + " - " + title);
    }

    private int writeBookMenu() {
    	Scanner keyboard = new Scanner(System.in);
    	System.out.println("****** Bog menu ******");
    	System.out.println(" (1) Opret bog");
    	System.out.println(" (2) Opret bogkopi");
    	System.out.println(" (0) Tilbage");
    	System.out.print("\n Vælg:");
    	int choice = getIntegerFromUser(keyboard);
    	return choice;
    }

    private int getIntegerFromUser(Scanner keyboard) {
    	while (!keyboard.hasNextInt()) {
    		System.out.println("Input skal være et tal - prøv igen");
    		keyboard.nextLine();
    	}
    	int res = keyboard.nextInt();
    	keyboard.nextLine();
    	return res;
    }

}
