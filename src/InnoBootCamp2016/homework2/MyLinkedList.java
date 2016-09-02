//package InnoBootCamp2016.homework2;
//
///*
// * Realisation of the own LinkedList
// */
//
//class MyLinkedList<T> {
//	private int listSize = 0;
//	private Node<T> head;
//	private Node<T> tail;
//
//	public static void main (String args[]) {
//		MyLinkedList<Integer> MyLinkedList = new MyLinkedList<>();
//		int elementsQuantityForTest = 5;
//
//		//filling List
//		for (int i = 0; i < elementsQuantityForTest; i++) {
//			MyLinkedList.add(i*2);
//		}
//
//		//out List
//		System.out.println("List:");
//		for (int i = 0; i < MyLinkedList.getSize(); i++) {
//			System.out.println(MyLinkedList.get(i));
//		}
//		System.out.println();
//
//		//remove some element
//		MyLinkedList.remove(1);
//		//check List
//		System.out.println("List:");
//		for (int i = 0; i < MyLinkedList.getSize(); i++) {
//			System.out.println(MyLinkedList.get(i));
//		}
//	}
//
//	private MyLinkedList() {}
//
//	/*
//	 * Adding new element to the List tail.
//	 */
//	public void add(T t) {
//        final Node<T> oldTailNode = tail;
//        tail = new Node<>();
//        tail.prev = oldTailNode;
//        tail.value = t;
//        if (oldTailNode == null)
//            head = tail;
//        else
//        	oldTailNode.next = tail;
//        listSize++;
//	}
//
//	/*
//	 * Getting element with certain index.
//	 */
//	private T get(int index) {
//		checkListForIndexPresence(index);
//    	return findNode(index).value;
//	}
//
//	/*
//	 * Removing element with certain index.
//	 */
//	private void remove(int index) {
//		checkListForIndexPresence(index);
//
//		Node<T> currentNode = findNode(index);
//		Node<T> prevNode = currentNode.prev;
//		Node<T> nextNode = currentNode.next;
//
//        if (prevNode == null) {
//            head = nextNode;
//        } else {
//        	prevNode.next = nextNode;
//            currentNode.prev = null;
//        }
//
//        if (nextNode == null) {
//            tail = prevNode;
//        } else {
//        	nextNode.prev = prevNode;
//            currentNode.next = null;
//        }
//
//        currentNode.value = null;
//		listSize--;
//	}
//
//	/*
//	 * Checking for the presence in the List the element with certain index.
//	 */
//	private void checkListForIndexPresence(int index) {
//		if ((index >= listSize) || (index < 0))
//    		throw new IndexOutOfBoundsException();
//	}
//
//	/*
//	 * Looking for the element with certain index.
//	 */
//	private Node<T> findNode(int index) {
//		Node<T> currentNode = head;
//		int counter = 0; //elements counter
//		boolean needRepeat = true;
//
//		while (needRepeat) {
//			if (counter == index) {
//				//we've found the desired element
//				needRepeat = false;
//			} else {
//				currentNode = currentNode.next;
//				counter++;
//			}
//		}
//		return currentNode;
//	}
//
//	/*
//	 * Getting List size.
//	 */
//	private int getSize() {return listSize;}
//}