package InnoBootCamp2016.homework3_refactor;

class Book {
	String title;
	String author;
	int numPages;
	int year;
	int overdueFine;
	Book next;
	Book prev;

	Book() {
		next = null;
		prev = null;
	}
}