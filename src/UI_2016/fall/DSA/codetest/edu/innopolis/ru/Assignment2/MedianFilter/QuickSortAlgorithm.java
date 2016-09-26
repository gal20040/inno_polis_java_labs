//package UI_2016.fall.DSA.codetest.edu.innopolis.ru.Assignment2.MedianFilter;
//
//import java.util.ArrayList;
//
//class QuickSortAlgorithm {
//    private static ArrayList<Integer> integerArrayList = new ArrayList<>();
//
//    void quickSort(ArrayList<Integer> list) {
//        integerArrayList = list;
//        int firstIndex = 0;
//        int lastIndex = integerArrayList.size() - 1;
//        doSort(firstIndex, lastIndex);
//    }
//
//    private void doSort(int firstIndex, int lastIndex) {
//        if (firstIndex < lastIndex) {
//            int i = firstIndex, j = lastIndex;
//            int supportElementIndex = i + (j - i) / 2;
//            while (i < j) {
//                while (i < supportElementIndex
//                        && (integerArrayList.get(i) <= integerArrayList.get(supportElementIndex)))
//                    i++;
//                while (j > supportElementIndex
//                        && (integerArrayList.get(supportElementIndex) <= integerArrayList.get(j)))
//                    j--;
//                if (i < j) {
//                    int temp = integerArrayList.get(i);
//                    integerArrayList.set(i, integerArrayList.get(j));
//                    integerArrayList.set(j, temp);
//                    if (i == supportElementIndex)
//                        supportElementIndex = j;
//                    else if (j == supportElementIndex)
//                        supportElementIndex = i;
//                }
//            }
//            doSort(firstIndex, supportElementIndex);
//            doSort(supportElementIndex + 1, lastIndex);
//        }
//    }
//}