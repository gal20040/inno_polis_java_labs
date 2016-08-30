package InnoBootCamp2016.homework2;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * It is solution WITH strategy for reader to minimize the debt.
 * My optimal strategy is to read first of all books with the highest attitude overdue fine to number of pages.
 *
 * What else can be done (but i have no time now...pity): if the reader has some book with a very large number of pages, than its need new check:
 * whether the reader can read this book at all in available time? It may be that the reader will read 0 books.
 * That kind of books needs to be filtrated.
 */

public class hwLibraryWithOptimisation {
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

		ArrayList<Reader> listReader = new ArrayList<>();
		ArrayList<Book> listBook = new ArrayList<>();
		ArrayList<Book> listOfHoldingBook = new ArrayList<>(); //список взятых книг у каждого читателя
		Scanner scanner = new Scanner(System.in);

		System.out.println(helloMessage);
		System.out.print(queryNumberOfDays);
		if (scanner.hasNextInt())
			numberOfDays = scanner.nextInt();
		scanner.close();

		listBook.add(new Book("White Fang", "Jack London", 1906, 200, 3));
		listBook.add(new Book("Gulliver’s Travels", "Jonathan Swift", 1726, 100, 5));
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
		rearrangeBooks(listOfHoldingBook);
		listReader.add(new Reader("Ann", 110, listOfHoldingBook));

		listOfHoldingBook = new ArrayList<>();
		listOfHoldingBook.add(listBook.get(4));
		listOfHoldingBook.add(listBook.get(5));
		listOfHoldingBook.add(listBook.get(6));
		rearrangeBooks(listOfHoldingBook);
		listReader.add(new Reader("Mike", 120, listOfHoldingBook));

		listOfHoldingBook = new ArrayList<>();
		listOfHoldingBook.add(listBook.get(7));
		listOfHoldingBook.add(listBook.get(8));
		listOfHoldingBook.add(listBook.get(9));
		rearrangeBooks(listOfHoldingBook);
		listReader.add(new Reader("Alex", 80, listOfHoldingBook));

		//пробежимся по всем читателям, для проверки прочитанных книг
		for (Reader reader : listReader) {
			System.out.println();
			int restNumberOfPages = reader.readingSpeed * numberOfDays;
			int quantityOfReadBooks = 0;
			int quantityOfHoldBooks = 0;
			int totalOverdueFine = 0;

			String stringReaderHasRead;
			String stringBooksAndResults = "";

			//пробежимся по всем книгам отдельно взятого читателя
			for (Book book : reader.listOfHoldingBook) {
				restNumberOfPages = restNumberOfPages - book.numberPages; //остаток страниц у данного читателя
				if (restNumberOfPages >= 0) {
					//читатель не выбился за отведённое ему время, значит данную книгу он всё-таки прочёл
					quantityOfReadBooks++;
					book.status = true;

					//добавляем инфу по данной книге в список вывода
					stringBooksAndResults = stringBooksAndResults + templateLineBreak
							+ String.format(templateBookWithPages, stringRead, book.title, book.author, book.numberPages);
				} else {
					totalOverdueFine = totalOverdueFine + book.overdueFine; //общая сумма штрафа у читателя
					quantityOfHoldBooks++;

					//добавляем инфу по данной книге в список вывода
					stringBooksAndResults = stringBooksAndResults + templateLineBreak
							+ String.format(templateBookWithOverdue, stringHolds, book.title, book.author, book.overdueFine);
				}
//				stringBooksAndResults = stringBooksAndResults + "; book.value = " + book.value;
			}

			stringReaderHasRead = String.format(templateReaderHasRead, reader.name, quantityOfReadBooks, quantityOfHoldBooks);
			System.out.println(stringReaderHasRead + stringBooksAndResults
					+ templateLineBreak + String.format(templateTotalOverdueFine, totalOverdueFine));
		}
	}

	private static void rearrangeBooks(ArrayList<Book> listOfHoldingBook) {
		//массив на 1 книгу не трогаем
		if (listOfHoldingBook.size() > 1) {
			boolean needRepeat = true;
			while (needRepeat) {
				needRepeat = false;
				Book tempBook;
				for (int i = 0; i < listOfHoldingBook.size() - 1; i++) {
					if (listOfHoldingBook.get(i).value < listOfHoldingBook.get(i + 1).value) {
						tempBook = listOfHoldingBook.get(i);
						listOfHoldingBook.remove(i);
						listOfHoldingBook.add(i, listOfHoldingBook.get(i));
						listOfHoldingBook.remove(i + 1);
						listOfHoldingBook.add(i + 1, tempBook);
						needRepeat = true; //нужен ещё повтор
					}
				}
			}
		}
	}
}