package UI_2016.fall.ItP.Stack.part2;

class MyArrayStack<T> {
    private T[] array;
    private final static int initialSize = 5;
    private int notNullElementsNumber;

    MyArrayStack() {
        notNullElementsNumber = 0;
        array = (T[]) new Object[initialSize];
        checkStack();
    }

    /**
     * Adds new element to the stack top.
     */
    void push(T newElement) {
        if (notNullElementsNumber == array.length) {
            resizeArray();
        }

        array[notNullElementsNumber] = newElement;
        notNullElementsNumber++;
        checkStack();
    }

    /**
     * Returns the value of the last not null element.
     */
    T peek() {
        if (notNullElementsNumber == 0)// throw new NoSuchElementException("Stack underflow");
            assert false : "Stack underflow";

        return array[notNullElementsNumber - 1];
    }

    /**
     * Removes the element at the top of this stack
     * and returns that element as the value of this method.
     */
    T pop() {
        if (notNullElementsNumber == 0)// throw new NoSuchElementException("Stack underflow");
            assert false : "Stack underflow";

        T value = array[notNullElementsNumber - 1];
        array[notNullElementsNumber - 1] = null;
        notNullElementsNumber--;

        checkStack();

        return value;
    }

    /**
     * Returns the number of the not null elements but not the size of the stack.
     */
    int getNotNullElementsNumber() {
        checkStack();
        return notNullElementsNumber;
    }

    /**
     * Returns the stack size (the number of all elements - null OR not null).
     */
    int getStackSize() {return array.length;}

    /**
     * Resizes the array when we don't care about new stack size - call this method without params.
     */
    private void resizeArray() {
        resizeArray(0);
    }

    /**
     * Resizes the stack when we care(!) about new stack size - call this method with new size as param.
     * For example now the stack size is 50 and we know that we need 500, than we may get stack with new size in one step.
     */
    void resizeArray(int newSize) {
        int rateForExpansion = 2; //кратность для расширения листа
        int tempNewSize = array.length * rateForExpansion;
        if (newSize < tempNewSize)
            newSize = tempNewSize;
        T[] tempArray;

        tempArray = array;

        array = (T[]) new Object[newSize];

        System.arraycopy(tempArray, 0, array, 0, tempArray.length);

        checkStack();
    }

    private void checkStack() {
        if (notNullElementsNumber < 0)
            assert false : "notNullElementsNumber < 0";
        else if (notNullElementsNumber == 0 && array[0] != null)
            assert false : "notNullElementsNumber == 0 && array[0] != null";
        else if (notNullElementsNumber >= 1 && array[0] == null)
            assert false : "notNullElementsNumber >= 1 && array[0] == null";
        else if (notNullElementsNumber == 1 && array[1] != null)
            assert false : "notNullElementsNumber == 1 && array[1] != null";
        else if (notNullElementsNumber > 1 && array[1] == null)
            assert false : "notNullElementsNumber > 1 && array[1] == null";

        int counter = 0;

        while (array[counter] != null) {
            counter++;
            if (counter == array.length)
                break;
        }
        if (notNullElementsNumber != counter)
            assert false : "Variable notNullElementsNumber != real number of not null elements of the stack.";
    }
}