//package DSA.codetest.edu.innopolis.ru.Assignment1.ShuntingYard;

import java.util.NoSuchElementException;

class MyLinkedStack<T> {
    private int listSize = 0;
    private Node<T> head;
    private Node<T> tail;

//    public static void main (String args[]) {
//        MyLinkedStack<Integer> MyLinkedList = new MyLinkedStack<>();
//        int elementsQuantityForTest = 5;
//
//        //filling List
//        for (int i = 0; i < elementsQuantityForTest; i++) {
//            MyLinkedList.push(i*2);
//        }
//
//        System.out.println("The last element is " + MyLinkedList.peek());
//        System.out.println("Size is " + MyLinkedList.getSize());
//
//        //pop List
//        System.out.println("List:");
//        while (MyLinkedList.getSize() > 0) {
//            System.out.print("Popped element is " + MyLinkedList.pop() + ". ");
//            System.out.println("New size is " + MyLinkedList.getSize() + ".");
//        }
//    }

    MyLinkedStack() {}

    /*
     * Adding new element to the List tail.
     */
    void push(T t) {
        final Node<T> oldTailNode = tail;
        tail = new Node<>();
        tail.value = t;
        if (oldTailNode == null)
            head = tail;
        else {
            tail.prev = oldTailNode;
            oldTailNode.next = tail;
        }
        listSize++;
    }

    /*
     * Getting the last element.
     */
    T peek() {
        if (listSize == 0) throw new NoSuchElementException("Stack underflow");

        return tail.value;
    }

    /*
     * Removing and returning the last element.
     */
    T pop() {
        if (listSize == 0) throw new NoSuchElementException("Stack underflow");

        T value = tail.value;
        Node<T> prevNode = tail.prev;

        tail.value = null;
        if (prevNode != null) {
            prevNode.next = null;
            tail.prev = null;
            tail = prevNode;
        }

        listSize--;

        return value;
    }

    /*
     * Getting List size.
     */
    int getSize() {return listSize;}
}