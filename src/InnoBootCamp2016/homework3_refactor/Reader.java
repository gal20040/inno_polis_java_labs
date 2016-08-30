package homework3_refactor;

public class Reader {
	String name = new String();
	int speedOfReading;
	Reader next;
	Reader prev;
	BookList bookList = new BookList();

	public Reader() {
		next = null;
		prev = null;
	}

	public float calculate(int aDays) {
		int sheets = aDays * speedOfReading;
		boolean indicator = false;
		int tMP = 0;
		float peni = 0;
		Book temp = new Book();
		float backCheck = 0;
		
		temp = bookList.first;
		tMP = sheets;
		while (temp != null) {
			if (indicator == true) {
				peni += (float) (temp.numPages) / speedOfReading * temp.overdueFine;
				peni += (float) (backCheck) / speedOfReading * temp.overdueFine;
				backCheck += temp.numPages;
			} else {
				tMP = tMP - temp.numPages;
				if (tMP < 0) {
					indicator = true;
					tMP = -tMP;
					backCheck += tMP;
					peni += (float) (tMP) / speedOfReading * temp.overdueFine;
				}
			}
			temp = temp.next;
		}
		return peni;
	}
}