//package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment3.CharacterFrequencyStaistics;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
//
//class FileReaderWriter {
//    String readFromInputFile() {
//        String inputString = "";
//        Scanner scanner = null;
//        try {
//            String inputFileName = "input.txt";
//            scanner = new Scanner(new FileInputStream(inputFileName));
//
//            inputString = scanner.nextLine();
//
//        } catch (FileNotFoundException e) {
//            assert false : "Input file has not been found.";
//        } finally {
//            if (scanner != null)
//                scanner.close();
//        }
//
//        return inputString;
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