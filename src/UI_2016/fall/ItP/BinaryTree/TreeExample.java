package UI_2016.fall.ItP.BinaryTree;

import java.util.Random;

public class TreeExample {
    public static void main(String[] args) {
        BSTree bsTree;

        bsTree = assignFirstTree();
        getTreeInfo(bsTree);

        deleteRoot(bsTree);
        getTreeInfo(bsTree);

        bsTree = assignSecondTree();
        getTreeInfo(bsTree);

        deleteRoot(bsTree);
        getTreeInfo(bsTree);

        searchNode(bsTree);
    }

    private static void searchNode(BSTree bsTree) {
        Node root = bsTree.getRoot();
        System.out.println("Ищем ноду со значением " + root.getValue());
        if (bsTree.searchNode((int) root.getValue()) != null)
            System.out.println("Нашли искомую ноду по ключу: " + bsTree.searchNode((int) root.getValue()).getValue());
        else
            System.out.println("Искомую ноду по ключу не нашли.");
        if (bsTree.searchNode(root.getValue()) != null)
            System.out.println("Нашли искомую ноду по значению: " + bsTree.searchNode(root.getValue()).getValue());
        else
            System.out.println("Искомую ноду по значению не нашли.");
    }

    private static void deleteRoot(BSTree bsTree) {
        System.out.println(String.format("Удалили из дерева рутовую ноду со значением %s.", bsTree.getRoot().getValue()));
        bsTree.delete(bsTree.getRoot().getKey());
    }

    private static void getTreeInfo(BSTree bsTree) {
        System.out.println("Quantity of nodes: " + bsTree.getNodesQuantity(bsTree.getRoot()));

        System.out.println();
        System.out.println("Tree height: " + bsTree.getTreeHeight());

        System.out.println();
        System.out.println("Travers the tree with preOrder algorithm: ");
        System.out.println(bsTree.printPreOrderTree());

        System.out.println();
        System.out.println("Travers the tree with inOrder algorithm: ");
        System.out.println(bsTree.printInOrderTree());

        System.out.println();
        System.out.println("Travers the tree with postOrder algorithm: ");
        System.out.println(bsTree.printPostOrderTree());

        System.out.println("-----------------------------------");
        System.out.println();
    }

    /**
     * Дерево в данном методе будет всегда одно и то же.
     */
    private static BSTree assignFirstTree() {
        BSTree bsTree = new BSTree();
/*      M
   I        Q
 B   K    O   X
A C J L  N P W Z

Quantity of nodes: 15
Tree height: 4
preOrder: 77:M 73:I 66:B 65:A 67:C 75:K 74:J 76:L 81:Q 79:O 78:N 80:P 88:X 87:W 90:Z
inOrder: 65:A 66:B 67:C 73:I 74:J 75:K 76:L 77:M 78:N 79:O 80:P 81:Q 87:W 88:X 90:Z
postOrder: 65:A 67:C 66:B 74:J 76:L 75:K 73:I 78:N 80:P 79:O 87:W 90:Z 88:X 81:Q 77:M
 */

        String inputString = "MIQBKOXACJLNPWZ";
        char[] charString = new char[1];
        int j = 0;
        for (int i = 0; i < inputString.length(); i++) {
            inputString.getChars(i, i+1, charString, j);
            bsTree.add(charString[0], charString[0]);
        }

        return bsTree;
    }

    /**
     * Дерево в данном методе задаётся случайно.
     */
    private static BSTree assignSecondTree() {
        BSTree bsTree = new BSTree();

        Random random = new Random();
        int nextRandom;
        for (int i = 0; i < 20 ; i++) {
            nextRandom = random.nextInt(26) + 65;
            bsTree.add(nextRandom, (char) nextRandom);
        }

        return bsTree;
    }
}