//package UI_2016.fall.ItP.Stack.part2;
//
//class MyLinkedQueue<T> {
//    private int queueSize;
//    private String typeOfStructure;
//    private Node<T> head;
//    private Node<T> tail;
//
//    MyLinkedQueue() {
//        queueSize = 0;
//        typeOfStructure = Type.QUEUE.toString();
//        head = null;
//        StackQueueChecker.check(typeOfStructure, queueSize, head);
//    }
//
//    /**Adding new element to the Queue tail.*/
//    void enqueue(T t) {
//        Node<T> oldTailNode = tail;
//        tail = new Node<>();
//        tail.value = t;
//        tail.prev = oldTailNode;
//        if (oldTailNode == null)
//            head = tail;
//        else
//            oldTailNode.next = tail;
//        queueSize++;
//
//        StackQueueChecker.check(typeOfStructure, queueSize, head);
//    }
//
//    /**Removing and returning the first element.*/
//    T dequeue() {
//        if (queueSize == 0)// throw new NoSuchElementException("Stack underflow");
//            assert false : "Queue underflow";
//
//        T value = head.value;
//        Node<T> nextNode = head.next;
//
//        if (nextNode != null) {
//            nextNode.prev = null;
//            head.next = null;
//            head = nextNode;
//        } else {
//            head = null;
//            tail = null;
//        }
//
//        queueSize--;
//        StackQueueChecker.check(typeOfStructure, queueSize, head);
//
//        return value;
//    }
//
//    /**Getting the first element.*/
//    T peek() {
//        if (queueSize == 0)// throw new NoSuchElementException("Queue underflow");
//            assert false : "Queue underflow";
//
//        return head.value;
//    }
//
//    /**Getting Queue size.*/
//    int getSize() {return queueSize;}
//
////    public static void main(String[] args) {
////        MyLinkedQueue<Integer> myLinkedQueue = new MyLinkedQueue<>();
////        int elementsQuantityForTest = 5;
////
////        //filling List
////        for (int i = 0; i < elementsQuantityForTest; i++) {
////            myLinkedQueue.enqueue(i*2);
////        }
////
////        System.out.println("The first element is " + myLinkedQueue.peek());
////        System.out.println("Size is " + myLinkedQueue.getSize());
////
////        //dequeuing List
////        System.out.println("Queue:");
////        while (myLinkedQueue.getSize() > 0) {
////            System.out.print("Dequeued element is " + myLinkedQueue.dequeue() + ". ");
////            System.out.println("New size is " + myLinkedQueue.getSize() + ".");
////        }
////    }
//}