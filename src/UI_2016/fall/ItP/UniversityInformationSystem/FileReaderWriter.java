package UI_2016.fall.ItP.UniversityInformationSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class FileReaderWriter {
    ArrayList<String> readFromInputFile() {
        String inputFileName = "input.txt";
        return readFromInputFile(inputFileName);
    }

    ArrayList<String> readFromInputFile(String inputFileName) {
        ArrayList<String> inputList = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(inputFileName));

            while (scanner.hasNextLine())
                inputList.add(scanner.nextLine());

        } catch (FileNotFoundException e) {
            assert false : "Input file '" + inputFileName + "' has not been found. Try to put it in the root of IDE project.";
        } finally {
            if (scanner != null)
                scanner.close();
        }

        return inputList;
    }

    void writeToOutputFile(String outputString) {
        String outputFileName = "output.txt";
        writeToOutputFile(outputString, outputFileName);
    }

    void writeToOutputFile(String outputString, String outputFileName) {
        FileWriter out = null;
        try {
            out = new FileWriter(outputFileName);
            out.write(outputString);
        } catch (IOException e) {
            assert false : "Some problem with output file: IOException.";
        }
        finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    assert false : "There is no FileWriter.";
                }
            }
        }
    }
}