//package DSA.ru.Maze;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Stack;
//
///**
// * Statement
// Given a maze 5x5 in a text file, find the path from S (start) to F (finish).
// There will always be at most one possible way without repetitions. Maze is printed in a text file input.txt.
//
// 0 - empty (can go)
// 1 - wall (cannot go there)
// S - starting point
// F - finish
//
// You can only move by one cell up, down, left or right. Implement sort of non-recursive backtracking algorithm:
// https://www.cis.upenn.edu/~matuszek/cit594-2012/Pages/backtracking.html, using java.util.Stack class.
// Lines are LETTERS from A to E, columns are NUMBERS from 1 to 5.
// Find the way out and print it to output.txt separated by spaces. If there's no way - print "NO WAY".
//
// Example #1
// input.txt
// 11111
// S0011
// 11111
// 11011
// 110F1
//
// output.txt
// NO WAY
//
// Example #2
// input.txt
// 11111
// S0011
// 11000
// 11011
// 110F1
//
// output.txt
// B1 B2 B3 C3 D3 E3 E4
// */
//public class Maze {
//    //Это не до конца рабочая программа, я закомментировал её, потому что она мешается другим подпроектам
//    private static Stack<Cell> stack = new Stack<>();
//    private static ColumnArray labyrinth = new ColumnArray(); //main array
//    private static Cell startingCell;
//    private static int maxRowNumber = 4, maxPlaceInRow = 4;
//    private static String outputString = "";
//
//    public static void main(String[] args) {
//        createLabyrinth();
//        solve(startingCell);
//        System.out.println();
//        System.out.println(outputString);
//    }
//
//    private static class Cell {
//        String title;
//        char rowTitle;
//        int rowNumber; //rowTitle and rowNumber are for the same goal
//        int placeInRow; //placeInRow counts from 0 till k
//        boolean isSearched;
//        String check;
//        Cell(String title, int rowNumber, int placeInRow) {
//            this.rowTitle = (char) (65 + rowNumber);
//            this.title = title;
//            this.rowNumber = rowNumber;
//            this.placeInRow = placeInRow;
//            this.isSearched = false;
//            this.check = "";
//        }
//    }
//    private static class RowArray {
//        ArrayList<Cell> rowArray = new ArrayList<>();
//        char rowTitle;
//        int rowNumber; //rowTitle and rowNumber are for the same goal
//        //rowNumber counts from 0 till n
//        RowArray(char rowTitle, int rowNumber) {
//            this.rowTitle = rowTitle;
//            this.rowNumber = rowNumber;
//        }
//    }
//    private static class ColumnArray {
//        ArrayList<RowArray> columnArray = new ArrayList<>();
//        ColumnArray() {}
//    }
//
//    private static void createLabyrinth() {
//        FileReaderWriter fileReaderWriter = new FileReaderWriter();
//        ArrayList<Integer> inputArray = fileReaderWriter.readFromInputFile();
//
////        char c;
////        int rowInc = 0, columnInc = 0;
//        int tempCell, placeInRow = 0;
//        String tempCellInString;
//        RowArray tempRowArray = new RowArray('A', 0);
//        for (int i = 0; i < inputArray.size(); i++) {
//            tempCell = inputArray.get(i);
//            tempCellInString = (char) (tempCell) + "";
//            if (tempCell == 13) { //EOL
//                labyrinth.columnArray.add(tempRowArray); //add new row to the main array
//
//                //clear the temp array
//                tempRowArray = new RowArray((char) (tempRowArray.rowTitle + 1), tempRowArray.rowNumber + 1);
//
//                placeInRow = 0;
//            } else if (tempCellInString.equals("1")
//                    || tempCellInString.equals("0")
//                    || tempCellInString.equals("S")
//                    || tempCellInString.equals("F")) {
//
//                if (tempCellInString.equals("S")) {
////                    System.out.println("rowNumber="+tempRowArray.rowNumber + " " + "placeInRow="+placeInRow);
//                    startingCell = new Cell(tempCellInString, tempRowArray.rowNumber, placeInRow);
//                }
//
//                tempRowArray.rowArray.add(new Cell(tempCellInString, tempRowArray.rowNumber, placeInRow));
//                placeInRow++;
//            } //all other tempCells we throw away
//        }
//        labyrinth.columnArray.add(tempRowArray); //add new row to the main array
//
//        System.out.println("  12345");
//        for (RowArray rowArray : labyrinth.columnArray) {
//            System.out.print(rowArray.rowTitle + " ");
//            for (Cell cell : rowArray.rowArray) {
//                System.out.print(cell.title);
//            }
//            System.out.println();
//        }
//    }
//
//    private static Cell getCell(int rowNumber, int placeInRow) {
////        System.out.println("rowNumber="+rowNumber + " " + "placeInRow="+placeInRow);
//        return labyrinth.columnArray.get(rowNumber).rowArray.get(placeInRow);
//    }
//
//    private static void setIsChecked(int rowNumber, int placeInRow) {
//        Cell cell = labyrinth.columnArray.get(rowNumber).rowArray.get(placeInRow);
//        cell.isSearched = true;
//    }
//
//
////        Stack stack = new Stack<>();
////        stack.peek()
//
////    private class Node {
////        boolean isLeaf;
////        String title;
////        String x, y;
////
////        Node(String title, String x, String y) {
////            this.title = title;
////            this.x = x;
////            this.y = y;
////        }
////    }
//
//    private static boolean solve(Cell cell) {
////        if (counter <= 0) return false;
//        Cell tempCell;
//        System.out.print("title="+cell.title + " ");
////        System.out.print("isSearched="+cell.isSearched + " ");
//        stack.push(cell); //push cell on the stack;
//        while (!stack.empty()){ //    while the stack is not empty {
//            cell = stack.peek();
////            cell.check = "checked";
////            cell.isSearched = true;
//
////            System.out.print("title="+getCell(1, 0).title + " ");
////            System.out.print("check="+getCell(1, 0).check + " ");
////
////            System.out.print("title="+cell.title + " ");
////            System.out.print("check="+cell.check + " ");
////            System.out.print();
//            System.out.print("rowNumber="+(cell.rowNumber+1) + " " + "placeInRow="+(cell.placeInRow+1) + " ");
//            if (cell.title.equals("F")) {
//                System.out.println();
////                System.out.println("F " + (cell.rowNumber+1) + " " + (cell.placeInRow+1) + " ");
//                return true; //if the cell is a goal, then return true
//            } else if (cell.title.equals("S")
//                    || cell.title.equals("0")) { //if the cell equals S or 0, then search for untried children
//                setIsChecked(cell.rowNumber, cell.placeInRow);
////                System.out.print("title="+getCell(cell.rowNumber, cell.placeInRow).title + " ");
////                System.out.print("isSearched="+getCell(cell.rowNumber, cell.placeInRow).isSearched + " ");
////                cell.isSearched = true;
//                if (cell.rowNumber - 1 >= 0) {
//                    tempCell = getCell(cell.rowNumber - 1, cell.placeInRow);
//                    if (!tempCell.title.equals("1")
//                            && !tempCell.isSearched) {
//                        System.out.println("up");
//                        boolean bool = solve(tempCell);
//                        System.out.print("bool=" + bool);
//                        if (bool) {//run new cycle for new cell
////                            System.out.println(tempCell.title
////                                    + " " + (tempCell.rowNumber+1)
////                                    + " " + (tempCell.placeInRow+1) + " ");
//                            outputString = tempCell.rowTitle + "" + (tempCell.placeInRow+1) + " " + outputString;
//                            System.out.println(outputString);
//                            return true;
//                        } else return false;
////                        stack.push(tempCell); //push cell on the stack;
//                    }
//                }
//                if (cell.rowNumber + 1 <= maxRowNumber) {
//                    tempCell = getCell(cell.rowNumber + 1, cell.placeInRow);
//                    if (!tempCell.title.equals("1")
//                            && !tempCell.isSearched) {
//                        System.out.println("down");
//                        boolean bool = solve(tempCell);
//                        System.out.print("bool=" + bool);
//                        if (bool) {//run new cycle for new cell
//                            outputString = tempCell.rowTitle + "" + (tempCell.placeInRow+1) + " " + outputString;
//                            System.out.println(outputString);
//                            return true;
//                        } else return false;
////                        stack.push(tempCell); //push cell on the stack;
//                    }
//                }
//                if (cell.placeInRow - 1 >= 0) {
//                    tempCell = getCell(cell.rowNumber, cell.placeInRow - 1);
//                    if (!tempCell.title.equals("1")
//                            && !tempCell.isSearched) {
//                        System.out.println("left");
//                        boolean bool = solve(tempCell);
//                        System.out.print("bool=" + bool);
//                        if (bool) {//run new cycle for new cell
//                            outputString = tempCell.rowTitle + "" + (tempCell.placeInRow+1) + " " + outputString;
//                            System.out.println(outputString);
//                            return true;
//                        } else return false;
////                        stack.push(tempCell); //push cell on the stack;
//                    }
//                }
//                if (cell.placeInRow + 1 <= maxPlaceInRow) {
//                    tempCell = getCell(cell.rowNumber, cell.placeInRow + 1);
//                    if (!tempCell.title.equals("1")
//                            && !tempCell.isSearched) {
//                        System.out.println("right");
//                        boolean bool = solve(tempCell);
//                        System.out.print("bool=" + bool);
//                        if (bool == true) {//run new cycle for new cell
//                            outputString = tempCell.rowTitle + "" + (tempCell.placeInRow+1) + " " + outputString;
//                            System.out.println(outputString);
//                            return true;
//                        } else return false;
////                        stack.push(tempCell); //push cell on the stack;
//                    }
//                }
//
//                System.out.println("stack.pop()");
//                stack.pop(); //else pop it off the stack
//            }
//        }
//        return false;
//    }
//
//
////    boolean solve(Node n) {
////        if (n is a leaf node) {
////            if (the leaf is a goal node) {
////                print n;
////                return true;
////            } else return false;
////        } else {
////            for (each child c of n) {
////                if (solve(c) succeeds) {
////                    print n;
////                    return true;
////                }
////            }
////            return false;
////        }
////    }
//
///*        boolean solve(Node n) {
//            if n is a leaf node {
//                if the leaf is a goal node {
//                    print n
//                    return true
//                }
//        else return false
//            } else {
//                for each child c of n {
//                    if solve(c) succeeds {
//                        print n
//                        return true
//                    }
//                }
//                return false
//            }
//        }*/
//
//    private static class FileReaderWriter {
//        FileReaderWriter() {}
//
//        private ArrayList<Integer> readFromInputFile() {
//            ArrayList<Integer> inputArray = new ArrayList<>();
//
//            InputStream in = null;
//            try {
//                String inputFileName = "input.txt";
//                in = new BufferedInputStream(new FileInputStream(inputFileName));
//                int data;
//
//                data = in.read();
//                while (data != -1) {
//                    inputArray.add(data);
//                    data = in.read();
//                }
//            } catch (IOException e) {}
//            finally {
//                if (in != null) {
//                    try {
//                        in.close();
//                    } catch (IOException e) {}
//                }
//            }
//
//            return inputArray;
//        }
//
//        private void writeToOutputFile(String outputString) {
//            FileWriter out = null;
//            try {
//                String outputFileName = "output.txt";
//                out = new FileWriter(outputFileName);
//                out.write(outputString);
//            } catch (IOException e) {}
//            finally {
//                if (out != null) {
//                    try {
//                        out.close();
//                    } catch (IOException e) {}
//                }
//            }
//        }
//    }
//}