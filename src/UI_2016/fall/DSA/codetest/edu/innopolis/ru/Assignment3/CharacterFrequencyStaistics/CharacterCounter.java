//package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment3.CharacterFrequencyStaistics;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.BiConsumer;
//
///**
// * Statement
// Implement a balanced search tree as a Map ADT. Any of {RB, AVL, B}-tree will work.
// Ensure that your tree has following methods implemented:
// - public V delete(K key)
// - private Node[K] predecessor(Node n [, K k])  // K - for B-tree
// - private Node[K] successor(Node n [, K k])    // K - for B-tree
// - public void traverse(java.util.function.BiConsumer visitor)
// - public void traverse(java.util.function.BiConsumer visitor, K from, K to)
// For a text in input.txt count character frequency distribution (case insensitive) using Map<Character, Integer> dictionary.
// Remove following characters from your map:
// :;<=>?@[\]^_`        //These are ASCII (0x3A-0x40, 0x5B-0x60).
//
// Print ordered statistics as [letter]:[count] to output.txt for a range [0-z]. Skip 0-elements.
// Separate by spaces. Use traverse(...) method for this.
// Example #1
// input.txt
// Lazy fox Jack.
// output.txt
// a:2 c:1 f:1 j:1 k:1 l:1 o:1 x:1 y:1 z:1
//
// Example #2
// input.txt
// 12345 Zaychik
// output.txt
// 1:1 2:1 3:1 4:1 5:1 a:1 c:1 h:1 i:1 k:1 y:1 z:1
// */
//public class CharacterCounter {
//    public static void main(String[] args) {
//        AVLTree avlTree = new AVLTree();
//        FileReaderWriter fileReaderWriter = new FileReaderWriter();
//        String inputString = fileReaderWriter.readFromInputFile();
//
//        char[] oneChar = new char[1];
//        int j = 0;
//        for (int i = 0; i < inputString.length(); i++) {
//            inputString.getChars(i, i + 1, oneChar, j);
//            if (oneChar[0] >= 65 && oneChar[0] <= 90)
//                oneChar[0] = (char) (oneChar[0] + 32);
//            avlTree.add(oneChar[0], 1);
//        }
//
//        String deleteChars = ":;<=>?@[\\]^_` .,/";
//        for (int i = 0; i < deleteChars.length(); i++) {
//            deleteChars.getChars(i, i + 1, oneChar, j);
//            avlTree.delete(oneChar[0]);
//        }
//
//        fileReaderWriter.writeToOutputFile(avlTree.traverse());
//    }
//}