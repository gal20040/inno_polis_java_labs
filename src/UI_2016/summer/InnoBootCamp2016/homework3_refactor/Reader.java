package UI_2016.summer.InnoBootCamp2016.homework3_refactor;

class Reader {
	String name;
	int speedOfReading;
	Reader next;
	Reader prev;
	BookList bookList = new BookList();

	Reader() {
		next = null;
		prev = null;
	}

	float calculate(int aDays) {
		int sheets = aDays * speedOfReading;
		boolean indicator = false;
		int tMP;
		float peni = 0;
		Book temp;
		float backCheck = 0;
		
		temp = bookList.first;
		tMP = sheets;
		while (temp != null) {
			if (indicator) {
				peni += (float) (temp.numPages) / speedOfReading * temp.overdueFine;
				peni += backCheck / speedOfReading * temp.overdueFine;
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