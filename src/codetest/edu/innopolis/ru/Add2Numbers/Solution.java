package codetest.edu.innopolis.ru.Add2Numbers;

import java.util.Scanner;

/**
 * Statement:
 Add 2 integer numbers writter in input.txt file. They are situated in one line separated by space.
 Write result to output.txt.

 Example
 input.txt
 12 13

 output.txt
 25
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        System.out.println(x + y);
    }
}