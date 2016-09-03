package DSA.codetest.edu.innopolis.ru.Assignment1.ShuntingYard;

class MyLinkedStack<T> {
    private int listSize;
    private String typeOfStructure;
    private Node<T> tail;

    MyLinkedStack() {
        listSize = 0;
        typeOfStructure = Type.STACK.toString();
        tail = null;
        StackQueueChecker.check(typeOfStructure, listSize, tail);
    }

    /**Adding new element to the List tail.*/
    void push(T t) {
        Node<T> oldTailNode = tail;
        tail = new Node<>();
        tail.value = t;
        tail.prev = oldTailNode;
        if (oldTailNode != null)
            oldTailNode.next = tail;
        listSize++;

        StackQueueChecker.check(typeOfStructure, listSize, tail);
    }

    /**Getting the last element.*/
    T peek() {
        if (listSize == 0)// throw new NoSuchElementException("Stack underflow");
            assert false : "Stack underflow";

        return tail.value;
    }

    /**Removing and returning the last element.*/
    T pop() {
        if (listSize == 0)// throw new NoSuchElementException("Stack underflow");
            assert false : "Stack underflow";

        T value = tail.value;
        Node<T> prevNode = tail.prev;

        if (prevNode != null) {
            prevNode.next = null;
            tail.prev = null;
            tail = prevNode;
        } else tail = null;

        listSize--;
        StackQueueChecker.check(typeOfStructure, listSize, tail);

        return value;
    }

    /**Getting List size.*/
    int getSize() {return listSize;}

//    public static void main (String args[]) {
//        MyLinkedStack<Integer> myLinkedList = new MyLinkedStack<>();
//        int elementsQuantityForTest = 5;
//
//        //filling List
//        for (int i = 0; i < elementsQuantityForTest; i++) {
//            myLinkedList.push(i*2);
//        }
//
//        System.out.println("The last element is " + myLinkedList.peek());
//        System.out.println("Size is " + myLinkedList.getSize());
//
//        //popping List
//        System.out.println("List:");
//        while (myLinkedList.getSize() > 0) {
//            System.out.print("Popped element is " + myLinkedList.pop() + ". ");
//            System.out.println("New size is " + myLinkedList.getSize() + ".");
//        }
//    }
}