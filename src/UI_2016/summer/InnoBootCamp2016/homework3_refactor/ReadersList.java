package UI_2016.summer.InnoBootCamp2016.homework3_refactor;

class ReadersList {

	private Reader first = new Reader();
	private int count = 0;

	void add(String aName, int speed) {
		Reader current;
		if (count == 0)
			current = first;
		else {
			current = new Reader();
			if (first.next != null) {
				current.next = first.next;
				first.next.prev = current;
			}
			current.prev = first;
			first.next = current;
		}
		current.name = aName;
		current.speedOfReading = speed;
		count++;
	}

	void delete(String aName) {
		Reader temp = search(aName);
		if (temp != null) {
			temp.prev.next = temp.next;
			temp.prev = null;
			temp.next = null;
		}
	}

	Reader search(String aName) {
		Reader temp = first;
		if (count == 1)
			return temp;
		while (temp != null) {
			if (temp.name.equals(aName))
				return temp;

			temp = temp.next;
		}
		return null;
	}

	void show() {
		Reader temp = first;
		while (temp != null) {
			System.out.println(temp.name);
			temp = temp.next;
		}
	}
}