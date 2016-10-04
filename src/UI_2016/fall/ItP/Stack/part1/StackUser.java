package UI_2016.fall.ItP.Stack.part1;

/**
 * Assignment 6 (part 1)
 * Write the complete implementation of the Stack class template.
 */
public class StackUser {
    public static void main(String[] args) {
        MyArrayStack<Integer> myArrayStack = new MyArrayStack<>();

        int elementsQuantityForTest = 5;

        //filling List
        for (int i = 0; i < elementsQuantityForTest; i++) {
            myArrayStack.push(i*2);
        }

        System.out.println("The last stack element:");
        System.out.println(myArrayStack.peek());
        System.out.println();

        myArrayStack.pop(); //delete two elements
        myArrayStack.pop();

        System.out.println("Stack:");
        for (int i = 0; i < myArrayStack.getSize(); ) {
            System.out.println(myArrayStack.pop());
        }
    }
}