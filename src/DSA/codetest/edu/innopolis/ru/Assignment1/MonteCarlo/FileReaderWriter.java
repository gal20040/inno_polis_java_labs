package DSA.codetest.edu.innopolis.ru.Assignment1.MonteCarlo;

import java.io.*;
import java.util.ArrayList;

class FileReaderWriter {
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
        } catch (IOException e) {
            System.out.println("Input file has not been found.");
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("There is no BufferedInputStream. Nothing to close.");
                }
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
        } catch (IOException e) {
            System.out.println("Some problem with output file.");
        }
        finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("There is no FileWriter. Nothing to close.");
                }
            }
        }
    }
}