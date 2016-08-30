package homework3_refactor;

public class Book {
	String title = new String();
	String author = new String();
	int numPages;
	int year;
	int overdueFine;
	Book next;
	Book prev;

	public Book() {
		next = null;
		prev = null;
	}
}
