package codetest.edu.innopolis.ru.ControlSequence;

import java.util.Scanner;

/**
 * Statement:
 * In a string you have a control sequence like this: "LRRDU" (left, right, right, down, up).
 * Each symbol moves you like this L=(-1, 0), R=(1,0), U=(0,1), D=(0,-1).
 * Starting from (0,0), calculate your final destination. Read control sequence from the file input.txt.
 * Write final position to output.txt.

 Example:

 input.txt
 LLLUU

 output.txt
 -3 2
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialX = 0, initialY = 0;

        System.out.println("What is control sequence?");
        String sequence = scanner.nextLine();

        for (int i = 0; i < sequence.length(); i++) {
            char c = sequence.charAt(i);

//            switch (month) {//если month=3, то будет выполнен именно case 3
//                case 1:
//                    System.out.println("January");
//                    break;
//                case 2:
//                    System.out.println("February");
//                    break;
//                case 3:
//                    System.out.println("March");
//                    break; //break нужен, чтобы не выполнялись последующие case
//                case 4:
//                    System.out.println("April"); break;
//            }
        }
    }
}