package codetest.edu.innopolis.ru.FileReaderWriter;

import java.io.*;
import java.util.ArrayList;

public class FileReaderWriter {
    public FileReaderWriter() {}

    public ArrayList<Integer> readFromInputFile() {
        ArrayList<Integer> inputArray = new ArrayList<Integer>();

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

    public void writeToOutputFile(String outputString) {
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