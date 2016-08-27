package codetest.edu.innopolis.ru.Maze;

/**
 * Statement
 Given a maze 5x5 in a text file, find the path from S (start) to F (finish).
 There will always be at most one possible way without repetitions. Maze is printed in a text file input.txt.

 0 - empty (can go)
 1 - wall (cannot go there)
 S - starting point
 F - finish

 You can only move by one cell up, down, left or right. Implement sort of non-recursive backtracking algorithm:
 https://www.cis.upenn.edu/~matuszek/cit594-2012/Pages/backtracking.html) using java.util.Stack class.
 Lines are LETTERS from A to E, columns are NUMBERS from 1 to 5.
 Find the way out and print it to output.txt separated by spaces. If there's no way - print "NO WAY".

 Example #1
 input.txt
 11111
 S0011
 11111
 11011
 110F1

 output.txt
 NO WAY


 Example #2
 input.txt
 11111
 S0011
 11000
 11011
 110F1

 output.txt
 B1 B2 B3 C3 D3 E3 E4
 */
public class Solution {
    public static void main(String[] args) {

    }
}
