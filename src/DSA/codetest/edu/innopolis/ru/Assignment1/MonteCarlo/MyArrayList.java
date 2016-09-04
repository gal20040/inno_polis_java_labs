package DSA.codetest.edu.innopolis.ru.Assignment1.MonteCarlo;

class MyArrayList<T> {
    private T[] array;
    private final static int initialSize = 5;

    //It's first empty element in array. After that may be we have some elements, but they are empty.
    private int firstEmptyElement = 0;

//    public static void main (String args[]) {
//
//        MyArrayList<Integer> myArrayList = new MyArrayList<>(initialSize);
//
//        //filling List
//        for (int i = 0; i < initialSize; i++) {
//            myArrayList.add(i*2);
//        }
//
//        System.out.println("List:");
//        for (int i = 0; i < myArrayList.getSize(); i++) {
//            System.out.println(myArrayList.get(i));
//        }
//        System.out.println();
//
//        myArrayList.remove(1); //delete some element
//        myArrayList.remove(2);
//        System.out.println("List:");
//        for (int i = 0; i < myArrayList.getSize(); i++) {
//            System.out.println(myArrayList.get(i));
//        }
//    }

    MyArrayList(){array = (T[]) new Object[initialSize];}

    void add(T newElement) {
        if (firstEmptyElement == array.length) {
            resizeArray();
        }
        array[firstEmptyElement] = newElement;
        firstEmptyElement++;
    }

    /**
     * Getting element with certain index.
     */
    T get (int number) {
        checkListForIndexPresence(number);
        return array[number];
    }

    /**
     * Getting the last element.
     */
    T getLast () {
        checkListForIndexPresence(firstEmptyElement - 1);
        return array[firstEmptyElement - 1];
    }

    /**
     * Removing element with certain index.
     */
    void remove(int number) {
        checkListForIndexPresence(number);

        for (int i = number; i < array.length; i++) {
            if (i + 1 == firstEmptyElement) { //reached the last element - complete processing
                array[firstEmptyElement - 1] = null; //zero out the last element - it is no longer needed
                firstEmptyElement--; //move the pointer to the previous element
                i = array.length + 1;
            }
            else {array[i] = array[i + 1];}
        }
    }

    /**
     * Checking for the presence in the List the element with certain index.
     */
    private void checkListForIndexPresence(int index) {
        if ((index >= array.length) || (index < 0))
            throw new IndexOutOfBoundsException();
    }

    private void resizeArray() {
        int rateForExpansion = 2; //кратность для расширения листа
        int newSize = array.length * rateForExpansion;
        T[] tempArray;

        tempArray = array;

        array = (T[]) new Object[newSize];

        System.arraycopy(tempArray, 0, array, 0, tempArray.length);
    }

    int getSize() {return firstEmptyElement;}
}