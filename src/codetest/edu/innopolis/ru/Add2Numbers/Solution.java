package codetest.edu.innopolis.ru.Add2Numbers;

import java.io.*;

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

public class Solution {
    public static void main(String[] args) {
        int tempInt = -999999999; /*it's for case if one of the number equals zero. The best solution: tempInt must be equal the minimum integer number, but I'm lazy now to find out it.*/
        int[] array = {tempInt, tempInt};

        InputStream in = null;
        FileWriter out = null;
        try {
            String inputFileName = "input.txt";
            in = new BufferedInputStream(new FileInputStream(inputFileName));
            int data, i = 0;

            data = in.read();
            array[i] = 0;
            while (data != -1) {
                if (data == 32) { //breakspace
                    i++;
                    array[i] = 0;
                } else {
                    array[i] = array[i] * 10 + Integer.parseInt((char) data + "");
                }
                data = in.read();
            }

            if (array[0] != tempInt && array[1] != tempInt) {
                String outputFileName = "output.txt";
                out = new FileWriter(outputFileName);
                out.write(array[0] + array[1] + "");
            }
        } catch (IOException e) {}
        finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {}
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {}
            }
        }
    }
}