package hw2;

/*
 * Realisation of the own LinkedList
 */

public class MyLinkedList<T> {
	private int listSize = 0;
	public Node<T> head;
	public Node<T> tail;
	private static int elementsQuantityForTest = 5;

	public static void main (String args[]) {
		MyLinkedList<Integer> MyLinkedList = new MyLinkedList<Integer>();
		
		//filling List
		for (int i = 0; i < elementsQuantityForTest; i++) {
			MyLinkedList.add(i*2);			
		}
		
		//out List
		System.out.println("List:");
		for (int i = 0; i < MyLinkedList.getSize(); i++) {
			System.out.println(MyLinkedList.get(i));
		}
		System.out.println();

		//remove some element
		MyLinkedList.remove(1);
		//check List
		System.out.println("List:");
		for (int i = 0; i < MyLinkedList.getSize(); i++) {
			System.out.println(MyLinkedList.get(i));
		}
	}

	public MyLinkedList() {}
	
	/*
	 * Adding new element to the List tail.
	 */
	public void add(T t) {
        final Node<T> oldTailNode = tail;
        tail = new Node<T>();
        tail.prev = oldTailNode;
        tail.value = t;
        if (oldTailNode == null)
            head = tail;
        else
        	oldTailNode.next = tail;
        listSize++;
	}
	
	/*
	 * Getting element with certain index.
	 */
	public T get(int index) {
		checkListForIndexPresence(index);
    	return findNode(index).value;
	}

	/*
	 * Removing element with certain index.
	 */
	public void remove(int index) {
		checkListForIndexPresence(index);

		Node<T> currentNode = findNode(index);
		Node<T> prevNode = currentNode.prev;
		Node<T> nextNode = currentNode.next;

        if (prevNode == null) {
            head = nextNode;
        } else {
        	prevNode.next = nextNode;
            currentNode.prev = null;
        }

        if (nextNode == null) {
            tail = prevNode;
        } else {
        	nextNode.prev = prevNode;
            currentNode.next = null;
        }
        
        currentNode.value = null;
		listSize--;
	}
	
	/*
	 * Checking for the presence in the List the element with certain index.
	 */
	public void checkListForIndexPresence(int index) {
		if ((index >= listSize) || (index < 0))
    		throw new IndexOutOfBoundsException();
	}
	
	/*
	 * Looking for the element with certain index.
	 */
	Node<T> findNode(int index) {
		Node<T> currentNode = head;
		int counter = 0; //elements counter
		boolean needRepeat = true;

		while (needRepeat) {
			if (counter == index) {
				//we've found the desired element
				needRepeat = false;
			} else {
				currentNode = currentNode.next;
				counter++;
			}
		}
		return currentNode;
	}
	
	/*
	 * Getting List size.
	 */
	private int getSize() {return listSize;}
}