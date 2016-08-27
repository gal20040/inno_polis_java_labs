package codetest.edu.innopolis.ru.ToUpperCase;

import codetest.edu.innopolis.ru.FileReaderWriter.FileReaderWriter;
import java.util.ArrayList;

/**
 * Statement
 Bring all text in the string provided in the file input.txt to upper case. Write result to output.txt.

 Example
 input.txt
 Lazy fOX

 output.txt
 LAZY FOX
 */
public class Solution {
    public static void main(String[] args) {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        ArrayList<Integer> inputArray = fileReaderWriter.readFromInputFile();
        int temp;
        String outputString = "";

        for (int i = 0; i < inputArray.size(); i++) {
            temp = inputArray.get(i);
            if (temp >= 97 && temp <= 122) {
                inputArray.remove(i);
                inputArray.add(i, temp - 32);
            }
            outputString += (char) (inputArray.get(i) + 0);
        }

        fileReaderWriter.writeToOutputFile(outputString);
    }
}