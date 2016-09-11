package UI_2016.summer.InnoBootCamp2016.homework3_refactor;

class BookList {

	Book first = new Book();
	private Book last = new Book();
	int count = 0;

	void add(Book aBook) {
		Book current;
		if (count == 0) {
			current = first;
			last = first;
		} else {
			current = new Book();
			last.next = current;
			current.prev = last;
			last = current;
		}
		current.title = aBook.title;
		current.author = aBook.author;
		current.numPages = aBook.numPages;
		current.year = aBook.year;
		current.overdueFine = aBook.overdueFine;

		count++;
	}

	void add(String aTitle, String anAuthor, int aYear, int anOverdue, int aNumP) {
		Book current;
		if (count == 0) {
			current = first;
			last = first;
		}
		else {
			current = new Book();
			last.next = current;
			current.prev = last;
			last = current;
		}

		current.title = aTitle;
		current.author = anAuthor;
		current.year = aYear;
		current.overdueFine = anOverdue;
		current.numPages = aNumP;
		count++;
	}

	void delete(String aTitle) {
		Book temp = search(aTitle);
		if (temp != null) {
			temp.prev.next = temp.next;
			temp.prev = null;
			temp.next = null;
		}
		count--;
	}

	Book search(String aTitle) {
		Book temp = first;
		if (count == 1)
			return temp;
		while (temp != null) {
			if (temp.title == aTitle) //здесь идёт сравнение строчных переменных, но почему-то через равенство, а не через equals()
				return temp;				

			temp = temp.next;
		}
		return null;
	}

	void show() {
		Book temp = first;
		while (temp != null) {
			System.out.print(temp.title + " , ");
			System.out.println(temp.author);
			temp = temp.next;
		}
	}
}