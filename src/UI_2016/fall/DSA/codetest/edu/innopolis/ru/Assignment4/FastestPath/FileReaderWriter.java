////package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment4.FastestPath;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//class FileReaderWriter {
//    ArrayList<String> readFromInputFile(String inputFileName) {
//        assert (inputFileName != null
//                || !inputFileName.equals(""))
//                : "inputFileName != null || !inputFileName.equals('')";
//
//        ArrayList<String> inputList = new ArrayList<>();
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new FileInputStream(inputFileName));
//
//            while (scanner.hasNextLine())
//                inputList.add(scanner.nextLine());
//
//        } catch (FileNotFoundException e) {
//            assert false : "Input file has not been found.";
//        } finally {
//            if (scanner != null)
//                scanner.close();
//        }
//
//        return inputList;
//    }
//
//    void writeToOutputFile(String outputString) {
//        FileWriter out = null;
//        try {
//            String outputFileName = "output.txt";
//            out = new FileWriter(outputFileName);
//            out.write(outputString);
//        } catch (IOException e) {
//            assert false : "Some problem with output file: IOException.";
//        }
//        finally {
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    assert false : "There is no FileWriter.";
//                }
//            }
//        }
//    }
//}