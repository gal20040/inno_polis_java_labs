package UI_2016.fall.ItP.BinaryTree;

class BSTree {
    private Tree tree = new Tree();
    private String outputString = "";

    void add(int key, Character value) {
        Node node = tree.add(key, value);
        validateTreeHeight(node);
    }

    /**
     * A recursive routine for a recursive data structure
     * В задании этот метод называется: int nodes() {...}
     */
    int getNodesQuantity(Node currentNode) {
        if (currentNode == null)
            return 0;

        int result = 1;
        if (currentNode.getLeftChild() != null)
            result += getNodesQuantity(currentNode.getLeftChild());
        if (currentNode.getRightChild() != null)
            result += getNodesQuantity(currentNode.getRightChild());
        return result;
    }

    private void validateTreeHeight(Node currentNode) {
        while (currentNode != null) {
            currentNode.validateHeight();
            currentNode = currentNode.getParent();
        }
    }

    /**
     * Iterate the tree and search for node with the key - delete it.
     */
    void delete(int key) {
        Node node = tree.delete(key);
        validateTreeHeight(node);
    }

    /** Print the tree content with inorder traversing algorithm.

     * HW statement:
     * Tree traversal: print the contents of all tree nodes (assume the contents is integer or string).
     * Use inorder traversing algorithm.*/
    String printInOrderTree() {
        outputString = "";
        printInOrderTree(tree.getRoot());
        return outputString;
    }

    /**
     * InOrder traversing algorithm: visit left subtree first, then visit the node itself, then visit right subtree.
     */
    private void printInOrderTree(Node currentNode) {
        if (currentNode != null) {
            printInOrderTree(currentNode.getLeftChild());

            //currentNode
            outputString = outputString + currentNode.getKey() + ":" + currentNode.getValue() + " ";

            printInOrderTree(currentNode.getRightChild());
        }
    }

    /**
     * Return the root of the tree.
     */
    Node getRoot() {
        return tree.getRoot();
    }

    String printPreOrderTree() {
        outputString = "";
        printPreOrderTree(tree.getRoot());
        return outputString;
    }

    private void printPreOrderTree(Node currentNode) {
        if (currentNode != null) {
            //currentNode
            outputString = outputString + currentNode.getKey() + ":" + currentNode.getValue() + " ";

            printPreOrderTree(currentNode.getLeftChild());
            printPreOrderTree(currentNode.getRightChild());
        }
    }

    String printPostOrderTree() {
        outputString = "";
        printPostOrderTree(tree.getRoot());
        return outputString;
    }

    private void printPostOrderTree(Node currentNode) {
        if (currentNode != null) {
            printPostOrderTree(currentNode.getLeftChild());
            printPostOrderTree(currentNode.getRightChild());

            //currentNode
            outputString = outputString + currentNode.getKey() + ":" + currentNode.getValue() + " ";
        }
    }

    /**
     * Calculate the height of a binary tree.
     */
    int getTreeHeight() {
        if (getRoot() == null)
            return 0;
        else
            return getRoot().getHeight();
    }

    /**
     * Search and return node with the certain key.
     * Return null if there is no any node with the key.
     */
    Node searchNode(int key) {
        return tree.searchNode(key);
    }

    /**
     * Search and return node with the certain value.
     * Return null if there is no any node with the value.

     * HW statement:
     * The function searching for a particular value in the sorted tree. The value is to be passed via parameter.
     * Use preorder traversing algorithm.
     */
    Node searchNode(Character value) {
        Node currentNode = getRoot();
        return searchNodeWithPreOrder(currentNode, value);
    }

    private Node searchNodeWithPreOrder(Node currentNode, Character value) {
        Node toSearchNode = null;
        if (currentNode != null) {
            //currentNode
            if (currentNode.getValue() == value)
                toSearchNode = currentNode;
            else {
                searchNodeWithPreOrder(currentNode.getLeftChild(), value);
                searchNodeWithPreOrder(currentNode.getRightChild(), value);
            }
        }
        return toSearchNode;
    }
}