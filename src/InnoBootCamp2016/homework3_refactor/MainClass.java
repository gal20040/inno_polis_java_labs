package homework3_refactor;

import java.util.Scanner;

public class MainClass {
	public static ReadersList readers = new ReadersList();
	public static BookList bookList = new BookList();
	private static String surnameIvanov = "������";
	private static String surnamePetrov = "������";
	private static String surnameSidorov = "�������";

	public static void main(String[] args) {
		int selectedItem = 0;
		String[] menuItems = new String[5];
		String surname = new String();
		
		Scanner scanner = new Scanner(System.in);
		boolean needRepeat = true;
		
		menuItems[0] = "1.������� ������ ����";
		menuItems[1] = "2.������� ������ ���������";
		menuItems[2] = "3.������� ������ ���� ����������� ��������";
		menuItems[3] = "4.������� ������� ���� � ������������� � ����������� ��������";
		menuItems[4] = "5.�����";

		addReaders();
		addBooks();

		// ���� ���������� ���� ��������
		// ������
		readers.search(surnameIvanov).bookList.add(bookList.search("����� � ���"));
        readers.search(surnameIvanov).bookList.add(bookList.search("������ � ���������"));
		readers.search(surnameIvanov).bookList.add(bookList.search("������� ����"));

		// ������
		readers.search(surnamePetrov).bookList.add(bookList.search("������� ��������"));
		readers.search(surnamePetrov).bookList.add(bookList.search("������������ �������"));
		readers.search(surnamePetrov).bookList.add(bookList.search("������ �6"));

		// �������
		readers.search(surnameSidorov).bookList.add(bookList.search("�����"));
		readers.search(surnameSidorov).bookList.add(bookList.search("������������ � ���������"));
		readers.search(surnameSidorov).bookList.add(bookList.search("������� ������"));
		readers.search(surnameSidorov).bookList.add(bookList.search("�����������"));
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
				System.out.println("������� ������� ��������:");
				surname = scanner.next();
				readers.search(surname).bookList.show();
				break;
			case 4:
				System.out.println("������� ������� ��������:");
				surname = scanner.next();
				System.out.println("������� ���������� ���� �� ������ ����:");
				int days = scanner.nextInt();
				System.out.println(readers.search(surname).name + " ������� ��������� �����:");
				Book bl = new Book(); //currentReaderBookList
				bl = readers.search(surname).bookList.first;
				for (int i = 0; i < readers.search(surname).bookList.count; i++) {
					System.out.println(bl.author + " - " + bl.title + " - " + bl.numPages);
					bl = bl.next;
				}
				System.out.println(
						"����� ��������� � " + readers.search(surname).name + "�" + " ����� ������������� � �������:");
				System.out.println(readers.search(surname).calculate(days) + " ������\n");
				break;
			case 5:
				needRepeat = false;
				break;
			default:
				System.out.println("������� ���������� ��������");
				break;
			}
		}
		scanner.close();
	}

	/*
	 * Add books on bookshelfs
	 */
	private static void addBooks() {
		bookList.add("����� � ���", "������� �.�.", 1868, 15, 300);
		bookList.add("������ � ���������", "������ ��������", 1940, 15, 450);
		bookList.add("������� ����", "������� ������", 1842, 15, 140);
		bookList.add("������� ��������", "���� ��������", 1852, 15, 1400);
		bookList.add("������������ �������", "���� ��������", 1847, 15, 67);
		bookList.add("������ �6", "����� �����", 1892, 15, 450);
		bookList.add("�����", "������ ���������", 1840, 15, 146);
		bookList.add("������������ � ���������", "����� �����������", 1866, 15, 450);
		bookList.add("������� ������", "������ ��������", 1925, 15, 740);
		bookList.add("�����������", "��� �������", 1899, 15, 450);
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