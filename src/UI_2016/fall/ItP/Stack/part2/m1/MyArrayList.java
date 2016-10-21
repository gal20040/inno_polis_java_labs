//package UI_2016.fall.ItP.Stack.part2.m1;
//
//class MyArrayList<T> {
//    private T[] array;
//    private final static int initialSize = 5;
//
//    private int filledElementsNumber = 0;
//
//    MyArrayList(){
//        array = (T[]) new Object[initialSize];
//    }
//
//    /**
//     * Adds new element as the last.
//     */
//    void add(T newElement) {
//        add(filledElementsNumber, newElement);
//    }
//
//    /**
//     * Adds new element as the first.
//     */
//    void addFirst(T newElement) {
//        add(0, newElement);
//    }
//
//    /**
//     * Adds new element in certain index.
//     */
//    void add(int index, T newElement) {
//        if (filledElementsNumber == array.length) {
//            resizeArray();
//        }
//
//        checkArrayForIndexPresence(index);
//
//        if (index >= filledElementsNumber)
//            array[filledElementsNumber] = newElement;
//        else {
//            T tempElement;
//            while (index < array.length) {
//                if (index + 1 == filledElementsNumber) { //reached the last element - complete processing
//                    array[index + 1] = array[index];
//                    array[index] = newElement;
//                    index = array.length;
//                } else {
//                    tempElement = array[index];
//                    array[index] = newElement;
//                    newElement = tempElement;
//                }
//                index++;
//            }
//        }
//
//        filledElementsNumber++;
//    }
//
//    /**
//     * Replaces the value of element with certain index.
//     */
//    void replace(int index, T newValue) {
//        checkFilledElementsForIndexPresence(index);
//
//        array[index] = newValue;
//    }
//
//    /**
//     * Returns the value of element with certain index.
//     */
//    T get (int index) {
//        checkArrayForIndexPresence(index);
//        return array[index];
//    }
//
//    /**
//     * Returns the first element value.
//     */
//    T getFirst () {
//        return get(0);
//    }
//
//    /**
//     * Returns the last element value.
//     */
//    T getLast () {
//        return get(filledElementsNumber - 1);
//    }
//
//    /**
//     * Removes element with certain index.
//     */
//    void remove(int index) {
//        checkFilledElementsForIndexPresence(index);
//
//        while (index < filledElementsNumber) {
//            if (index == filledElementsNumber - 1) { //reached the last element - complete processing
//                array[index] = null; //set the last element equal to zero - it is no longer needed
//                filledElementsNumber--; //move the pointer to the previous element
//            } else {
//                array[index] = array[index + 1];
//            }
//
//            index++;
//        }
//    }
//
//    /**
//     * Checks existence of element with certain index in the array.
//     * We have array of 3 elements, 2 elements are filled:
//     * 0 1 null
//     * We call checkArrayForIndexPresence(2): OK
//     * We call checkArrayForIndexPresence(3): exception
//     */
//    private void checkArrayForIndexPresence(int index) {
//        if ((index < 0)
//                || (index >= array.length))
//            throw new IndexOutOfBoundsException();
//    }
//
//    /**
//     * Checks existence of element with certain index in the list of filled elements.
//     * We have array of 3 elements, 2 elements are filled:
//     * 0 1 null
//     * We call checkArrayForIndexPresence(1): OK
//     * We call checkArrayForIndexPresence(2): exception
//     */
//    private void checkFilledElementsForIndexPresence(int index) {
//        if ((index < 0)
//                || (index >= filledElementsNumber))
//            throw new IndexOutOfBoundsException();
//    }
//
//    /**
//     * Resizes the array when we don't care about new array size - call this method without params.
//     */
//    private void resizeArray() {
//        resizeArray(0);
//    }
//
//    /**
//     * Resizes the array when we care(!) about new array size - call this method with new size as param.
//     */
//    private void resizeArray(int newSize) {
//        int rateForExpansion = 2; //кратность для расширения листа
//        int tempNewSize = array.length * rateForExpansion;
//        if (newSize < tempNewSize)
//            newSize = tempNewSize;
//        T[] tempArray;
//
//        tempArray = array;
//
//        array = (T[]) new Object[newSize];
//
//        System.arraycopy(tempArray, 0, array, 0, tempArray.length);
//    }
//
//    /**
//     * Returns the number of the filled elements but not the size of the inner array.
//     */
//    int getFilledElementsNumber() {return filledElementsNumber;}
//
//    /**
//     * Returns the array length (the number of all elements - filled OR not filled).
//     */
//    int getArraySize() {return array.length;}
//}