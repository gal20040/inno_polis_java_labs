package codetest.edu.innopolis.ru.ControlSequence;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Statement:
 * In a string you have a control sequence like this: "LRRDU" (left, right, right, down, up).
 * Each symbol moves you like this L=(-1, 0), R=(1,0), U=(0,1), D=(0,-1).
 * Starting from (0,0), calculate your final destination. Read control sequence from the file input.txt.
 * Write final position to output.txt.

 Example:

 input.txt
 LLLUU

 output.txt
 -3 2
 */
public class Solution {
    public static void main(String[] args) {
        String fileName = "input.txt";
        int currentX = 0, currentY = 0;

        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(fileName));
            int data;

            data = in.read();
            while (data != -1) {
                switch ((char) data) {
                    case 'L':
                        currentX--;
                        break;
                    case 'R':
                        currentX++;
                        break;
                    case 'D':
                        currentY--;
                        break;
                    case 'U':
                        currentY++;
                        break;
                }
                data = in.read();
            }
            System.out.println(currentX + " " + currentY);

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