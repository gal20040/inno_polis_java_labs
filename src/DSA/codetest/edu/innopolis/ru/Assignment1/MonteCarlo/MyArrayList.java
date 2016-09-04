//package DSA.codetest.edu.innopolis.ru.Assignment1.MonteCarlo;
//
//class MyArrayList<T> {
//    private T[] array;
//    private final static int initialSize = 5;
//    private int rateForExpansion = 2; //кратность для расширения листа
//
//    /*
//     * It's first empty element in array. After that may be we have some elements, but they are empty.
//     */
//    private int firstEmptyElement = 0;
//
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
//
//    private MyArrayList(int initialSize){array = (T[]) new Object[initialSize];}
//
//    public void add(T newElement) {
//        if (firstEmptyElement == array.length) {
//            resizeArray();
//        }
//        array[firstEmptyElement] = newElement;
//        firstEmptyElement++;
//    }
//
//	/*TODO: realise additional method
//	public void add(int index, T newElement) {}*/
//
//    /**
//     * Getting element with certain index.
//     */
//    private T get (int number) {
//        checkListForIndexPresence(number);
//        return array[number];
//    }
//
//    /**
//     * Removing element with certain index.
//     */
//    private void remove(int number) {
//        checkListForIndexPresence(number);
//
//        for (int i = number; i < array.length; i++) {
//            if (i + 1 == firstEmptyElement) { //reached the last element - complete processing
//                array[firstEmptyElement - 1] = null; //zero out the last element - it is no longer needed
//                firstEmptyElement--; //move the pointer to the previous element
//                i = array.length + 1;
//            }
//            else {array[i] = array[i + 1];}
//        }
//    }
//
//    /**
//     * Checking for the presence in the List the element with certain index.
//     */
//    private void checkListForIndexPresence(int index) {
//        if ((index >= array.length) || (index < 0))
//            throw new IndexOutOfBoundsException();
//    }
//
//    /**
//     * Extend array.
//     * //TODO хорошо бы не не только увеличивать, но и уменьшать - надо сделать проверку при удалении элементов, может быть пора уменьшить его
//     */
//    private void resizeArray() {
//        int newSize = array.length * rateForExpansion;
//        T[] tempArray;
////		tempArray = (T[]) new Object[newSize];
//
//        tempArray = array;
//
//        array = (T[]) new Object[newSize];
//
//        for (int i = 0; i < tempArray.length; i++) {
//            array[i] = tempArray[i];
//        }
//    }
//
//    private int getSize() {return array.length;}
//
//    //TODO сделать проверку, что при очередном увеличении кол-ва элементов
//    //мы не получим ошибку OutOfMemoryError
//}