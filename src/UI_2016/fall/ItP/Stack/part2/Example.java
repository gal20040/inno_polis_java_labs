package UI_2016.fall.ItP.Stack.part2;

public class Example {
    public static void main (String args[]) {
        MyArrayStack<Integer> myArrayStack = new MyArrayStack<>();
        int elementsQuantityForTest = 6;

        //filling List
        for (int i = 0; i < elementsQuantityForTest; i++) {
            myArrayStack.push(i*2);
        }

        System.out.println("The last element is " + myArrayStack.peek());
        System.out.print("StackSize=" + myArrayStack.getStackSize());
        System.out.println(" FilledElementsNumber=" + myArrayStack.getNotNullElementsNumber());

        //popping List
        System.out.println("List:");
        while (myArrayStack.getNotNullElementsNumber() > 0) {
            System.out.print("Popped element is " + myArrayStack.pop() + ". ");
            System.out.print("StackSize=" + myArrayStack.getStackSize());
            System.out.println(" FilledElementsNumber=" + myArrayStack.getNotNullElementsNumber());
        }
    }
}