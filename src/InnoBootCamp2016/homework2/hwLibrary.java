package hw2;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * It is solution without strategy for reader to minimize the debt.
 */

public class hwLibrary {
	public static void main(String args[]) {
		String helloMessage = "Program estimates library overdue fines.";
		String queryNumberOfDays = "Enter number of days to due date (recommended for test=7): ";
		String stringRead = "read";
		String stringHolds = "holds";
		String templateLineBreak = "\n";
		
		String templateReaderHasRead = "Reader %s has read %s book(s) and holds %s book(s):";
		String templateBookCommon = "(%s) %s - %s - ";
		String templateBookWithPages = templateBookCommon + "number of pages: %s";
		String templateBookWithOverdue = templateBookCommon + "overdue fine: %s$";
		String templateTotalOverdueFine = "Total overdue fine: %s$";

		int numberOfDays = 0;
		
		ArrayList<Reader> listReader = new ArrayList<Reader>();
		ArrayList<Book> listBook = new ArrayList<Book>();
		ArrayList<Book> listOfHoldingBook = new ArrayList<Book>(); //список вз€тых книг у каждого читател€
		Scanner scanner = new Scanner(System.in);

		listBook.add(new Book("White Fang", "Jack London", 1906, 200, 3));
		listBook.add(new Book("GulliverТs Travels", "Jonathan Swift", 1726, 100, 5));
		listBook.add(new Book("The Door", "Magda Szabo", 1987, 250, 6));
		listBook.add(new Book("Robinson Crusoe", "Daniel Defoe", 1719, 160, 4));
		listBook.add(new Book("Candide", "Voltaire", 1759, 100, 2));
		listBook.add(new Book("Three Men in a Boat", "Jerome Klapka Jerome", 1889, 500, 7));
		listBook.add(new Book("To Say Nothing of the Dog", "Connie Willis", 1997, 350, 6));
		listBook.add(new Book("My Family and Other Animals", "Gerald Malcolm Durrell", 1956, 220, 3));
		listBook.add(new Book("White Bim Black Ear", "Gavriil Troyepolsky", 1971, 180, 4));
		listBook.add(new Book("Kashtanka", "Anton Chekhov", 1887, 290, 6));
		
		//distribution books between readers:
		listOfHoldingBook.add(listBook.get(0));
		listOfHoldingBook.add(listBook.get(1));
		listOfHoldingBook.add(listBook.get(2));
		listOfHoldingBook.add(listBook.get(3));
		listReader.add(new Reader("Ann", 110, listOfHoldingBook));

		listOfHoldingBook = new ArrayList<Book>();
		listOfHoldingBook.add(listBook.get(4));
		listOfHoldingBook.add(listBook.get(5));
		listOfHoldingBook.add(listBook.get(6));
		listReader.add(new Reader("Mike", 120, listOfHoldingBook));

		listOfHoldingBook = new ArrayList<Book>();
		listOfHoldingBook.add(listBook.get(7));
		listOfHoldingBook.add(listBook.get(8));
		listOfHoldingBook.add(listBook.get(9));
		listReader.add(new Reader("Alex", 80, listOfHoldingBook));
		
		
		System.out.println(helloMessage);
		System.out.print(queryNumberOfDays);
		if (scanner.hasNextInt())
			numberOfDays = scanner.nextInt();
		scanner.close();
		
		for (Reader reader : listReader) {
			System.out.println();
			int restNumberOfPages = reader.readingSpeed * numberOfDays;
			int quantityOfReadBooks = 0;
			int quantityOfHoldBooks = 0;
			int totalOverdueFine = 0;
			
			String stringReaderHasRead;
			String stringBooksAndResults = "";

			for (Book book : reader.listOfHoldingBook) {
				restNumberOfPages = restNumberOfPages - book.numberPages;
				if (restNumberOfPages >= 0) {
					quantityOfReadBooks++;

					stringBooksAndResults = stringBooksAndResults + templateLineBreak
							+ String.format(templateBookWithPages, stringRead, book.title, book.author, book.numberPages);
				} else {
					totalOverdueFine = totalOverdueFine + book.overdueFine;
					quantityOfHoldBooks++;
					
					stringBooksAndResults = stringBooksAndResults + templateLineBreak
							+ String.format(templateBookWithOverdue, stringHolds, book.title, book.author, book.overdueFine);
				}
			}

			stringReaderHasRead = String.format(templateReaderHasRead, reader.name, quantityOfReadBooks, quantityOfHoldBooks);
			System.out.println(stringReaderHasRead + stringBooksAndResults
					+ templateLineBreak + String.format(templateTotalOverdueFine, totalOverdueFine));
		}
	}
	
	public static class Reader {
		String name;
		int readingSpeed;
		ArrayList<Book> listOfHoldingBook;
		
		public Reader(String name, int readingSpeed, ArrayList<Book> listOfHoldingBook) {
			this.name = name;
			this.readingSpeed = readingSpeed;
			this.listOfHoldingBook = listOfHoldingBook;
		}
	}
	
	public static class Book {
		String title;
		String author;
		int year;
		int numberPages;
		int overdueFine;
		
		public Book(String title, String author, int year, int numberPages, int overdueFine) {
			this.title = title;
			this.author = author;
			this.year = year;
			this.numberPages = numberPages;
			this.overdueFine = overdueFine;
		}
	}
}