//package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment3.CharacterFrequencyStaistics;
//
//import static java.lang.Math.abs;
//import static java.lang.Math.max;
//
//class Node implements Comparable<Node> {
//    private char key;
//    private int value;
//    private Node parent;
//    private Node leftChild;
//    private Node rightChild;
//    private int height;
//
//    Node(char key, int value) {
//        this.key = key;
//        this.value = value;
//        this.parent = null;
//        this.leftChild = null;
//        this.rightChild = null;
//        this.height = 1;
//    }
//
//    public int compareTo(Node other) {
//        return Integer.compare(this.key, other.key);
//        /*Using:
//        comparisonResult = newNode.compareTo(currentNode);
//            case -1:
//                //newNode < currentNode
//            case 1:
//                //newNode >= currentNode*/
//    }
//
//    char getKey() {return key;}
//    int getValue() {return value;}
//    Node getParent() {return parent;}
//    Node getLeftChild() {return leftChild;}
//    Node getRightChild() {return rightChild;}
//    int getHeight() {return height;}
//
//    void setKey(char key) {this.key = key;}
//    private void setHeight(int height) {this.height = height;}
//    void setValue(int value) {this.value = value;}
//    void setParent(Node parent) {this.parent = parent;}
//    void setLeftChild(Node leftChild) {this.leftChild = leftChild;}
//    void setRightChild(Node rightChild) {this.rightChild = rightChild;}
//
//    void validateHeight() {
//        int leftChildHeight = 0, rightChildHeight = 0;
//        if (leftChild != null)
//            leftChildHeight = leftChild.getHeight();
//        if (rightChild != null)
//            rightChildHeight = rightChild.getHeight();
//        setHeight(1 + max(leftChildHeight, rightChildHeight));
//    }
//
//    int getHeightDifference() {
//        int leftChildHeight = 0, rightChildHeight = 0;
//        if (leftChild != null)
//            leftChildHeight = leftChild.getHeight();
//        if (rightChild != null)
//            rightChildHeight = rightChild.getHeight();
//        return abs(leftChildHeight - rightChildHeight);
//    }
//}