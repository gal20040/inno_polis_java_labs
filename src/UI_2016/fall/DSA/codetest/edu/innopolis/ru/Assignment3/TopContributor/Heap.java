package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment3.TopContributor;

import java.util.ArrayList;

//class Heap {
class Heap<T extends Comparable<T>> {
    private static ArrayList<Node> heap = new ArrayList<>();
    private static int notNullElementsNumber = 0;

    //    void put(Node newNode) {
//        heap.add(newNode);
    void put(int key, T value) {
        heap.add(new Node(key, value));
        notNullElementsNumber++;
    }

    Node peekRoot(){
        return notNullElementsNumber > 0 ? heap.get(0) : null;
    }

    Node popRoot(){
        Node node;
        if (notNullElementsNumber > 0) {
            node = heap.get(0);
            swap(0, notNullElementsNumber - 1);
            heap.remove(notNullElementsNumber - 1);
            notNullElementsNumber--;
            return node;
        }
        else
            return null;
    }

    int getSize() {return notNullElementsNumber;}

    Node peekAtIndex(int index) {
        return isIndexInQueue(index) ? heap.get(index) : null;
    }

    private boolean isIndexInQueue(int index) {
        return ((index >= 0)
                && (index < notNullElementsNumber));
    }

    void swap(int firstNodeIndex, int secondNodeIndex) {
        Node tempNode = heap.get(firstNodeIndex);
        heap.set(firstNodeIndex, heap.get(secondNodeIndex));
        heap.set(secondNodeIndex, tempNode);
    }
}