//package codetest.edu.innopolis.ru.Add2Numbers;

import java.io.*;
import java.util.ArrayList;

/*
Statement
Add 2 integer numbers writter in input.txt file. They are situated in one line separated by space.
Write result to output.txt.

Example
input.txt
12 13
output.txt
25
 */
public class Add2Numbers_new {
    public static void main(String[] args) {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        ArrayList<Integer> inputArray = fileReaderWriter.readFromInputFile();
        String outputString;

        int temp;
        int tempInt = -999999999; /*it's for case if one of the number equals zero. The best solution: tempInt must be equal the minimum integer number, but I'm lazy now to find out it.*/
        int[] array = {tempInt, tempInt};
        int sign = 1; //1-for positive numbers; -1-for negative numbers
        int arrayIncrementor = 0;
        String tempString = "";

        array[0] = 0;
        for (int i = 0; i < inputArray.size(); i++) {
            temp = inputArray.get(i);
            if (temp != -1) { //if it's not EndOfLine
                if (temp == 32) {//breakspace
                    array[arrayIncrementor] = sign * Integer.parseInt(tempString, 10);

                    tempString = "";
                    arrayIncrementor++;
                    array[arrayIncrementor] = 0;
                    sign = 1; //default value
                } else if (temp == 45) {//minus
                    sign = -1; //negative number
                } else if (temp >= 48 && temp <= 57) {
                    tempString = tempString + (char) temp;
                }
            }
        }
        array[arrayIncrementor] = sign * Integer.parseInt(tempString);

        if (array[0] != tempInt && array[1] != tempInt) {
            outputString = array[0] + array[1] + "";
            fileReaderWriter.writeToOutputFile(outputString);
        }
    }

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

        private void writeToOutputFile(String outputString) {
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