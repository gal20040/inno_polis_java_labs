//package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment3.CharacterFrequencyStaistics;
//
//class AVLTree {
//    private static Tree tree = new Tree();
//    private String outputString = "";
//
//    void add(Character key, Integer value) {
//        Node node = tree.add(key, value);
//
//        validateTreeAfterAddition(node);
//    }
//
//    private void validateTreeAfterAddition(Node currentNode) {
//        validateTreeHeight(currentNode);
//
//        Node xNode = currentNode, yNode = currentNode, zNode = currentNode;
//        while (xNode != null) {
//            if (xNode.getHeightDifference() <= 1) {
//                zNode = yNode;
//                yNode = xNode;
//                xNode = xNode.getParent();
//            } else
//                break;
//        }
//
//        if (xNode != null)
//            triNodeRebalanceTree(xNode, yNode, zNode);
//    }
//
//    private void validateTreeHeight(Node currentNode) {
//        while (currentNode != null) {
//            currentNode.validateHeight();
//            currentNode = currentNode.getParent();
//        }
//    }
//
//    private Node triNodeRebalanceTree(Node xNode, Node yNode, Node zNode) {
//        Node aNode, bNode, cNode;
//        Node t0Node, t1Node, t2Node, t3Node;
//
//        boolean yIsLeftChild = (yNode.compareTo(xNode) == -1);
//        boolean zIsLeftChild = (zNode.compareTo(yNode) == -1);
//
//        if (yIsLeftChild && zIsLeftChild) {
//            aNode = zNode;
//            bNode = yNode;
//            cNode = xNode;
//            t0Node = aNode.getLeftChild();
//            t1Node = aNode.getRightChild();
//            t2Node = bNode.getRightChild();
//            t3Node = cNode.getRightChild();
//        } else if (yIsLeftChild && !zIsLeftChild) {
//            aNode = yNode;
//            bNode = zNode;
//            cNode = xNode;
//            t0Node = aNode.getLeftChild();
//            t1Node = bNode.getLeftChild();
//            t2Node = bNode.getRightChild();
//            t3Node = cNode.getRightChild();
//        } else if (!yIsLeftChild && zIsLeftChild) {
//            aNode = xNode;
//            bNode = zNode;
//            cNode = yNode;
//            t0Node = aNode.getLeftChild();
//            t1Node = bNode.getLeftChild();
//            t2Node = bNode.getRightChild();
//            t3Node = cNode.getRightChild();
//        } else {
//            //statement (!yIsLeftChild && !zIsLeftChild)
//            aNode = xNode;
//            bNode = yNode;
//            cNode = zNode;
//            t0Node = aNode.getLeftChild();
//            t1Node = bNode.getLeftChild();
//            t2Node = cNode.getLeftChild();
//            t3Node = cNode.getRightChild();
//        }
//
//        if (xNode.getParent() == null) {
//            tree.setRoot(bNode);
//            bNode.setParent(null);
//        } else {
//            Node xNodeParent = xNode.getParent();
//            if (xNode.compareTo(xNodeParent) == -1) //xNode is the left child of its parent
//                xNodeParent.setLeftChild(bNode);
//            else //xNode is the right child of its parent
//                xNodeParent.setRightChild(bNode);
//            bNode.setParent(xNodeParent);
//        }
//
//        bNode.setLeftChild(aNode);
//        bNode.setRightChild(cNode);
//        aNode.setParent(bNode);
//        cNode.setParent(bNode);
//
//        aNode.setLeftChild(t0Node);
//        aNode.setRightChild(t1Node);
//        if (t0Node != null)
//            t0Node.setParent(aNode);
//        if (t1Node != null)
//            t1Node.setParent(aNode);
//
//        cNode.setLeftChild(t2Node);
//        cNode.setRightChild(t3Node);
//        if (t2Node != null)
//            t2Node.setParent(cNode);
//        if (t3Node != null)
//            t3Node.setParent(cNode);
//
//        aNode.validateHeight();
//        cNode.validateHeight();
//        validateTreeHeight(bNode);
//
//        return bNode;
//    }
//
//    /**
//     * Iterate the tree and search for node with the key - delete it and start rebalancing.
//     */
//    void delete(Character key) {
//        Node node = tree.delete(key);
//        validateTreeAfterDeletion(node);
//    }
//
//    private void validateTreeAfterDeletion(Node currentNode) {
//        validateTreeHeight(currentNode);
//
//        Node xNode, yNode, zNode;
//        while (currentNode != null) {
//            if (currentNode.getHeightDifference() > 1) {
//                xNode = currentNode;
//                yNode = getTallerChild(xNode);
//                zNode = getTallerChild(yNode);
//                currentNode = triNodeRebalanceTree(xNode, yNode, zNode);
//            }
//            currentNode = currentNode.getParent();
//        }
//    }
//
//    private Node getTallerChild(Node currentNode) {
//        Node leftChild = currentNode.getLeftChild();
//        Node rightChild = currentNode.getRightChild();
//        if (leftChild != null
//                && rightChild != null) {
//            if (leftChild.getHeight() < rightChild.getHeight())
//                //leftChild.height < rightChild.height
//                return rightChild;
//            else
//                //leftChild.height >= rightChild.height
//                return leftChild;
//        } else if (rightChild == null)
//            return leftChild;
//        else //(leftChild == null)
//            return rightChild;
//    }
//
//    String traverse() {
//        traverse(tree.getRoot());
//        return outputString;
//    }
//
//    private void traverse(Node currentNode) {
//        Node leftChild, rightChild;
//        while (currentNode != null) {
//            leftChild = currentNode.getLeftChild();
//            if (leftChild != null)
//                traverse(leftChild);
//
//            //currentNode
//            outputString = outputString + currentNode.getKey() + ":" + currentNode.getValue() + " ";
//
//            rightChild = currentNode.getRightChild();
//            if (rightChild != null)
//                traverse(rightChild);
//            currentNode = null;
//        }
//    }
//}