//package UI_2016.fall.ItP.Stack.part2.m1;
//
//import java.util.Stack;
//
//class MyList<T> {
//    private T[] array;
//    private final static int initialSize = 5;
//
//    private int notNullElementsNumber = 0;
//
//    MyList(){
//        array = (T[]) new Object[initialSize];
//    }
//
//    /**
//     * Adds new element as the last.
//     */
//    void add(T newElement) {
//        if (notNullElementsNumber == array.length) {
//            resizeArray();
//        }
//
//        array[notNullElementsNumber] = newElement;
//        notNullElementsNumber++;
//    }
//
//    /**
//     * Returns the value of the last not null element.
//     */
//    T get () {
//        return array[notNullElementsNumber - 1];
//    }
//
//    /**
//     * Removes the last added not null element.
//     * Removes the object at the top of this stack and returns that
//     * object as the value of this function.
//     */
////    T
//    void getremove() {
//        int index = notNullElementsNumber;
//
//        while (index < notNullElementsNumber) {
//            if (index == notNullElementsNumber - 1) { //reached the last element - complete processing
//                array[index] = null; //set the last element equal to zero - it is no longer needed
//                notNullElementsNumber--; //move the pointer to the previous element
//            } else {
//                array[index] = array[index + 1];
//            }
//
//            index++;
//        }
//
////        return 1;
//    }
//
//    /**
//     * Checks existence of element with certain index in the array.
//     * We have array of 3 elements, 2 elements are not null:
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
//     * Checks existence of element with certain index in the list of not null elements.
//     * We have array of 3 elements, 2 elements are not null:
//     * 0 1 null
//     * We call checkArrayForIndexPresence(1): OK
//     * We call checkArrayForIndexPresence(2): exception
//     */
//    private void checkNotNullElementsForIndexPresence(int index) {
//        if ((index < 0)
//                || (index >= notNullElementsNumber))
//            throw new IndexOutOfBoundsException();
//    }
//
////    /**
////     * Resizes the array when we don't care about new array size - call this method without params.
////     */
////    private void resizeArray() {
////        resizeArray(0);
////    }
////
////    /**
////     * Resizes the array when we care(!) about new array size - call this method with new size as param.
////     */
////    private void resizeArray(int newSize) {
////        int rateForExpansion = 2; //кратность для расширения листа
////        int tempNewSize = array.length * rateForExpansion;
////        if (newSize < tempNewSize)
////            newSize = tempNewSize;
////        T[] tempArray;
////
////        tempArray = array;
////
////        array = (T[]) new Object[newSize];
////
////        System.arraycopy(tempArray, 0, array, 0, tempArray.length);
////    }
//
//    /**
//     * Returns the number of the not null elements but not the size of the inner array.
//     */
//    int getNotNullElementsNumber() {return notNullElementsNumber;}
//
//    /**
//     * Returns the array length (the number of all elements - null OR not null).
//     */
//    int getArraySize() {return array.length;}
//}