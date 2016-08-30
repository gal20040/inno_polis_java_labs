package hw2;

import java.util.ArrayList;

public class Reader {
	String name;
	int readingSpeed;
	ArrayList<Book> listOfHoldingBook;
	
	public Reader(String name, int readingSpeed, ArrayList<Book> listOfHoldingBook) {
		this.name = name;
		this.readingSpeed = readingSpeed;
		this.listOfHoldingBook = listOfHoldingBook;
	}
}