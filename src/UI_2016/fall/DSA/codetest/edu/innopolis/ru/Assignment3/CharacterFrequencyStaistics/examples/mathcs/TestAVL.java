package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment3.CharacterFrequencyStaistics.examples.mathcs;

import java.util.Scanner;

public class TestAVL
{
    public static void main(String[] args)
    {
        AVL_BST x = new AVL_BST();
        // Key = String, Value = String

        x.put("lion", 9999);
        x.printBST();
        x.put("dog",  1000);
        x.printBST();
        x.put("cat", 500);
        x.printBST();
        x.put("tiger", 8888);
        x.printBST();
        x.put("zebra", 1600);
        x.printBST();
        x.put("horse", 2000);
        x.printBST();
        x.put("ape", 1500);
        x.printBST();
        x.put("bear", 7000);
        x.printBST();
/*
      x.put("cow", 700);
      x.printBST();
      x.put("donkey", 1900);
      x.printBST();
      x.put("jackal", 4000);
      x.printBST();
      x.put("owl", 2000);
      x.printBST();
      x.put("man", 5000);
      x.printBST();
*/

/*
      x.remove("owl");
      x.printBST();

      x.remove("dog");
      x.printBST();
*/

/*

      String k;
      Integer v;
      Scanner in = new Scanner(System.in);
      while ( true )
      {
         System.out.print("\n\nEnter a key to search on ==> ");
         k = in.next();
         v = x.get( k );
         System.out.println("Key = " + k + " ==> get() returns: " + v);
      }
*/
    }
}