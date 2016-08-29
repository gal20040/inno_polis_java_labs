package codetest.edu.innopolis.ru.Maze;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Statement
 Given a maze 5x5 in a text file, find the path from S (start) to F (finish).
 There will always be at most one possible way without repetitions. Maze is printed in a text file input.txt.

 0 - empty (can go)
 1 - wall (cannot go there)
 S - starting point
 F - finish

 You can only move by one cell up, down, left or right. Implement sort of non-recursive backtracking algorithm:
 https://www.cis.upenn.edu/~matuszek/cit594-2012/Pages/backtracking.html, using java.util.Stack class.
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
public class Maze {
    private static Stack<Node> stack = new Stack<>();

    public static void main(String[] args) {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        ArrayList<Integer> inputArray = fileReaderWriter.readFromInputFile();

//        char c;
//        int rowInc = 0, columnInc = 0;
        int tempCell, placeInRow = 0;
        String tempCellInString;
        ColumnArray labyrinth = new ColumnArray(); //main array
        RowArray tempRowArray = new RowArray('A');
        for (int i = 0; i < inputArray.size(); i++) {
            tempCell = inputArray.get(i);
            tempCellInString = (char) (tempCell) + "";
            if (tempCell == 13) { //EOL
                labyrinth.columnArray.add(tempRowArray); //add new row to the main array
                tempRowArray = new RowArray((char) (tempRowArray.rowTitle + 1)); //clear the temp array
                placeInRow = 0;
            } else if (tempCellInString.equals("1")
                    || tempCellInString.equals("0")
                    || tempCellInString.equals("S")
                    || tempCellInString.equals("F")) {
                tempRowArray.rowArray.add(new Cell(tempCellInString, placeInRow));
                placeInRow++;
            } //all other tempCells we throw away
        }
        labyrinth.columnArray.add(tempRowArray); //add new row to the main array

        System.out.println("  12345");
        for (RowArray rowArray : labyrinth.columnArray) {
            System.out.print(rowArray.rowTitle + " ");
            for (Cell cell : rowArray.rowArray) {
                System.out.print(cell.title);
            }
            System.out.println();
        }
    }

    private static class Cell {
        String title;
        int placeInRow;
        Cell(String title, int placeInRow) {
            this.title = title;
            this.placeInRow = placeInRow;
        }
    }
    private static class RowArray {
        ArrayList<Cell> rowArray = new ArrayList<>();
        char rowTitle;
        RowArray(char rowTitle) {
            this.rowTitle = rowTitle;
        }
    }
    private static class ColumnArray {
        ArrayList<RowArray> columnArray = new ArrayList<>();
        char columnTitle;
        ColumnArray() {
        }
    }



//        Stack stack = new Stack<>();
//        stack.peek()

    private class Node {
        boolean isLeaf;
        String title;
        String x, y;

        Node(String title, String x, String y) {
            this.title = title;
            this.x = x;
            this.y = y;
        }
    }

//    boolean solve(Node n) {
//        stack.push(n); //    put node n on the stack;
//        while (!stack.empty()){ //    while the stack is not empty {
//            n = stack.peek();
//            if (n.title.equals("S") ||
//                    n.title.equals("0") ||
//                    n.title.equals("F")) { //        if the node at the top of the stack is a leaf {
//                if (n.title.equals("F")) { //            if it is a goal node, return true
//                    return true;
//                } else { //            else pop it off the stack
//                    stack.pop();
//                }
//            } else{
//                if (the node at the top of the stack has untried children) { //if the node at the top of the stack has untried children
//                    stack.push(???); //push the next untried child onto the stack;
//                } else { //            else pop the node off the stack
//                    stack.pop();
//                }
//            }
//            return false;
//        }
//    }


//    boolean solve(Node n) {
//        if (n is a leaf node) {
//            if (the leaf is a goal node) {
//                print n;
//                return true;
//            } else return false;
//        } else {
//            for (each child c of n) {
//                if (solve(c) succeeds) {
//                    print n;
//                    return true;
//                }
//            }
//            return false;
//        }
//    }

/*        boolean solve(Node n) {
            if n is a leaf node {
                if the leaf is a goal node {
                    print n
                    return true
                }
        else return false
            } else {
                for each child c of n {
                    if solve(c) succeeds {
                        print n
                        return true
                    }
                }
                return false
            }
        }*/

    private static class FileReaderWriter {
        FileReaderWriter() {}

        ArrayList<Integer> readFromInputFile() {
            ArrayList<Integer> inputArray = new ArrayList<>();

            InputStream in = null;
            try {
                String inputFileName = "input.txt";
                in = new BufferedInputStream(new FileInputStream(inputFileName));
                int data;

                data = in.read();
                while (data != -1) {
                    inputArray.add(data);
                    data = in.read();
                }
            } catch (IOException e) {}
            finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {}
                }
            }

            return inputArray;
        }

        void writeToOutputFile(String outputString) {
            FileWriter out = null;
            try {
                String outputFileName = "output.txt";
                out = new FileWriter(outputFileName);
                out.write(outputString);
            } catch (IOException e) {}
            finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {}
                }
            }
        }
    }
}