package homework3_refactor;

import java.util.Scanner;

public class MainClass {
	public static ReadersList readers = new ReadersList();
	public static BookList bookList = new BookList();
	private static String surnameIvanov = "Иванов";
	private static String surnamePetrov = "Петров";
	private static String surnameSidorov = "Сидоров";

	public static void main(String[] args) {
		int selectedItem = 0;
		String[] menuItems = new String[5];
		String surname = new String();
		
		Scanner scanner = new Scanner(System.in);
		boolean needRepeat = true;
		
		menuItems[0] = "1.Вывести список книг";
		menuItems[1] = "2.Вывести список читателей";
		menuItems[2] = "3.Вывести список книг конкретного читателя";
		menuItems[3] = "4.Вывести наличие книг и задолженность у конкретного читателя";
		menuItems[4] = "5.Выход";

		addReaders();
		addBooks();

		// Блок добавления книг читателю
		// Иванов
		readers.search(surnameIvanov).bookList.add(bookList.search("Война и Мир"));
        readers.search(surnameIvanov).bookList.add(bookList.search("Мастер и Маргарита"));
		readers.search(surnameIvanov).bookList.add(bookList.search("Мертвые души"));

		// Петров
		readers.search(surnamePetrov).bookList.add(bookList.search("Записки охотника"));
		readers.search(surnamePetrov).bookList.add(bookList.search("Обыкновенная история"));
		readers.search(surnamePetrov).bookList.add(bookList.search("Палата №6"));

		// Сидоров
		readers.search(surnameSidorov).bookList.add(bookList.search("Мцыри"));
		readers.search(surnameSidorov).bookList.add(bookList.search("Преступление и наказание"));
		readers.search(surnameSidorov).bookList.add(bookList.search("Собачье сердце"));
		readers.search(surnameSidorov).bookList.add(bookList.search("Воскресение"));
		//

		while (needRepeat) {
			for (int i = 0; i < menuItems.length; i++) {
				System.out.println(menuItems[i]);
			}

			if (scanner.hasNextInt())
				{selectedItem = scanner.nextInt();}
			else
				{selectedItem = menuItems.length+1;}
			

			switch (selectedItem) {
			case 1:
				bookList.show();
				System.out.println("\n\n");
				break;
			case 2:
				readers.show();
				break;
			case 3:
				System.out.println("Введите фамилию читателя:");
				surname = scanner.next();
				readers.search(surname).bookList.show();
				break;
			case 4:
				System.out.println("Введите фамилию читателя:");
				surname = scanner.next();
				System.out.println("Введите количество дней на чтение книг:");
				int days = scanner.nextInt();
				System.out.println(readers.search(surname).name + " получил следующие книги:");
				Book bl = new Book(); //currentReaderBookList
				bl = readers.search(surname).bookList.first;
				for (int i = 0; i < readers.search(surname).bookList.count; i++) {
					System.out.println(bl.author + " - " + bl.title + " - " + bl.numPages);
					bl = bl.next;
				}
				System.out.println(
						"После прочтения у " + readers.search(surname).name + "а" + " будет задолженность в размере:");
				System.out.println(readers.search(surname).calculate(days) + " рублей\n");
				break;
			case 5:
				needRepeat = false;
				break;
			default:
				System.out.println("Введите корректное значение");
				break;
			}
		}
		scanner.close();
	}

	/*
	 * Add books on bookshelfs
	 */
	private static void addBooks() {
		bookList.add("Война и Мир", "Толстой Л.Н.", 1868, 15, 300);
		bookList.add("Мастер и Маргарита", "Михаил Булгаков", 1940, 15, 450);
		bookList.add("Мертвые души", "Николай Гоголь", 1842, 15, 140);
		bookList.add("Записки охотника", "Иван Тургенев", 1852, 15, 1400);
		bookList.add("Обыкновенная история", "Иван Гончаров", 1847, 15, 67);
		bookList.add("Палата №6", "Антон Чехов", 1892, 15, 450);
		bookList.add("Мцыри", "Михаил Лермонтов", 1840, 15, 146);
		bookList.add("Преступление и наказание", "Федор Достоевский", 1866, 15, 450);
		bookList.add("Собачье сердце", "Михаил Булгаков", 1925, 15, 740);
		bookList.add("Воскресение", "Лев Толстой", 1899, 15, 450);
	}

	/*
	 * Add readers
	 */
	private static void addReaders() {
		int defaultSpeedOfReading = 120;

		readers.add(surnameIvanov, defaultSpeedOfReading);
		readers.add(surnamePetrov, defaultSpeedOfReading);
		readers.add(surnameSidorov, defaultSpeedOfReading);
	}
}