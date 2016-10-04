package UI_2016.fall.ItP.Stack.part1;

class MyArrayStack<T> {
    private T[] arrayStack;
    private final static int initialSize = 5;
    private final static int rateForExpansion = 2; //кратность расширения стека
    private int stackElementsQuantity;

    MyArrayStack(){
        stackElementsQuantity = 0;
        arrayStack = (T[]) new Object[initialSize];
    }

    /**Add new element as the last Stack element.*/
    void push(T newElement) {
        if (stackElementsQuantity == arrayStack.length)
            resizeArray();
        arrayStack[stackElementsQuantity] = newElement;
        stackElementsQuantity++;
    }

    /**Returns the last element value.*/
    T peek() {
        T value = null;
        if (stackElementsQuantity > 0) {
            value = arrayStack[stackElementsQuantity - 1];
        }

        return value;
    }

    /**Removes the last element and returns its value.*/
    T pop() {
        T value = null;
        if (stackElementsQuantity > 0) {
            value = arrayStack[stackElementsQuantity - 1];
            arrayStack[stackElementsQuantity - 1] = null;
            stackElementsQuantity--;
        }

        return value;
    }

    private void resizeArray() {
        int newSize = arrayStack.length * rateForExpansion;
        T[] tempArray;

        tempArray = arrayStack;
        arrayStack = (T[]) new Object[newSize];
        System.arraycopy(tempArray, 0, arrayStack, 0, tempArray.length);
    }

    /**Returns stack size.*/
    int getSize() {return stackElementsQuantity;}
}