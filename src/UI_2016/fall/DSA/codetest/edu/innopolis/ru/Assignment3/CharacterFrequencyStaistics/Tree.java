//package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment3.CharacterFrequencyStaistics;
//
//class Tree {
//    private Node root;
//
//    Tree() {
//        this.root = null;
//    }
//
//    Node getRoot() {
//        return root;
//    }
//
//    void setRoot(Node root) {
//        this.root = root;
//    }
//
//    Node add(Character key, Integer value) {
//        Node newNode = new Node(key, value);
//        int comparisonResult;
//
//        //if root is null (the tree is empty), than newNode will be root
//        if (root == null) {
//            root = newNode;
//            return root;
//        }
//
//        Node currentNode = root;
//        //iterate the tree to the bottom while we have any not null currentNode
//        while (currentNode != null) {
//            comparisonResult = newNode.compareTo(currentNode);
//            switch (comparisonResult) {
//                case -1:
//                    //newNode < currentNode
//                    if (currentNode.getLeftChild() == null) {
//                        currentNode.setLeftChild(newNode);
//                        newNode.setParent(currentNode);
//                        return newNode;
//                    }
//                    currentNode = currentNode.getLeftChild();
//                    break;
//                case 1:
//                    //newNode > currentNode
//                    if (currentNode.getRightChild() == null) {
//                        currentNode.setRightChild(newNode);
//                        newNode.setParent(currentNode);
//                        return newNode;
//                    }
//                    currentNode = currentNode.getRightChild();
//                    break;
//                default: //0
//                    //newNode = currentNode
//                    Integer oldValue = currentNode.getValue();
//                    currentNode.setValue(value + oldValue);
//                    return currentNode;
//
//            }
//        }
//
//        return null;
//    }
//
//    /**
//     * Delete certain node.
//     */
//    Node delete(Node toDeleteNode) {
//        boolean toDeleteNodeIsRightChild = false, toDeleteNodeIsRoot = false;
//
//        if (toDeleteNode == null)
//            return null;
//
//        Node parent = toDeleteNode.getParent();
//        if (parent == null)
//            toDeleteNodeIsRoot = true;
//        else {
//            if (parent.compareTo(toDeleteNode) <= 0) //parent <= toDeleteNode -> toDeleteNode is right child of its parent
//                toDeleteNodeIsRightChild = true;
//        }
//
//        if (toDeleteNode.getLeftChild() == null
//                && toDeleteNode.getRightChild() == null) {
//            //toDeleteNode has no children
//            if (toDeleteNodeIsRoot) {
//                root = null;
//                return null;
//            } else {
//                if (toDeleteNodeIsRightChild)
//                    parent.setRightChild(null);
//                else
//                    parent.setLeftChild(null);
//                toDeleteNode.setParent(null);
//                return parent;
//            }
//        } else if (toDeleteNode.getLeftChild() != null
//                && toDeleteNode.getRightChild() != null) {
//            //both children are not null
//            Node successor = getSuccessor(toDeleteNode);
//            Node parentOfSuccessor = successor.getParent();
//            replaceNode(toDeleteNode, successor);
//            delete(successor); //successor.getKey());
//            return parentOfSuccessor;
//        } else {
//            //left OR right child is null
//            Node child;
//            if (toDeleteNode.getLeftChild() == null) //right child is not null
//                child = toDeleteNode.getRightChild();
//            else //left child is not null
//                child = toDeleteNode.getLeftChild();
//
//            if (toDeleteNodeIsRoot) {
//                root = child;
//                return root;
//            } else {
//                child.setParent(parent);
//                if (toDeleteNodeIsRightChild)
//                    parent.setRightChild(child);
//                else
//                    parent.setLeftChild(child);
//                toDeleteNode.setParent(null);
//                toDeleteNode.setLeftChild(null);
//                toDeleteNode.setRightChild(null);
//                return parent;
//            }
//        }
//    }
//
//    /**
//     * Search node with the certain key and then call method with params delete(Node toDeleteNode).
//     */
//    Node delete(Character key) {
//        Node toDeleteNode = searchNode(key);
//        return delete(toDeleteNode);
//    }
//
//    /**
//     * Replace key and value in toReplaceNode.
//     */
//    void replaceNode(Node toReplaceNode, Node newNode) {
//        toReplaceNode.setKey(newNode.getKey());
//        toReplaceNode.setValue(newNode.getValue());
//    }
//
//    /**
//     * Search node with the certain key and then call method with params replaceNode(Node toReplaceNode, Node newNode).
//     */
//    void replaceNode(Character key, Node newNode) {
//        Node toReplaceNode = searchNode(key);
//
//        replaceNode(toReplaceNode, newNode);
//    }
//
//    /**
//     * Search and return node with the certain key.
//     * Return null if there is no any node with the key.
//     */
//    Node searchNode(Character key) {
//        Node toSearchNode = new Node(key, key);
//        int comparisonResult;
//
//        Node currentNode = root;
//        //iterate the tree to the bottom while we have any not null currentNode
//        while (currentNode != null) {
//            comparisonResult = toSearchNode.compareTo(currentNode);
//            switch (comparisonResult) {
//                case -1:
//                    //toSearchNode < currentNode
//                    if (currentNode.getLeftChild() == null)
//                        currentNode = null; //the tree has no node with the key
//                    else
//                        currentNode = currentNode.getLeftChild();
//                    break;
//                case 1:
//                    //toSearchNode > currentNode
//                    if (currentNode.getRightChild() == null)
//                        currentNode = null; //the tree has no node with the key
//                    else
//                        currentNode = currentNode.getRightChild();
//                    break;
//                default: //0
//                    //toSearchNode = currentNode
//                    return currentNode;
//            }
//        }
//        return currentNode;
//    }
//
//    private Node getPredecessor(Node currentNode) {
//        Node predecessor = null;
//        if (currentNode != null)
//            currentNode = currentNode.getLeftChild();
//
//        //iterate the tree from currentNode to the bottom while we have any not null currentNode
//        while (currentNode != null) {
//            predecessor = currentNode;
//            currentNode = currentNode.getRightChild();
//        }
//        return predecessor;
//    }
//
//    private Node getSuccessor(Node currentNode) {
//        Node successor = null;
//        if (currentNode != null)
//            currentNode = currentNode.getRightChild();
//
//        //iterate the tree from currentNode to the bottom while we have any not null currentNode
//        while (currentNode != null) {
//            successor = currentNode;
//            currentNode = currentNode.getLeftChild();
//        }
//        return successor;
//    }
//}