package UI_2016.fall.ItP.BinaryTree;

import static java.lang.Math.max;

class Node implements Comparable<Node> {
    private int key;
    private Character value;
    private Node parent;
    private Node leftChild;
    private Node rightChild;
    private int height;

    Node(int key, Character value) {
        this.key = key;
        this.value = value;
        this.parent = null;
        this.leftChild = null;
        this.rightChild = null;
        this.height = 1;
    }

    public int compareTo(Node other) {
        return Integer.compare(this.key, other.key);
        /*Using:
        comparisonResult = newNode.compareTo(currentNode);
            case -1:
                //newNode < currentNode
            case 1:
                //newNode >= currentNode*/
    }

    int getKey() {return key;}
    Character getValue() {return value;}
    Node getParent() {return parent;}
    Node getLeftChild() {return leftChild;}
    Node getRightChild() {return rightChild;}
    int getHeight() {return height;}

    void setKey(int key) {this.key = key;}
    void setValue(Character value) {this.value = value;}
    void setParent(Node parent) {this.parent = parent;}
    void setLeftChild(Node leftChild) {this.leftChild = leftChild;}
    void setRightChild(Node rightChild) {this.rightChild = rightChild;}
    private void setHeight(int height) {this.height = height;}

    void validateHeight() {
        int leftChildHeight = 0, rightChildHeight = 0;
        if (leftChild != null)
            leftChildHeight = leftChild.getHeight();
        if (rightChild != null)
            rightChildHeight = rightChild.getHeight();
        setHeight(1 + max(leftChildHeight, rightChildHeight));
    }
}