package UI_2016.fall.ru.Assignment1.ShuntingYard;

import java.io.*;

class FileReaderWriter {
    FileReaderWriter() {}

    /* Realisation with MyLinkedQueue*/
    MyLinkedQueue<Integer> readFromInputFile() {
        MyLinkedQueue<Integer> inputQueue = new MyLinkedQueue<>();

        InputStream in = null;
        try {
            String inputFileName = "input.txt";
            in = new BufferedInputStream(new FileInputStream(inputFileName));
            int data;

            data = in.read();
            while (data != -1) {
                inputQueue.enqueue(data);
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

        return inputQueue;
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

    /* Realisation with ArrayList
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
    }*/
}