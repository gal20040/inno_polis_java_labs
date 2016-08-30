////package DSA.ru.Add2Numbers;
//
//import java.io.*;
//
///*
//Statement
//Add 2 integer numbers writter in input.txt file. They are situated in one line separated by space.
//Write result to output.txt.
//
//Example
//input.txt
//12 13
//output.txt
//25
// */
//
//public class Add2Numbers2 {
//    public static void main(String[] args) {
//        int tempInt = -999999999; /*it's for case if one of the number equals zero. The best solution: tempInt must be equal the minimum integer number, but I'm lazy now to find out it.*/
//        int[] array = {tempInt, tempInt};
//
//        InputStream in = null;
//        FileWriter out = null;
//        try {
//            String inputFileName = "input.txt";
//            in = new BufferedInputStream(new FileInputStream(inputFileName));
//            int data, i = 0;
//            int sign = 1; //1-for positive numbers; -1-for negative numbers
//
//            data = in.read();
//            array[0] = 0;
//            while (data != -1) {
//                if (data == 32) { //breakspace
//                    i++;
//                    array[i] = 0;
//                    sign = 1; //default value
//                } else if (data == 45) { //minus
//                    sign = -1; //negative number
//                } else {
//                    char c = (char) data;
//                    String s = "" + c;
//                    if (sign == 1) {
//                        s = "+" + c;
//                    }
//                    Integer v = Integer.parseInt(s);
//                    int ai = array[i] * 10;
//                    ai = Math.abs(ai);
//                    ai = ai + v;
//                    array[i] = sign * ai;
//                }
//                data = in.read();
//            }
//
//            if (array[0] != tempInt && array[1] != tempInt) {
//                String outputFileName = "output.txt";
//                out = new FileWriter(outputFileName);
//                out.write(array[0] + array[1] + "");
//            }
//        } catch (IOException e) {}
//        finally {
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException e) {}
//            }
//
//            if (out != null) {
//                try {
//                    out.close();
//                } catch (IOException e) {}
//            }
//        }
//    }
//}