package UI_2016.summer.InnoBootCamp2016.homework2;

import java.util.ArrayList;

class Reader {
	String name;
	int readingSpeed;
	ArrayList<Book> listOfHoldingBook;
	
	Reader(String name, int readingSpeed, ArrayList<Book> listOfHoldingBook) {
		this.name = name;
		this.readingSpeed = readingSpeed;
		this.listOfHoldingBook = listOfHoldingBook;
	}
}