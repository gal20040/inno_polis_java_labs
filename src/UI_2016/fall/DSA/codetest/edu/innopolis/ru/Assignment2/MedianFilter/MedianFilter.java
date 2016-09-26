//package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment2.MedianFilter;
//
//import java.util.ArrayList;
//
///*
//Statement
//2 points
//Median filter is an edge-preserving denoising filter used to filter 1D and 2D data.
//It can efficiently suppress impulse outbreaks in signal.
//Implement median filter for 1D integer signal with boundary elements repetition for edge problem.
//Implement some efficient sorting algorithm to be used for median selection.
//Your filter implementation can support only odd window size (3, 5, 7, ...).
//input.txt stores input signal in the first line, and window size in the second. output.txt stores
//filtered signal - the same number of items as in the input array.
//
//Example
//input.txt
//1 2 3 100001 4 5
//3
//output.txt
//1 2 3 4 5 5
//
//1 43 22 22 51 49 87 72 119 106 117 106 136 11 125 177 185 160 196 208 214 221 220 248 2036 278 253 280 269 277 330 313
//11
//1 22 22 43 49 51 72 87 87 106 106 117 119 125 136 160 177 185 196 208 214 220 221 248 253 269 277 278 280 313 313 313
//
//1 43 22 22 51 49 87 72 119 106 117 106 136 11 125 177 185 160 196 208 214 221 220 248 2036 278 253 280 269 277 330 313
//5
//1 22 22 43 49 51 72 87 106 106 117 106 117 125 136 160 177 185 196 208 214 220 221 248 253 278 278 277 277 280 313 313
//*/
//
//public class MedianFilter {
//    private static ArrayList<Integer> inputList = new ArrayList<>();
//    private static String outputString = "";
//    private static int windowsSize;
//    private static ArrayList<Integer> windowArrayList = new ArrayList<>(windowsSize);
//
//    public static void main(String[] args) {
//        getInputElements();
//
////        for (int i = 0; i < inputList.size(); i++) {
////            outputString = outputString + inputList.get(i) + " ";
////        }
////        outputString = outputString + "windowsSize=" + windowsSize;
//
//        doMedianFilter();
//
//        FileReaderWriter fileReaderWriter = new FileReaderWriter();
//        fileReaderWriter.writeToOutputFile(outputString);
//    }
//
//    private static void doMedianFilter() {
//        QuickSortAlgorithm quickSortAlgorithm = new QuickSortAlgorithm();
//
//        for (int i = windowsSize / 2; i < inputList.size() - windowsSize / 2; i++) {
//            windowArrayList.clear();
//            int mainI = i;
//            for (int j = 0; j < windowsSize; j++) {
//                windowArrayList.add(inputList.get(mainI - windowsSize / 2));
//                mainI++;
//            }
//            quickSortAlgorithm.quickSort(windowArrayList);
//
//            outputString = outputString + windowArrayList.get(windowsSize/2) + " ";
//        }
//    }
//
//    private static void getInputElements() {
//        FileReaderWriter fileReaderWriter = new FileReaderWriter();
//        inputList = fileReaderWriter.readFromInputFile(inputList);
//
//        windowsSize = inputList.get(inputList.size() - 1);
//        inputList.remove(inputList.size() - 1);
//
//        int firstElement = inputList.get(0);
//        int lastElement = inputList.get(inputList.size() - 1);
//        for (int i = 0; i < windowsSize / 2; i++) {
//            inputList.add(0, firstElement);
//            inputList.add(lastElement);
//        }
//    }
//}