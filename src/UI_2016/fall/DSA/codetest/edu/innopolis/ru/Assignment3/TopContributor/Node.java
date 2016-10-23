package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment3.TopContributor;

class Node<T> implements Comparable<Node> {
    private int priority;
    private T value;

    Node(int key, T value) {
        this.priority = key;
        this.value = value;
    }

    public int compareTo(Node other) {
        return Integer.compare(this.priority, other.priority);
    }

    int getPriority() {return priority;}
    T getValue() {return value;}
}