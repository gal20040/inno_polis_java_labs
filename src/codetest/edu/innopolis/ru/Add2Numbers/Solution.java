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
        String fileName = "input.txt";

        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(fileName));
            int data, i = 0;
            int[] array = {0, 0};

            data = in.read();
            while (data != -1) {
                if (data == 32) { //breakspace
                    i++;
                } else {
                    array[i] = array[i] * 10 + Integer.parseInt((char) data + "");
                }
                data = in.read();
            }
            System.out.println(array[0] + array[1]);
        } catch (IOException e) {}
        finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {}
            }
        }
    }
}