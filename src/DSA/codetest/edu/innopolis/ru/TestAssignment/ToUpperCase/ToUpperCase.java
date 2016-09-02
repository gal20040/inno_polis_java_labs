////package DSA.ru.ToUpperCase;
//
//import java.io.*;
//import java.util.ArrayList;
//
///**
// * Statement
// Bring all text in the string provided in the file input.txt to upper case. Write result to output.txt.
//
// Example
// input.txt
// Lazy fOX
//
// output.txt
// LAZY FOX
// */
//class ToUpperCase {
//    //Это рабочая программа, но я закомментировал её, потому что она мешается другим подпроектам
//    public static void main(String[] args) {
//        FileReaderWriter fileReaderWriter = new FileReaderWriter();
//        ArrayList<Integer> inputArray = fileReaderWriter.readFromInputFile();
//        int temp;
//        String outputString = "";
//
//        for (int i = 0; i < inputArray.size(); i++) {
//            temp = inputArray.get(i);
//            if (temp >= 97 && temp <= 122) {
//                inputArray.remove(i);
//                inputArray.add(i, temp - 32);
//            }
//            outputString += (char) (inputArray.get(i) + 0);
//        }
//
//        fileReaderWriter.writeToOutputFile(outputString);
//    }
//
//    private static class FileReaderWriter {
//        private FileReaderWriter() {}
//
//        private ArrayList<Integer> readFromInputFile() {
//            ArrayList<Integer> inputArray = new ArrayList<Integer>();
//
//            InputStream in = null;
//            try {
//                String inputFileName = "input.txt";
//                in = new BufferedInputStream(new FileInputStream(inputFileName));
//                int data;
//
//                data = in.read();
//                while (data != -1) {
//                    inputArray.add(data);
//                    data = in.read();
//                }
//            } catch (IOException e) {}
//            finally {
//                if (in != null) {
//                    try {
//                        in.close();
//                    } catch (IOException e) {}
//                }
//            }
//
//            return inputArray;
//        }
//
//        private void writeToOutputFile(String outputString) {
//            FileWriter out = null;
//            try {
//                String outputFileName = "output.txt";
//                out = new FileWriter(outputFileName);
//                out.write(outputString);
//            } catch (IOException e) {}
//            finally {
//                if (out != null) {
//                    try {
//                        out.close();
//                    } catch (IOException e) {}
//                }
//            }
//        }
//    }
//}