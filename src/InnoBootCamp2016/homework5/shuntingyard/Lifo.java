package homework5.shuntingyard;

import java.util.Arrays;

public class Lifo<T> {
	private T[] array;
	private static int initialSize = 5;
	private int rateForExpansion = 2; // Ratio for extending array
	
	public static void main(String[] args) {
		Lifo<Object> queue = new Lifo<Object>();

		for (int i = 1; i < 11; i++) {
			queue.add(i);
		}
		
		queue.remove(4-1);
		queue.remove(7-1);

		queue.show();
	}

	/*
	 * It's first empty element in array. After that may be we have some
	 * elements, but they are empty.
	 */
	private int firstEmptyElement = 0;

	public Lifo() {
		array = (T[]) new Object[initialSize];
	}

	public Lifo(int arraySize) {
		array = (T[]) new Object[arraySize];
	}

	private void resizeArray() {
		array = Arrays.copyOf(array, array.length * rateForExpansion);
	}

	public void add(T newElement) {
		if (firstEmptyElement >= array.length) {
			resizeArray();
		}

		array[firstEmptyElement] = newElement;
		firstEmptyElement++; // increasing a free element pointer
	}

	/*
	 * Getting element with certain index.
	 */
	public T get(int index) {
		checkListForIndexPresence(index);
		return array[index];
	}

	/*
	 * Removing element with certain index.
	 */
	public void remove(int index) {
		checkListForIndexPresence(index);

		for (int i = index; i < array.length; i++) {
			if (i + 1 == firstEmptyElement) { // reached the last element -
												// complete processing
				array[firstEmptyElement - 1] = null; // zero out the last
														// element - it is no
														// longer needed
				firstEmptyElement--; // move the pointer to the previous element
				i = array.length + 1;
			} else {
				array[i] = array[i + 1];
			}
		}
	}

	/*
	 * Checking for the presence in the List the element with certain index.
	 */
	public void checkListForIndexPresence(int index) {
//		System.out.println(index);
		if ((index >= array.length) || (index < 0))
			throw new IndexOutOfBoundsException();
	}

	public void show() {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	/*
	 * Returns the SIZE of the array Look also method getElementsNumber()
	 */
	protected int getSize() {
		return array.length;
	}

	/*
	 * Returns quantity of the elements in the array Look also method getSize()
	 */
	public int getElementsNumber() {
		return firstEmptyElement;
	}
}